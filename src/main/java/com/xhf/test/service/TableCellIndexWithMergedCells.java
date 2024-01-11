package com.xhf.test.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TableCellIndexWithMergedCells {

    public static void main(String[] args) {
        String html = "<table>" +
                "  <tr>" +
                "    <td rowspan='2'>A</td>" +
                "    <td>B</td>" +
                "    <td>C</td>" +
                "  </tr>" +
                "  <tr>" +
                "    <td>D</td>" +
                "    <td>E</td>" +
                "  </tr>" +
                "</table>";

        Document doc = Jsoup.parse(html);
        Elements tables = doc.select("table");

        for (Element table : tables) {
            int rowIndex = 0;

            for (Element row : table.select("tr")) {
                int columnIndex = 0;

                for (Element cell : row.select("td, th")) {
                    // 获取单元格的 rowspan 和 colspan 属性
                    int rowspan = Integer.parseInt(cell.attr("rowspan"));
                    int colspan = Integer.parseInt(cell.attr("colspan"));

                    // 处理单元格内容及其在表格中的位置
                    String cellText = cell.text();
                    System.out.println("Content: " + cellText +
                            ", Original Row Index: " + rowIndex +
                            ", Original Column Index: " + columnIndex);

                    // 更新列索引
                    columnIndex += colspan;

                    // 更新行索引，跳过被合并的行
                    for (int i = 1; i < rowspan; i++) {
                        rowIndex++;
                    }
                }

                // 更新行索引
                rowIndex++;
            }
        }
    }
}
