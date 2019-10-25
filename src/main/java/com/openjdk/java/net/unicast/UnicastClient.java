package com.openjdk.java.net.unicast;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by xin on 2019/10/25.
 */
public class UnicastClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);
        socket.getOutputStream().write("unicast test".getBytes());
        byte[] bytes = new byte[1024];
        int len = socket.getInputStream().read(bytes);
        System.out.println(new String(bytes, 0, len));
        socket.close();
    }
}
