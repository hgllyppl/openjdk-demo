package com.openjdk.java.net.unicast;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by xin on 2019/10/25.
 */
public class UnicastServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket;
        while ((socket = serverSocket.accept()) != null) {
            InputStream is = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len = is.read(bytes);
            System.out.println(new String(bytes, 0, len));
            socket.getOutputStream().write("bye.".getBytes());
            socket.close();
        }
    }
}
