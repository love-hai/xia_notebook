package com.xhf.study.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * 导入excel文件
 * @author xiahaifeng
 * @since 2023/8/14 9:08
 */
@Slf4j
public class ImportExcelFile {
    private int count = 0;

    // 打开文件管理器选择文件，限制课件文件为csv和excel文件
    public void openFile() {
        Desktop desktop = Desktop.getDesktop();
        // 获取文件选择器
        FileDialog fileDialog = new FileDialog(new Frame(), "选择CSV或Excel文件", FileDialog.LOAD);
        // 限制只有文件夹和csv和excel文件才能被看见
        fileDialog.setFile("*.csv;*.xls;*.xlsx");
        // 显示文件选择对话框
        fileDialog.setVisible(true);
        // 获取选择的文件路径
        String selectedFilePath = fileDialog.getDirectory() + fileDialog.getFile();
        // 如果文件路径不为空，尝试使用桌面打开该文件
        if (!selectedFilePath.isEmpty()) {
            File selectedFile = new File(selectedFilePath);
            try {
                desktop.open(selectedFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void openFile2(){
        String filePath = "D:\\test\\备货单号2.csv";
        File file = new File(filePath);
        List<String> orderList = new ArrayList<>();
        // 根据文件地址读取excel文件
        try{
            if(file.exists()){
                 FileInputStream fis = new FileInputStream(file);
                 Workbook workbook = WorkbookFactory.create(fis);
                 int numberOfSheets = workbook.getNumberOfSheets();
                 for(int i=0;i<numberOfSheets;i++){
                     Sheet sheet = workbook.getSheetAt(i);
                     Row row = sheet.getRow(0);
                     int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                     for(int j=0;j<physicalNumberOfCells;j++){
                         Cell cell = row.getCell(j);
                         if(cell==null){
                             continue;
                         }
                         String stringCellValue = cell.toString();
                         if(("备货单号").equals(stringCellValue)){
                             int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
                             for(int k=1;k<physicalNumberOfRows;k++){
                                 Row row1 = sheet.getRow(k);
                                 Cell cell1 = row1.getCell(j);
                                 if(cell1==null){
                                     continue;
                                 }
                                 String stringCellValue1 = cell1.toString();
                                 // 如果后面跟着.0+好几个0，去掉
                                if(stringCellValue1.contains(".0")){
                                    stringCellValue1 = stringCellValue1.substring(0,stringCellValue1.indexOf(".0"));
                                }
                                 System.out.println("stringCellValue1:"+stringCellValue1);
                                 orderList.add(stringCellValue1);
                             }
                         }
                     }
                 }
            }
            System.out.println("orderList:"+orderList.toString());
        }catch (Exception e){
            log.error("读取excel文件失败",e);
        }finally {
            // 关闭文件
            file.delete();
        }


    }
    public void openFile3(){
        String filePath = "D:\\test\\备货单号3.txt";
        List<String> orderList = new ArrayList<>();
        // 打开txt文件,读取每一行加入orderList
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                orderList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(orderList.size()==0){
            orderList=null;
        }

        System.out.println("orderList:"+orderList.toString());
    }

    public static void main(String[] args) {
        ImportExcelFile importExcelFile = new ImportExcelFile();
        importExcelFile.openFile3();
    }
}
