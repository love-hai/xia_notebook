package com.xhf.study.service.tool;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

public class MyDateTimeUtils extends DateFormatUtils {

    public Date getDateByTimestamp(Long timestamp) {
        if (null == timestamp) {
            return new Date();
        } else {
            return new Date(timestamp);
        }
    }
}