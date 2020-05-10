package com.lyy;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private  static final int PORT = 8080;
    public static void main(String[] args) throws IOException {
        /**
         * TCP服务器
         * 1.创建SOCKET
         * 2.绑定本地IP+port
         * 3.对socket进行Listen
         * 4.通过调用accept等待三次握手成功的客户端
         */
        //通过线程池的方式支持客户端并发处理
        ExecutorService pool = Executors.newFixedThreadPool(8);
        try(ServerSocket serverSocket = new ServerSocket(PORT)){
            while(true){
                Socket socket = serverSocket.accept();
                pool.execute(new TransactionTask(socket));
            }
        }
    }
}
