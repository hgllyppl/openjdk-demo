package com.openjdk.java.net.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;

/**
 * Created by xin on 2019/10/25.
 */
public class MulitcastServer {

    public static void main(String[] args) throws IOException {
        String multicastHost = "224.0.0.1";
        // 注: 如果不指明多播地址, 发往任意本机接口且端口是8080的数据都会被接收
        MulticastSocket ds = new MulticastSocket(new InetSocketAddress(multicastHost, 8080));
        ds.joinGroup(InetAddress.getByName(multicastHost));
        while (true) {
            DatagramPacket datagramPacket = new DatagramPacket(new byte[1024], 1024);
            ds.receive(datagramPacket);
            System.out.println(new String(datagramPacket.getData(), 0, datagramPacket.getLength()));
        }
    }
}
