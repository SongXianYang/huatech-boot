package com.huatech.boot.nio;

import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * @description: 客户端
 * @author: SongXY
 * @create: 2021-10-26 22:10
 **/
public class NioClient {
    public static void main(String[] args) throws IOException {
        new NioClient().start();
    }

    private void start() throws IOException {
        //建立socket   连接服务端
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8000));
        //向服务器发送数据
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String request = scanner.nextLine();
            if (!StringUtils.isEmpty(request)) {
                channel.write(Charset.forName("UTF-8").encode(request));
            }
        }
        //
        //
        //
        //
    }
}
