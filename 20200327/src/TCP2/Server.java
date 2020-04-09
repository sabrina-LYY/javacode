package TCP2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    //链接中有多个协议
    //长连接+根据\r\n来分割请求和响应
    public static void main(String[] args) throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(8192)){
            while(true){

                Socket socket = serverSocket.accept();//等待有客户端连接上来-->主线程
                    //下面的工作交给另一个线程处理
                ServerWaiter waiter = new ServerWaiter(socket);
                waiter.start();
                    //






                    //那个客户端先连接上来，就处理哪个
                    //如果有两个客户端；服务器子专心处理客户端1的事

                   /* System.out.println("连接上了一个客户端");
                    InputStream is = socket.getInputStream();
                    InputStreamReader isReader = new InputStreamReader(is,"UTF-8");
                    Scanner scanner = new Scanner(isReader);

                    OutputStream os = socket.getOutputStream();
                    OutputStreamWriter osWriter = new OutputStreamWriter(os,"UTF-8");
                    PrintWriter printWriter = new PrintWriter(osWriter);

                    //一个链接可以发送多个请求
                    //服务器在这个循环中处理客户端1 的数据，不知道客户端2已连接上来
                    //知道客户端1关闭连接hasNextLine()返回false,服务器才能重新处理下一个客户端连接
                    while(scanner.hasNextLine()){
                        String request = scanner.nextLine();//客户端1没有发送数据，这个方法就不会返回
                        System.out.println(request);

                        //处理请求---->响应
                        String response = request;//回显

                        //发送响应，也要带着\r\n
                        printWriter.println(response);
                        printWriter.flush();

                    }
                    System.out.println("==============");*/
                }

        }

    }
}
