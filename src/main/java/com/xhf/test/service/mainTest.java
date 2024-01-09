package com.xhf.test.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


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

        String text ="6685837376 申报价格：35.00元 寄样信息：无需寄样 状态：价格申报中 货号：531838 VMI";
        Pattern pattern = Pattern.compile("状态：\\s*(.*?)\\s*货号：");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }


}
