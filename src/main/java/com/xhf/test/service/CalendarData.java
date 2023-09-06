package com.xhf.test.service;

import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;
import java.util.Date;

/**
 * @projectName: test
 * @package: com.xhf.test.service
 * @className: CalendarData
 * @descriptions: 一些计算时间的函数
 * @author: xiahaifeng
 * @createDate: 2023/8/23 14:15
 * @updateUser: xiahaifeng
 * @updateDate: 2023/8/23 14:15
 * @updateRemark:
 * @version: v1.0
 */
@Slf4j
public class CalendarData {

    private static Integer getSecondsToNextDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0); //凌晨0点
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return (int) ((calendar.getTimeInMillis() - System.currentTimeMillis()) / 1000);
    }

    private static void dataToLong() {
        Date date = new Date();
        System.out.println(date.getTime());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("error",e);
        }
        log.info(String.valueOf(System.currentTimeMillis()));
    }

    public static void main(String[] args) {
    }

}
