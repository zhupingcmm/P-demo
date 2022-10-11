package com.mf.io.nio.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

public class NettyClient {
    private String host;

    private int port;

    public NettyClient(String host, int port) {
        this.host = host;
        this.port = port;
    }


    private void run () throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap()
                .group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {

                       ChannelPipeline pipeline = ch.pipeline();
                       pipeline.addLast("decoder", new StringDecoder());
                       pipeline.addLast("encoder", new StringEncoder());
                        //往pipeline链中添加自定义的handler(业务处理类)
                        pipeline.addLast(new NettyClientHandler());
                    }
                });

        ChannelFuture cf = bootstrap.connect(host, port).sync();
        //获取通道
        Channel channel = cf.channel();
        System.out.println("----------" + channel.localAddress().toString().substring(1) + "--------");

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入： ");
        while (scanner.hasNext()) {
            String msg = scanner.nextLine();
            // 向通道写消息
            channel.writeAndFlush(msg + "\r\n");
        }
        cf.channel().closeFuture().sync();
    }

    public static void main(String[] args) throws InterruptedException {
        new NettyClient("127.0.0.1", 9999).run();
    }
}
