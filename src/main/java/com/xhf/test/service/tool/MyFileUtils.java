package com.xhf.test.service.tool;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @projectName: test
 * @package: com.xhf.test.service.tool
 * @className: MyFileUtils
 * @descriptions:
 * @author: xiahaifeng
 * @createDate: 2023/12/7 16:15
 * @updateUser: xiahaifeng
 * @updateDate: 2023/12/7 16:15
 * @updateRemark:
 */
@Slf4j
public class MyFileUtils {
    public void downloadFile(String urlString, String exportFilePath, String fileName) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // 设置User-Agent头信息
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");

            try (InputStream is = con.getInputStream();
                 FileOutputStream os = new FileOutputStream(new File(exportFilePath, fileName), true)) {

                log.info("文件下载开始:" + fileName);
                // 1K的数据缓冲
                byte[] bs = new byte[1024];
                // 读取到的数据长度
                int len;
                // 输出的文件流

                // 开始读取
                while ((len = is.read(bs)) != -1) {
                    os.write(bs, 0, len);
                }

            } catch (IOException e) {
                log.error("文件下载异常", e);
            } finally {
                log.info("文件下载结束:" + fileName);
            }
        } catch (IOException e) {
            log.error("文件下载连接异常", e);
        }
    }

}
