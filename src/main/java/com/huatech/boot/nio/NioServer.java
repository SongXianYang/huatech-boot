package com.huatech.boot.nio;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @description: nio  服务端
 * @author: SongXY
 * @create: 2021-10-25 21:14
 **/
@Slf4j
public class NioServer {
    public static void main(String[] args) throws IOException {
        new NioServer().start();
    }

    private void start() throws IOException {
        //创建Selector
        Selector selector = Selector.open();
        //通过ServerSocketChannel创建channel通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //监听端口
        serverSocketChannel.bind(new InetSocketAddress(8000));
        //设置非阻塞模式
        serverSocketChannel.configureBlocking(false);
        // 将channel注册到select上
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务端启动成功！");
        //循环获取接入的事件
        while (true) {
            //获取注册在select上面channel的个数
            int channelCount = selector.select();
            //如果个数小于0就结束当前循环执行下一循环
            if (channelCount == 0) {
                continue;
            }
            //获取注册在select上面channel实例
            Set<SelectionKey> channels = selector.selectedKeys();
            Iterator<SelectionKey> iterator = channels.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                iterator.remove();

                //接入事件
                if (selectionKey.isAcceptable()) {
                    acceptHandler(serverSocketChannel,selector);
                }
                //可读事件
                if (selectionKey.isReadable()) {
                    readHandler(selectionKey, selector);
                }
            }
        }
    }

    /**
     * 接入事件处理器
     */
    private void acceptHandler(ServerSocketChannel serverSocketChannel,
                               Selector selector) throws IOException {
        //如果要是接入事件，创建socketChannel
        SocketChannel socketChannel = serverSocketChannel.accept();
        //开启非阻塞
        socketChannel.configureBlocking(false);
        //将channel注册到select上，可读事件
        socketChannel.register(selector, SelectionKey.OP_READ);
        //回复客户端提示信息
        socketChannel.write(Charset.forName("UTF-8").encode("你与聊天室里其他人都不是朋友关系，请注意隐私安全"));
    }

    /**
     * 可读事件处理
     */
    private void readHandler(SelectionKey selectionKey,Selector selector) throws IOException {
        //取到可以读的channel
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        //创建buffer
        ByteBuffer buffer = ByteBuffer.allocate(2048);
        //循环读取客户端请求来的信息
        String request = "";
        while (socketChannel.read(buffer)>0) {//如果读到数据大于0就说明有数据继续向下执行
            //将buffer改为读模式
            buffer.flip();
            //修改request
            request += Charset.forName("UTF-8").decode(buffer);
        }
        //将channel注册到select上 监听可读事件
        socketChannel.register(selector, SelectionKey.OP_READ);
        //将客户端发送过来的信息广播给其他客户端
        if (!StringUtils.isEmpty(request)) {
            System.out.println("客户发送过来的消息是："+request);
        }
    }
}
