package com.xhf.test.service.netty.protobuf;

import com.xhf.protobuf.SubscribeReq;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class SubReqClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        for (int i = 0; i < 10; i++) {
            ctx.writeAndFlush(createSubscribeReq(i));
        }
    }

    private SubscribeReq createSubscribeReq(int i) {
        SubscribeReq.Builder builder = SubscribeReq.newBuilder();
        builder.setSubReqID(i);
        builder.setUserName("xiahaifeng");
        builder.setProductName("Netty Book For Protobuf");
        builder.setAddress("Nanjing YuHuaTai");
        return builder.build();
    }
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Receive server response : [" + msg + "]");
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }
}