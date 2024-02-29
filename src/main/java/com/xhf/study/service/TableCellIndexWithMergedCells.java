package com.xhf.study.service;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Collections;

@Slf4j
public class TableCellIndexWithMergedCells {
    public Element tableSegmentation(Element table) {
        Elements trs = table.select("tr");
        int j;
        int maxCol = trs.get(0).select("td").size();
        for (j = 0; j < maxCol; j++) {
            for (int i = 0; i < trs.size(); i++) {
                Element tr = trs.get(i);
                Elements tds = tr.select("td");
                try {
                    Element td = tds.get(j);
                    if (td.hasAttr("rowspan")) {
                        int rowspan = Integer.parseInt(td.attr("rowspan"));
                        // 将rowspan赋值1
                        td.attr("rowspan", "1");
                        for (int k = 1; k < rowspan; k++) {
                            Element nextTr = trs.get(i + k);
                            // 在nextTr的第j个位置插入一个td
                            nextTr.insertChildren(Math.min(nextTr.children().size(), j), Collections.singleton(td.clone()));
                        }
                    }
                } catch (Exception e) {
                    log.error("表格分割异常", e);
                }
            }
        }
        return table;
    }
}
