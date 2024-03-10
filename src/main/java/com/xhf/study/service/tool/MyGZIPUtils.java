package com.xhf.study.service.tool;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Gzip 解压，压缩工具类
 *
 * @author xiahaifeng
 * @since 2024/2/27 16:22
 */
@Slf4j
public class MyGZIPUtils {
    public  static byte[] compressByteToByte(byte[] data) {
        if (data == null || data.length == 0) {
            return null;
        }
        try(ByteArrayOutputStream out = new ByteArrayOutputStream();
            GZIPOutputStream gzip = new GZIPOutputStream(out)) {
            gzip.write(data);
            gzip.finish();
            return out.toByteArray();
        } catch (Exception e) {
            log.error("压缩字节数组失败", e);
        }
        return null;
    }

    public static byte[] compressStringToByte(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        try{
            byte[] bytes = new sun.misc.BASE64Decoder().decodeBuffer(str);
            return compressByteToByte(bytes);
        }catch (IOException e){
            log.error("字符转化为字节数组失败", e);
        }
        return null;
    }

    public static String compressStringToString(String str) {
        return new sun.misc.BASE64Encoder().encode(compressStringToByte(str));
    }


    public static byte[] uncompressByteToByte(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
            ByteArrayInputStream in = new ByteArrayInputStream(bytes);
            GZIPInputStream unGzip = new GZIPInputStream(in);){
            byte[] buffer = new byte[256];
            int n;
            while ((n = unGzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
            return out.toByteArray();
        } catch (Exception e) {
            log.error("解压字节数组失败", e);
        }
        return null;
    }

    public static byte[] uncompressStringToByte(String compressedStr) {
        if(compressedStr == null || compressedStr.isEmpty()){
            return null;
        }
        byte[] bytes = new byte[0];
        try {
            bytes = new sun.misc.BASE64Decoder().decodeBuffer(compressedStr);
        } catch (IOException e) {
            log.error("字符串转化字节数组失败", e);
        }
        return uncompressByteToByte(bytes);
    }

    public static String uncompressStringToString(String compressedStr) {
        return new sun.misc.BASE64Encoder().encode(uncompressStringToByte(compressedStr));
    }

    public static void main(String[] args) throws IOException {
        String str = "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";
        String xml = uncompressStringToString(str);
        // 解析xml
        try {
            Document doc = Jsoup.parse(xml);
            Elements userTasks = doc.getElementsByTag("userTask");
            if (userTasks.isEmpty()) {
                return;
            }
            for (Element e : userTasks) {
                String id = e.attr("id");
                String name = e.attr("name");
                log.info("id:{},name:{}", id, name);
            }
        } catch (Exception e) {
            log.error("解析xml失败", e);
        }
    }
}
