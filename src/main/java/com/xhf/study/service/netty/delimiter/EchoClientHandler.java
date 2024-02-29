package com.xhf.study.service.netty.delimiter;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Scanner;

public class EchoClientHandler extends ChannelInboundHandlerAdapter {
    private int counter;
    static final String ECHO_REQ = "Hi, xhf. Welcome to Netty.$_";

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入文本（遇到换行符即结束）：");
        // 使用 hasNextLine() 判断是否还有下一行输入
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("exit")) {
                break;
            }
            line += "$_";
            ctx.writeAndFlush(Unpooled.copiedBuffer(line.getBytes()));
        }
        scanner.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String message = (String) msg;
        System.out.println("This is " + ++counter + " times receive server : [" + message + "]");
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
