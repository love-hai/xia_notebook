package com.xhf.test.service.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * @projectName: test
 * @package: com.xhf.test.service.netty
 * @className: TimeServer
 * @descriptions:
 * @author: xiahaifeng
 * @createDate: 2023/12/11 17:09
 * @updateUser: xiahaifeng
 * @updateDate: 2023/12/11 17:09
 * @updateRemark:
 */
@Slf4j
public class TimeServer {

    public void bind(int port) throws Exception {
        // 配置服务端的Nio线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChildChannelHandler());
            // 绑定端口，同步等待成功
            ChannelFuture f = b.bind(port).sync();

            // 等待服务端监听端口关闭
            f.channel().closeFuture().sync();

        } catch (Exception e) {
            log.error("TimeServer.bind() error", e);
        } finally {
            // 优雅退出，释放线程池资源
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

    private static class ChildChannelHandler extends ChannelInitializer<SocketChannel>{
        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
//            socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
//            socketChannel.pipeline().addLast(new StringDecoder());
            socketChannel.pipeline().addLast(new TimeServerHandler());
        }

    }

    public static void main(String[] args) throws Exception {
        int port = 8484;
        if(args != null && args.length > 0){
            try {
                port = Integer.parseInt(args[0]);
            } catch (Exception e) {
                log.error("TimeServer.main() error", e);
            }
        }
        log.info("TimeServer.main() port:{}", port);
        new TimeServer().bind(port);
    }
}
