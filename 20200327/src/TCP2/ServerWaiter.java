package TCP2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ServerWaiter extends Thread {
    private  final Socket socket;
    ServerWaiter(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {System.out.println("连接上了一个客户端");
            InputStream is = null;

            is = socket.getInputStream();

            InputStreamReader isReader = new InputStreamReader(is, "UTF-8");
            Scanner scanner = new Scanner(isReader);

            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osWriter = new OutputStreamWriter(os, "UTF-8");
            PrintWriter printWriter = new PrintWriter(osWriter);

            //一个链接可以发送多个请求
            //服务器在这个循环中处理客户端1 的数据，不知道客户端2已连接上来
            //知道客户端1关闭连接hasNextLine()返回false,服务器才能重新处理下一个客户端连接
            while (scanner.hasNextLine()) {
                String request = scanner.nextLine();//客户端1没有发送数据，这个方法就不会返回
                System.out.println(request);

                //处理请求---->响应
                String response = request;//回显

                //发送响应，也要带着\r\n
                printWriter.println(response);
                printWriter.flush();

            }
            System.out.println("==============");
            socket.close();
    }catch (IOException e) {
        e.printStackTrace();
        }
    }
}
