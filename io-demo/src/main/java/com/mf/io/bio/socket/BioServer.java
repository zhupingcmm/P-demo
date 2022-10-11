package com.mf.io.bio.socket;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BioServer {

    public static void main(String[] args) throws IOException {
        System.out.println("服务端启动。。。");
        System.out.println("启动端口 9999");
        ServerSocket serverSocket = new ServerSocket(9999);
        while (true) {
            Socket socket = serverSocket.accept();

            Process.getInstance().handle(socket);

        }
    }


    static class Process {
        public static volatile Process instance;

        public ThreadPoolExecutor poolExecutor;

        private Process () {
            poolExecutor = new ThreadPoolExecutor(
                    5, 10, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(20)
            );
        }

        public static Process getInstance() {

            if (instance  == null) {
                synchronized (Process.class) {
                   if (instance == null) {
                       instance = new Process();
                   }
                }
            }

            return instance;
        }

        private void handle(Socket socket) {
            poolExecutor.execute(() -> {
               try {
                   InputStream in = socket.getInputStream();
                   String clintIP = socket.getInetAddress().getHostAddress();
                   byte [] bytes = new byte[1024];
                   in.read(bytes);
                   System.out.println(clintIP + " 说:" + new String(bytes).trim());

                   OutputStream os = socket.getOutputStream();
                   System.out.println("请输入： ");
                   Scanner scanner = new Scanner(System.in);
                   os.write(scanner.nextLine().getBytes());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } finally {
                   try {
                       socket.close();
                   } catch (IOException e) {
                       throw new RuntimeException(e);
                   }
               }
            });
        }



    }
}
