package com.openjdk.java.net.broadcast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * Created by xin on 2019/10/25.
 */
public class BroadcastServer {

    public static void main(String[] args) throws IOException {
        // 注: 如果不指明广播地址, 发往任意本机接口且端口是8080的数据都会被接收
        DatagramSocket socket = new DatagramSocket(new InetSocketAddress("172.16.40.255", 8080));
        DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
        while (true) {
            socket.receive(packet);
            System.out.println(new String(packet.getData(), 0, packet.getLength()));
        }
    }
}
