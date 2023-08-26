package com.xhf.test.service;

import java.util.Calendar;

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

public class CalendarData {

    private static Integer getSecondsToNextDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0); //凌晨0点
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return (int) ((calendar.getTimeInMillis() - System.currentTimeMillis()) / 1000);
    }

    public static void main(String[] args) {
        System.out.println(getSecondsToNextDay());
    }
}
