package com.xhf.study.service.netty.protobuf;

import com.xhf.protobuf.SubscribeReq;
import com.xhf.study.service.netty.ServerExample;
import com.xhf.study.service.netty.TimeServer;
import com.xhf.study.service.netty.TimeServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubReqServer {
    private static class ChildChannelHandler extends ChannelInitializer<SocketChannel> {
        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
            socketChannel.pipeline().addLast(new ProtobufVarint32FrameDecoder());
            socketChannel.pipeline().addLast(new ProtobufDecoder(SubscribeReq.getDefaultInstance()));
            socketChannel.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
            socketChannel.pipeline().addLast(new ProtobufEncoder());
            socketChannel.pipeline().addLast(new SubReqServerHandler());
        }
    }

    public static void main(String[] args) throws Exception {
        new ServerExample(new ChildChannelHandler()).execute();
    }
}
