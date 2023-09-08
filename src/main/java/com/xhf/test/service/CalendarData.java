package com.xhf.test.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@Service
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

    private static Long DataStringToLong(Date d){
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Long epho = df.parse(df.format(d)).getTime() / 1000;
            return epho;
        } catch (ParseException e) {
            log.error("error",e);
            return null;
        }
    }

    public static void main(String[] args) {
        dataToLong();
    }

}
