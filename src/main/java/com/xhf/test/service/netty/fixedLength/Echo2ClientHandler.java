package com.xhf.test.service.netty.fixedLength;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class Echo2ClientHandler extends ChannelInboundHandlerAdapter {
    private int counter;
    static String ECHO_REQ = "xhf Welcome to Netty";

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        for (int i = 0; i < 10; i++) {
            if(ECHO_REQ.length() > 20){
                ECHO_REQ.substring(0,20);
            }else {
                for (int j = 0; j < 20 - ECHO_REQ.length(); j++) {
                    ECHO_REQ += " ";
                }
            }
            ctx.writeAndFlush(Unpooled.copiedBuffer(ECHO_REQ.getBytes()));
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("This is " + ++counter + " times receive server : [" + msg + "]");
    }
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
