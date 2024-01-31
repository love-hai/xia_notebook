package com.xhf.test.service.netty.protobuf;

import com.xhf.protobuf.SubscribeReq;

import java.util.Arrays;

/**
 * CreateDate: 2024/1/31 17:07
 *
 * @author xiahaifeng
 */

public class TestSubscribeReqProto {
    private static byte[] encode(SubscribeReq req) {
        return req.toByteArray();
    }
    private static SubscribeReq decode(byte[] body) throws Exception {
        return SubscribeReq.parseFrom(body);
    }
    private static SubscribeReq createSubscribeReq() {
        SubscribeReq.Builder builder = SubscribeReq.newBuilder();
        builder.setSubReqID(1);
        builder.setUserName("xiahaifeng");
        builder.setProductName("Netty Book");
        builder.setAddress("Nanjing YuHuaTai");
        return builder.build();
    }

    public static void main(String[] args) throws Exception {
        SubscribeReq req = createSubscribeReq();
        System.out.println("Before encode : " + req);
        System.out.println((Arrays.toString(encode(req))));
        SubscribeReq req2 = decode(encode(req));
        System.out.println("After decode : " + req);
        System.out.println("Assert equal : --> " + req2.equals(req));
    }
}
