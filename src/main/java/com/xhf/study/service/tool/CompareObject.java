package com.xhf.study.service.tool;

import java.io.File;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 比较两个对象的大小
 * @author xiahaifeng
 * @since 2023/10/25 10:35
 */

public class CompareObject {

    /**
     * MethodName: compareVersion <br>
     * Description: 比较两个版本号例如'0.0.0.4'的大小，前面大则返回正数，后面大则返回负数，相等则返回0<br>
     * @param version1 java.lang.String  :
     * @param version2 java.lang.String  :
     * @return int
     * @author xiahaifeng
     * @since 2024/2/29 13:44
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

    /**
     * MethodName: isVersionNoRight <br>
     * Description: 判断版本号是否符合规范，例如只有数字和小数点，两边没有小数点<br>
     * @param versionNo java.lang.String  :
     * @return java.lang.Boolean
     * @author xiahaifeng
     * @since 2024/2/29 13:44
     */
    public Boolean isVersionNoRight(String versionNo) {
        String regex = "^[0-9]+(.[0-9]+)*$";
        return versionNo.matches(regex);
    }

    public File[] getFiles(String path,Long versionId,String filename){
        File uploadDir = new File(path);
        File[] chunkFiles = uploadDir.listFiles((dir, name) -> name.startsWith(versionId +filename + "."));
        // 排序
        if(null == chunkFiles){
            return null;
        }
        Arrays.sort(chunkFiles, Comparator.comparingInt(o -> Integer.parseInt(o.getName().substring(o.getName().lastIndexOf(".") + 1))));
        return chunkFiles;
    }

    public void compareBigDecimals(BigDecimal b1, BigDecimal b2){
        System.out.println(b1.compareTo(b2));
    }

    public static void main(String[] args) {
        MyFileUtils myFileUtils = new MyFileUtils();
        String fileName = "lalangBrowser-0.1.1.6.exe";
        myFileUtils.downloadFile("http://update.biz-export.com/"+fileName,"C:\\Users\\Admin\\Downloads",fileName,true);

    }

}
