package com.xhf.test.service.netty;

/**
 * @projectName: test
 * @package: com.xhf.test.service.netty
 * @className: TimeClientHandler
 * @descriptions:
 * @author: xiahaifeng
 * @createDate: 2023/11/29 17:14
 * @updateUser: xiahaifeng
 * @updateDate: 2023/11/29 17:14
 * @updateRemark:
 */

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.StandardCharsets;
import java.util.Date;

public class TimeClientHandler extends ChannelInboundHandlerAdapter {
    private int counter;
    private final byte[] req;
    public TimeClientHandler() {
        req = ("QUERY TIME ORDER" + System.getProperty("line.separator")).getBytes();
    }
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ByteBuf message = null;
        for (int i = 0; i < 100; i++) {
            message = ctx.alloc().buffer(req.length);
            message.writeBytes(req);
            // 发送消息
            ctx.writeAndFlush(message);
        }
    }
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, StandardCharsets.UTF_8);
        System.out.println("Now is : " + body + " ; the counter is : " + ++counter);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }
}
