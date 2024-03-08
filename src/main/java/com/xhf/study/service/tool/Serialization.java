package com.xhf.study.service.tool;

import com.xhf.study.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.SerializationUtils;

/**
 * 序列化和反序列化
 * @author xiahaifeng
 * @since 2023/11/22 13:36
 */
@Slf4j
public class Serialization {
    public static void main(String[] args) {
        log.info("序列化和反序列化");
        Student student = new Student("xia",18 );
        log.info("序列化前："+student.toString());
        byte[] bytes = SerializationUtils.serialize(student);
        log.info("序列化后："+bytes.toString());
        Student student1 = SerializationUtils.deserialize(bytes);
        log.info("反序列化后："+student1.toString());
    }
}
