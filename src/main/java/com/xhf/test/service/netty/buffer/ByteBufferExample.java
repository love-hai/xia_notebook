package com.xhf.test.service.netty.buffer;

import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @projectName: test
 * @package: com.xhf.test.service.netty.buffer
 * @className: ByteBufferExample
 * @descriptions:
 * @author: xiahaifeng
 * @createDate: 2023/12/8 11:39
 * @updateUser: xiahaifeng
 * @updateDate: 2023/12/8 11:39
 * @updateRemark:
 */
@Slf4j
public class ByteBufferExample {
    public static void main(String[] args) {
        //创建一个10和字节大小的字节缓冲区。
        ByteBuffer byteBuffer = ByteBuffer.allocate(20);
        System.out.println("capacity = " + byteBuffer.capacity());
        System.out.println("limit = " + byteBuffer.limit());
        System.out.println("position = " + byteBuffer.position());
        byteBuffer.put("hello world".getBytes());
        byteBuffer.flip();
        byte[] bytes = new byte[byteBuffer.remaining()];
        byteBuffer.get(bytes);
        System.out.println(Arrays.toString(bytes));
        System.out.println("capacity = " + byteBuffer.capacity());
        System.out.println("limit = " + byteBuffer.limit());
        System.out.println("position = " + byteBuffer.position());
    }
}
