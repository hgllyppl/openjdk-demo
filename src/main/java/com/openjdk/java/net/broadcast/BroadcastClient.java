package com.openjdk.java.net.broadcast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * Created by xin on 2019/10/25.
 */
public class BroadcastClient {

    public static void main(String[] args) throws IOException {
        byte[] data = "broadcast test".getBytes();
        DatagramSocket socket = new DatagramSocket();
        DatagramPacket packet = new DatagramPacket(data, data.length, new InetSocketAddress("172.16.40.255", 8080));
        socket.send(packet);
        socket.close();
    }
}
