package http;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        String host = "127.0.0.1";
        String path = "/20200403/index.html";
        try(Socket socket = new Socket(host,8080)){
            String request = "GET "+path+" HTTP/1.0\r\n"+"Host:"+host
                    +"\r\n"+"\r\n";

            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            printWriter.print(request);
            printWriter.flush();

            //请求发送结束
            //读取响应

            byte[] responseBuffer = new byte[8192];
            int len = socket.getInputStream().read(responseBuffer);

            String response = new String(responseBuffer,0,responseBuffer.length,"UTF-8");
            System.out.println(response);
        }
    }
}
