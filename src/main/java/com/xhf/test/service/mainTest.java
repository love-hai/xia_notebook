package com.xhf.test.service;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class mainTest {

    public static void main(String[] args) {
        String data = "尊敬的Temu卖家，平台要求紧急备货单应在创建时间起24小时内完成发货。2023年12月19日（含当日）" +
                "及以后创建的普通备货单，应在创建日T+2日的17:00前完成发货；2023年12月19日之前创建的普通备货单，仍" +
                "按创建时间起48小时内发货考核。建议您当天立即发出，逾期可能的影响：仍可发出，但可能影响后续上新、首单" +
                "审核、可备货量、活动报名、竞价结果、流量权重等相关权限。近7日整体表现近7天48h履约表现0%较差一般良好优秀" +
                "较差您距离下一档位一般还差80.00%情况不太妙，要重视起来了！发货情况统计时间：2024-01-19～2024-01-2" +
                "5环比周期：2024-01-12～2024-01-18紧急单24h发货率0%环比-普通单48h发货率0%环比-整体48h发货率0%环比" +
                "-整体24h发货率0%环比-01-23紧急单24h发货率0%普通单48h发货率0%整体48h发货率0%整体24h发货率0%加发货台" +
                "次数过于频繁表示发货效率较低，创单、装箱耗时将会影响履约表现，请保持关注，提高效率！48H全部备货单加发货台2次" +
                "及以上的备货单(单)0环比-创建发货单平均耗时(分钟)5267环比-装箱发货平均耗时(分钟)0环比-";
        String regex="履约表现(.*?)%较差一般良好优秀(.{2})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
        }
        String regex1="紧急单24h发货率(.*?)%";
    }

}
