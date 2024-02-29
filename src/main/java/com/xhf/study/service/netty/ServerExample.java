package com.xhf.study.service.netty;

import com.xhf.study.service.netty.protobuf.SubReqServer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServerExample {

    private ChannelInitializer<SocketChannel> childChannelHandler;

    public ServerExample(ChannelInitializer<SocketChannel> childChannelHandler) {
        this.childChannelHandler = childChannelHandler;
    }

    public void bind(int port) throws Exception {
        // 配置服务端的Nio线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(childChannelHandler);
            // 绑定端口，同步等待成功
            ChannelFuture f = b.bind(port).sync();
            // 等待服务端监听端口关闭
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            log.error("Server.bind() error", e);
        } finally {
            // 优雅退出，释放线程池资源
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

    public void execute(int port) throws Exception {
        bind(port);
    }
    public void execute() throws Exception {
        bind(8484);
    }
}
