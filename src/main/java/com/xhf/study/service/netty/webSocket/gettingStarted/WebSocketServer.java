package com.xhf.study.service.netty.webSocket.gettingStarted;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 * wenSocket服务启动类
 *
 * @author xiahaifeng
 * @since 2024/3/5 9:25
 */

public class WebSocketServer {
    public void run(int port) throws Exception{
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
//        try{
//            ServerBootstrap b = new ServerBootstrap();
//            b.group(bossGroup,workerGroup)
//                    .channel(NioServerSocketChannel.class)
//                    .childHandler
//        }
    }

}
