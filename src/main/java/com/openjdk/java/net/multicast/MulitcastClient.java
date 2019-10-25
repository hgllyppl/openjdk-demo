package com.openjdk.java.net.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;

/**
 * Created by xin on 2019/10/25.
 */
public class MulitcastClient {

    public static void main(String[] args) throws IOException {
        byte[] data = "multicast test".getBytes();
        MulticastSocket ms = new MulticastSocket();
        DatagramPacket dataPacket = new DatagramPacket(data, data.length, new InetSocketAddress("224.0.0.1", 8080));
        ms.send(dataPacket);
        ms.close();
    }
}
