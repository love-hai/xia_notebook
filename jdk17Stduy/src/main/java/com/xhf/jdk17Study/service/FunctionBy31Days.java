package com.xhf.jdk17Study.service;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xiahaifeng
 * @since 2024/4/12 11:44
 */
@Slf4j
public class FunctionBy31Days {

    public String crawlAllData(Date startDate, Date endDate) {
        // 爬取数据
        Date currentStartDate = startDate;
        Date currentEndDate = new Date(startDate.getTime() + 30L * 24 * 60 * 60 * 1000);
        currentEndDate = currentEndDate.after(endDate) ? endDate : currentEndDate;
        do {
            String errorResult = crawl(currentStartDate, currentEndDate);
            if (errorResult != null) {
                return errorResult;
            }
            currentStartDate = new Date(currentEndDate.getTime() + 24 * 60 * 60 * 1000);
            currentEndDate = new Date(currentStartDate.getTime() + 30L * 24 * 60 * 60 * 1000);
            currentEndDate = currentEndDate.after(endDate) ? endDate : currentEndDate;
        } while (!currentStartDate.after(endDate));

        return null;
    }

    public String crawl(Date currentStartDate, Date currentEndDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        log.info("{} ~ {}", sdf.format(currentStartDate), sdf.format(currentEndDate));
        log.info("爬取数据");
        log.error("爬取数据失败");
        return null;
    }

    public static void main(String[] args) {
        FunctionBy31Days functionBy31Days = new FunctionBy31Days();
        Date endDate = new Date();
        Date startDate = new Date(endDate.getTime() - 355L * 24 * 60 * 60 * 1000);
        functionBy31Days.crawlAllData(startDate, endDate);
    }
}
