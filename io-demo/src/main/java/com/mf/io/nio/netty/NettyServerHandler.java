package com.mf.io.nio.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class NettyServerHandler extends SimpleChannelInboundHandler<String> {

    // 线程安全
    public static List<Channel> channels = new CopyOnWriteArrayList<>();

    //通道就绪
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channels.add(channel);

        System.out.println("[Server]:" + channel.remoteAddress().toString().substring(1) + " 上线");
    }

    // 通道关闭
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channels.remove(channel);
        System.out.println("[Server]: " + channel.remoteAddress().toString().substring(1) + " 离线");
    }

    // 接收消息
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel inChannel = ctx.channel();
        System.out.println("s => " + msg);
        // 广播的形式向所有的chanel里面都输出信息
        for (Channel channel1 : channels) {
            if (inChannel != channel1) {
                inChannel.writeAndFlush("["+inChannel.remoteAddress().toString().substring(1)+"]"+"说：" + msg + "\n");
            }
        }

    }
}
