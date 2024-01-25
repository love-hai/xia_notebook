package com.xhf.test.service;

import lombok.extern.slf4j.Slf4j;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class mainTest {

    public static void main(String[] args) {
        String str = "根据春节放假的实际情况，Temu对以下评估周期作出如下调整：1、自2024年1月29日起至2024年2月11日止的评估周期，仅评估" +
                "2024年1月29日至2024年1月31日期间的发货及时率及虚假发货率，其余日期从该评估周期中予以剔除；2、自2024年2月12日起至2024" +
                "年2月25日止的评估周期，仅评估2024年2月18日至2024年2月25日期间的发货及时率及虚假发货率，其余日期从该评估周期中予以剔除。" +
                "评估周期请选择评级结果较差(C)一般(B)良好(A)优秀(S)及时发货件量比-历史及时发货件量比走势暂无数据未及时发货备货单信息总订单" +
                "-总下单数量-未及时发货订单-未及时发货数量-备货单信息SKU信息要求发货/实际发货时间下单数收货数未及时发货数暂无数据共有 0 条" +
                "每页10条虚假发货单量比-历史虚假发货单量比走势暂无数据虚假发货备货单信息考核总数-虚假发货数量-备货单号SKC信息备货单创建/需最" +
                "晚/实际发货、到货时间物流信息暂无数据共有 0 条每页10条";
        String regex = "及时发货件量比(.*?)历史";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()){
            String result = matcher.group(1);
            System.out.println(result);
        }
        regex = "虚假发货单量比(.*?)历史";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(str);
        while (matcher.find()){
            String result = matcher.group(1);
            System.out.println(result);
        }
    }
}
