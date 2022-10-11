package com.mf.io.bio.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class BioClient {
    public static void main(String[] args) throws IOException {
        while (true){
            Socket socket = new Socket("127.0.0.1", 9999);
            OutputStream os  = socket.getOutputStream();
            System.out.println("请输入： ");
            Scanner scanner = new Scanner(System.in);
            os.write(scanner.nextLine().getBytes());

            // 从连接中获取输入流， 接收消息
            InputStream in = socket.getInputStream();

            byte [] bytes = new byte[1024];
            in.read(bytes);
            String serverIp = socket.getInetAddress().getHostAddress();
            System.out.println(serverIp + "说: " + new String(bytes).trim());
            socket.close();
        }
    }

}
