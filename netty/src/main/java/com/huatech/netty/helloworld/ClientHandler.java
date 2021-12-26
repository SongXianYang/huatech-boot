package com.huatech.netty.helloworld;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.Scanner;

/**
 * @author Songxianyang
 * @description:
 * @create: 2021-12-21 22:22
 **/
public class ClientHandler extends SimpleChannelInboundHandler<ByteBuf> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        byte[] bytes = new byte[msg.readableBytes()];
        msg.readBytes(bytes);
        System.out.println(new String(bytes, "utf-8"));
        msg.release();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //ctx.writeAndFlush(Unpooled.copiedBuffer("hello world", CharsetUtil.UTF_8));
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println("输入想要输入的内容");
            ctx.writeAndFlush(Unpooled.copiedBuffer(sc.next(), CharsetUtil.UTF_8));
        }
    }
}
