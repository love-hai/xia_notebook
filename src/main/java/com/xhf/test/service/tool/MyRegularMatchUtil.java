package com.xhf.test.service.tool;

/**
 * @projectName: lalang-browser
 * @package: com.lalang.browser.util
 * @className: MyRegularMatchUtil
 * @descriptions: 正则匹配工具
 * @author: xiahaifeng
 * @createDate: 2023/11/24 8:52
 * @updateUser: xiahaifeng
 * @updateDate: 2023/11/24 8:52
 * @updateRemark:
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 在爬取数据的时候，找到一些数据，需要不停的分析节点，很烦。而且后期一个节点的变化，会导致很多地方都要修改。
 */
public class MyRegularMatchUtil {

    public static final String Empty = "";
    // 数字
    public static final String NumberType = "\\d+";
    // 字母
    public static final String LetterType = "[a-zA-Z]+";
    // 数字和字母
    public static final String NumberAndLetter = "[a-zA-Z0-9]+";
    // 什么字符都可以
    public static final String AnyCharacter = ".*";


    /**
     * MethodName: getMatchString <br>
     * Description: 从字符串中得到匹配的字符串<br>
     * createDate: 2023/11/24 11:15
     * @param str          java.lang.String  :
     * @param frontPattern java.lang.String  :
     * @param midPattern   java.lang.String  :
     * @param backPattern  java.lang.String  :
     * @return java.lang.String
     * @author xiahaifeng
     */
    public static String getMatchString(String str, String frontPattern,String midPattern, String backPattern) {
        // 前面有frontPattern,但是不包含frontPattern，而且以endPattern结尾的字符串
        Pattern pattern = Pattern.compile(frontPattern + midPattern + backPattern);
        // Create a matcher for the input string
        Matcher matcher = pattern.matcher(str);
        // Find all matches
        if(matcher.find()){
            String result = matcher.group();
            Matcher forntMatcher = Pattern.compile(frontPattern).matcher(result);
            if(forntMatcher.find()) {
                return result.replace(forntMatcher.group(), "");
            }
        }
        return null;
    }

    /**
     * MethodName: getMatchString <br>
     * Description: 从字符串中得到匹配的字符串 <br>
     * @param str          java.lang.String  :
     * @param frontPattern java.lang.String  :匹配的字符串前面的字符串
     * @param backPattern  java.lang.String  :匹配的字符串后面的字符串
     * @return java.lang.String
     * @author xiahaifeng
     * @createDate: 2024/1/9 8:33
     */
    public static String getMatchString(String str, String frontPattern,String backPattern) {
        Pattern pattern = Pattern.compile(frontPattern+"(.*)" + backPattern);
        // Create a matcher for the input string
        Matcher matcher = pattern.matcher(str);
        // Find all matches
        if(matcher.find()){
            return matcher.group(1);
        }
        return null;
    }


    public static void main(String...args){
        String str = "WB230908032437\n" +
                "系统创建\n" +
                "含缺货/售罄SKU1\n" +
                "48h\n" +
                "需09-09 07:01:19前发货\n" +
                "已逾期\n" +
                "需09-11 07:01:19前到货\n" +
                "已逾期";
        System.out.println(getMatchString(str,Empty,NumberAndLetter , NumberType));

        str="备货母单号: WP230908034250\n" +
                "灰色刺猬款猫钻袋子\n" +
                "SKC: 5330317879\n" +
                "货号: 209198\n" +
                "超期作废返无货审核中国内备货VMI";
        System.out.println(getMatchString(str,"SKC: ",NumberAndLetter , NumberType));
    }


}
