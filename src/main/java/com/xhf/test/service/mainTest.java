package com.xhf.test.service;

import com.xhf.test.service.tool.CalendarData;
import lombok.extern.slf4j.Slf4j;

/**
 * @projectName: test
 * @package: com.xhf.test.service
 * @className: mainTest
 * @descriptions:
 * @author: xiahaifeng
 * @createDate: 2023/9/21 14:20
 * @updateUser: xiahaifeng
 * @updateDate: 2023/9/21 14:20
 * @updateRemark:
 */
@Slf4j
public class mainTest {

    public static void main(String[] args) {
        CalendarData calendarData = new CalendarData();
       log.info(calendarData.getStringOfTime());
    }
}