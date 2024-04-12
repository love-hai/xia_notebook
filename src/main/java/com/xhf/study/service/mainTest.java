package com.xhf.study.service;

import com.xhf.study.model.TiktokProductCardDayCrawlDto;
import com.xhf.study.service.tool.MyStringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.*;

@Slf4j
public class mainTest {

    public static void main(String[] args) {
        mainTest mainTest = new mainTest();
        // 2024-04-02 ~ 2024-04-02
        Date date = new Date("2024/04/02");
        log.info("date:{}", date);
        String filePath = "D:\\work\\lalang-browser-2.0\\download\\product_list(1).xlsx";
        String result = mainTest.handleXlsx(filePath, date);
        log.info("result:{}", result);
    }

    private String handleXlsx(String filePath, Date date) {
        File file = new File(filePath);
        if (!file.exists()) {
            return filePath + "文件不存在";
        }
        // 检查是否是xlsx文件
        if (!filePath.endsWith(".xlsx") && !filePath.endsWith(".xls")) {
            return filePath + "不是excel文件";
        }
        Workbook workbook = null;
        try (FileInputStream fis = new FileInputStream(file)) {
            // 解析xlsx数据
            if (filePath.endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(fis);
            } else {
                workbook = new HSSFWorkbook(fis);
            }
            // 获取第一个sheet
            Sheet sheet = workbook.getSheetAt(0);
            return handleFirstSheet(sheet, date);
        } catch (Exception e) {
            log.error("解析xlsx数据失败", e);
            return "解析xlsx数据失败" + e.getMessage();
        } finally {
            if (null != workbook) {
                try {
                    workbook.close();
                } catch (Exception e) {
                    log.error("关闭workbook失败", e);
                }
            }
        }
    }

    private String handleFirstSheet(Sheet sheet, Date date) {
        if (sheet.getLastRowNum() <= 0) {
            return null;
        }
        Row firstRow = sheet.getRow(0);
        // 读取第一列
        Cell cell = firstRow.getCell(0);
        // 读取内容
        String firstCell = cell.getStringCellValue().trim();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        String month = (calendar.get(Calendar.MONTH) + 1) < 10 ? "0" + (calendar.get(Calendar.MONTH) + 1) : String.valueOf(calendar.get(Calendar.MONTH) + 1);
        String day = calendar.get(Calendar.DAY_OF_MONTH) < 10 ? "0" + calendar.get(Calendar.DAY_OF_MONTH) : String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        // 2024-03-12 ~ 2024-03-12
        String firstCellMust = calendar.get(Calendar.YEAR) + "-" + month + "-" + day + " ~ " + calendar.get(Calendar.YEAR) + "-" + month + "-" + day;
        if (!firstCell.equals(firstCellMust)) {
            return "文件第一行内容不是" + firstCellMust;
        }
        int headerRow = 2;
        Row header = sheet.getRow(headerRow);
        if (null == header) {
            return "文件第三行为空";
        }
        //ID
        int shopProductIdIndex = -1;
        // 商品卡片曝光次数
        int exposureNumberIndex = -1;
        // 商品卡片的页面浏览次数
        int browseNumberIndex = -1;
        // 商品卡片的去重页面浏览次数
        int reDuplicatesBrowseNumberIndex = -1;
        // 商品卡片去重买家数
        int reDuplicatesBuyerNumberIndex = -1;
        // 商品卡片点击率
        int clickRateIndex = -1;
        // 商品卡片转化率
        int conversionRateIndex = -1;
        for (Iterator<Cell> it = header.cellIterator(); it.hasNext(); ) {
            Cell cell1 = it.next();
            String cellValue = cell1.getStringCellValue().trim();
            switch (cellValue) {
                case "ID": {
                    shopProductIdIndex = cell1.getColumnIndex();
                    break;
                }

                case "商品卡片曝光次数": {
                    exposureNumberIndex = cell1.getColumnIndex();
                    break;
                }
                case "商品卡片的页面浏览次数" :{
                    browseNumberIndex = cell1.getColumnIndex();
                    break;
                }
                case "商品卡片的去重页面浏览次数" :{
                    reDuplicatesBrowseNumberIndex = cell1.getColumnIndex();
                    break;
                }
                case "商品卡片去重买家数" :{
                    reDuplicatesBuyerNumberIndex = cell1.getColumnIndex();
                    break;
                }
                case "商品卡片点击率" :{
                    clickRateIndex = cell1.getColumnIndex();
                    break;
                }
                case "商品卡片转化率" :{
                    conversionRateIndex = cell1.getColumnIndex();
                    break;
                }
            }
        }
        int startRow = headerRow + 1;
        int endRow = sheet.getLastRowNum();
        List<TiktokProductCardDayCrawlDto> list = new ArrayList<>();
        for (int i = startRow; i <= endRow; i++) {

            Row row = sheet.getRow(i);
            if (null == row) {
                continue;
            }
            String shopProductId = row.getCell(shopProductIdIndex).getStringCellValue();
            if (MyStringUtils.isEmpty(shopProductId)) {
                continue;
            }
            TiktokProductCardDayCrawlDto dto = new TiktokProductCardDayCrawlDto();
            dto.setShopCode("shopCode");
            dto.setBatchId(0L);
            dto.setAccount("account");
            dto.setDate(date);
            dto.setShopProductId(shopProductId);
            dto.setExposureNumber(getIntegerFromValue(row.getCell(exposureNumberIndex)));
            dto.setBrowseNumber(getIntegerFromValue(row.getCell(browseNumberIndex)));
            dto.setReDuplicatesBrowseNumber(getIntegerFromValue(row.getCell(reDuplicatesBrowseNumberIndex)));
            dto.setReDuplicatesBuyerNumber(getIntegerFromValue(row.getCell(reDuplicatesBuyerNumberIndex)));
            dto.setClickRate(getBigDecimalFromPercentage(row.getCell(clickRateIndex)));
            dto.setConversionRate(getBigDecimalFromPercentage(row.getCell(conversionRateIndex)));
            list.add(dto);
            if (list.size() >= 40) {
                log.info("保存数据");
                for (TiktokProductCardDayCrawlDto dto1 : list) {
                    log.info("dto1:{}", dto1);
                }
                list.clear();
            }
            log.info("dto:{}", i);
        }
        if (!list.isEmpty()) {
            log.info("保存数据");
            for (TiktokProductCardDayCrawlDto dto1 : list) {
                log.info("dto1:{}", dto1);
            }
            list.clear();
        }
        return null;
    }

    private Integer getIntegerFromValue(Cell cell) {
        String value = cell.getStringCellValue();
        if (MyStringUtils.isEmpty(value)) {
            return null;
        }
        value = value.trim();
        if (!MyStringUtils.isNumeric(value)) {
            return null;
        }
        return Integer.parseInt(value.trim());
    }

    private BigDecimal getBigDecimalFromPercentage(Cell cell) {
        String value = cell.getStringCellValue();
        if (MyStringUtils.isEmpty(value)) {
            return null;
        }
        value = value.trim();
        if (!value.endsWith("%")) {
            return null;
        }
        try {
            // 创建一个百分比格式化对象
            NumberFormat percentageFormat = NumberFormat.getPercentInstance();
            Number number = percentageFormat.parse(value);
            // 将解析得到的数字除以100，并设置四位小数
            return BigDecimal.valueOf(number.doubleValue()).setScale(4, RoundingMode.HALF_UP);
        } catch (Exception e) {
            return null;
        }
    }
}