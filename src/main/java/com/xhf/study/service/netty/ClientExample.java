package com.xhf.study.service.netty;

import com.xhf.study.service.netty.delimiter.EchoClient;
import com.xhf.study.service.netty.delimiter.EchoClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class ClientExample {

    private ChannelInitializer<SocketChannel> childChannelHandler;
    public ClientExample(ChannelInitializer<SocketChannel> childChannelHandler) {
        this.childChannelHandler = childChannelHandler;
    }

    public void execute(int port,String host) throws Exception {
        connect(port,host);
    }
    public void execute() throws Exception {
        connect(8484, "127.0.0.1");
    }

    public void connect(int port, String host) throws Exception {
        // 配置客户端 NIO 线程组
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(childChannelHandler);
            ChannelFuture f = b.connect(host, port).sync();
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }
}
