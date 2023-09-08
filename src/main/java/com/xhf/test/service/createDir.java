package com.xhf.test.service;

import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * @projectName: test
 * @package: com.xhf.test.service
 * @className: createDir
 * @descriptions: 创建目录
 * @author: xiahaifeng
 * @createDate: 2023/9/8 13:54
 * @updateUser: xiahaifeng
 * @updateDate: 2023/9/8 13:54
 * @updateRemark:
 * @version: v1.0
 */
@Slf4j
public class createDir {

    public static void main(String[] args) {
        String directoryPath = "C:/temu/download";
        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            log.info("下载目录已存在.");
        } else {
            boolean created = directory.mkdirs();
            if (created) {
                log.info("创建下载目录成功。");
            } else {
                log.info("创建下载目录失败。");
            }
        }
    }
}
