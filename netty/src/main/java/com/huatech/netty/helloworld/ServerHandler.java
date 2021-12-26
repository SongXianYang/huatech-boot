package com.huatech.netty.helloworld;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Scanner;

/**
 * @author Songxianyang
 * @description:
 * @create: 2021-12-21 22:01
 **/
public class ServerHandler extends SimpleChannelInboundHandler<ByteBuf> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        byte[] req = new byte[msg.readableBytes()];
        msg.readBytes(req);
        String body = new String(req, "utf-8");
        System.out.println("server: " + body);

        String resp = null;
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            System.out.println("输入想要输入的内容");
            resp = sc.next();
            ctx.writeAndFlush(Unpooled.copiedBuffer(resp.getBytes()));
        }
    }
}
