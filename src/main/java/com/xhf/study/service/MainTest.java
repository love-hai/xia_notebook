package com.xhf.study.service;

import com.opencsv.CSVReader;
import com.xhf.study.model.TiktokAllianceOrderDayCrawlDto;
import com.xhf.study.service.tool.MyStringUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
public class MainTest {

    public static void main(String[] args) {
//        mainTest mainTest = new mainTest();
//        String filePath = "C:\\Users\\Admin\\Desktop\\all_20240201000000_20240229235959(2).csv";
//        String result = mainTest.handleCsvData(filePath);
//        if (result != null) {
//            log.error(result);
//        }
        MainTest mainTest = new MainTest();
        String date = "21/02/2024";
        Date createDate = mainTest.getCreateDate(date);
        log.info("{}",mainTest.sdf.format(createDate));
    }

    private String handleCsvData(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            return filePath + "文件不存在";
        }
        // 检查是否是xlsx文件
        if (!filePath.endsWith(".csv")) {
            return filePath + "不是csv文件";
        }
        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            // 读取第一行
            String[] header = reader.readNext();
            if (null == header) {
                return "csv文件为空";
            }
            // 商品ID
            int shopProductIdIndex = -1;
            // 订单ID
            int orderIdIndex = -1;
            // 预估计佣金额
            int estimateAllianceCommissionIndex = -1;
            // 创建时间
            int createDateIndex = -1;
            // Sku Id
            int skuIdIndex = -1;
            for (int i = 0; i < header.length; i++) {
                if(MyStringUtils.isEmpty(header[i])){
                    continue;
                }
                if(header[i].contains("商品ID")){
                    shopProductIdIndex = i;
                }else if(header[i].contains("订单ID")){
                    orderIdIndex = i;
                }else if(header[i].equals("预估佣金")){
                    estimateAllianceCommissionIndex = i;
                }else if(header[i].contains("创建时间")){
                    createDateIndex = i;
                }else if(header[i].contains("Sku Id")){
                    skuIdIndex = i;
                }
            }
            if(shopProductIdIndex == -1 || orderIdIndex == -1 || estimateAllianceCommissionIndex == -1 || createDateIndex == -1 || skuIdIndex == -1){
                return "csv文件格式错误";
            }
            List<TiktokAllianceOrderDayCrawlDto> dtoList = new ArrayList<>();
            for (String[] next : reader) {
                if (null == next || next.length == 0) {
                    continue;
                }
                TiktokAllianceOrderDayCrawlDto dto = new TiktokAllianceOrderDayCrawlDto();
                dto.setShopProductId(next[shopProductIdIndex].trim());
                dto.setOrderId(next[orderIdIndex].trim());
                dto.setEstimateAllianceCommission(new BigDecimal(next[estimateAllianceCommissionIndex].trim()));
                dto.setSkuId(next[skuIdIndex].trim());
                dto.setDate(getCreateDate(next[createDateIndex]));
                dtoList.add(dto);
            }
            log.info("解析csv数据成功，共{}条", dtoList.size());
            log.info("{}", dtoList);
        } catch (Exception e) {
            log.error("解析csv数据失败", e);
            return "解析csv数据失败" + e.getMessage();
        }
        return null;
    }
    public final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date getCreateDate(String createDate) {
        // 21/02/2024
        if(MyStringUtils.isEmpty(createDate)){
            return null;
        }
        createDate = createDate.trim();
        if(createDate.length() < 10){
            return null;
        }
        createDate =  createDate.substring(0,10);
        try {
            return sdf.parse(createDate);
        } catch (Exception e) {
            return null;
        }
    }

}