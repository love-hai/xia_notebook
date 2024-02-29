package com.xhf.study.service;

import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * 创建目录
 * @author xiahaifeng
 * @since 2023/9/8 13:54
 */
@Slf4j
public class CreateDir {

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
