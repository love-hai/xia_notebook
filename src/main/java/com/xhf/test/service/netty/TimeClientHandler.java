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

import java.util.Date;

public class TimeClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf m = (ByteBuf) msg; // (1)
        try {
            long currentTimeMillis = (m.readUnsignedInt() - 2208988800L) * 1000L;
            System.out.println(new Date(currentTimeMillis));
            ctx.close();
        } finally {
            m.release();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
