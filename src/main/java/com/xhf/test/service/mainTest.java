package com.xhf.test.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;


/**
 * @projectName: test
 * @package: com.xhf.test.service
 * @className: mainTest
 * @descriptions:
 * @author: xiahaifengMyRegularMatchUtil
 * @createDate: 2023/9/21 14:20
 * @updateUser: xiahaifeng
 * @updateDate: 2023/9/21 14:20
 * @updateRemark:
 */
@Slf4j
public class mainTest {
    @Autowired
    private static ReadTime readTime;

    public static void main(String[] args) {

//        DateFormat dateFormat = DateFormat.getDateInstance();
//        Date now = null;
//        try {
//            now = dateFormat.parse("2023-12-09");
//        } catch (ParseException e) {
//            log.error("时间转换失败", e);
//        }
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(now);
//        System.out.println(calendar.get(Calendar.MONTH));
//        System.out.println(calendar.get(Calendar.YEAR));
//        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    }


}
