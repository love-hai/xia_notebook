package com.xhf.test.service.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author xiahaifeng
 * createDate: 2023/11/29 17:14
 */

public class TimeClientHandler extends ChannelInboundHandlerAdapter {
    private int counter;
    private final byte[] req;
    String sendMsg = "QUERY TIME ORDER" + System.getProperty("line.separator");
    public TimeClientHandler() {
        req = ("QUERY TIME ORDER" + System.getProperty("line.separator")).getBytes();
    }
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        for (int i = 0; i < 100; i++) {
            ByteBuf message = Unpooled.copiedBuffer(sendMsg.getBytes());
            // 发送消息
            ctx.writeAndFlush(message);
        }
    }
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String body = (String) msg;
        System.out.println("Now is : " + body + " ; the counter is : " + ++counter);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }
}
