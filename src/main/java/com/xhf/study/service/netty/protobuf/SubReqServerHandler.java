package com.xhf.study.service.netty.protobuf;

import com.xhf.protobuf.SubscribeReq;
import com.xhf.protobuf.SubscribeResp;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

public class SubReqServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{
        SubscribeReq req = (SubscribeReq) msg;
        System.out.println(req.toString());
        ctx.writeAndFlush(createSubscribeResp(req.getSubReqID()));
    }

    private SubscribeResp createSubscribeResp(int subReqID) {
        SubscribeResp.Builder builder = SubscribeResp.newBuilder();
        builder.setSubReqID(subReqID);
        builder.setRespCode(0);
        builder.setDesc("Netty book order succeed, 3 days later, sent to the designated address");
        return builder.build();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
