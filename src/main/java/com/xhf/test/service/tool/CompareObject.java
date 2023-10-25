package com.xhf.test.service.tool;

/**
 * @projectName: test
 * @package: com.xhf.test.service.tool
 * @className: CompareObject
 * @descriptions: 比较两个对象的大小
 * @author: xiahaifeng
 * @createDate: 2023/10/25 10:35
 * @updateUser: xiahaifeng
 * @updateDate: 2023/10/25 10:35
 * @updateRemark:
 */

public class CompareObject {

    /**
     * @Method: compareVersion
     * @Description: 比较两个版本号例如'0.0.0.4'的大小，前面大则返回正数，后面大则返回负数，相等则返回0
     * @param version1 java.lang.String  :
     * @param version2 java.lang.String  :
     * @return: int
     * @Author: xiahaifeng
     * @Date: 2023/10/25 10:37
     */
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int length = Math.max(v1.length, v2.length);
        for (int i = 0; i < length; i++) {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if (num1 != num2) {
                return num1 - num2;
            }
        }
        return 0;
    }
}
