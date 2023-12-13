package com.xhf.test.service.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * @projectName: test
 * @package: com.xhf.test.service.netty
 * @className: DiscardServerHandler
 * @descriptions:
 * @author: xiahaifeng
 * @createDate: 2023/11/29 10:11
 * @updateUser: xiahaifeng
 * @updateDate: 2023/11/29 10:11
 * @updateRemark:
 */
@Slf4j
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
//        ByteBuf in = (ByteBuf) msg;
//        try {
//            while (in.isReadable()) {
//                // 读取一个字节
//                byte byteValue = in.readByte();
//                // 使用 UTF-8 字符集解码字节
//                String content = new String(new byte[]{byteValue}, Charset.forName("utf-8"));
//                System.out.print(content);
//                System.out.flush();
//            }
//        } finally {
//            ReferenceCountUtil.release(msg); // (2)
//        }
        // 读取一个字节发送回
        ctx.write(msg);
        ctx.flush();

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}
