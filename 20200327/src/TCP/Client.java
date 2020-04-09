package TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {

        //1.创建Socket
        //2.绑定本地IP+本地端口port(os分配)
        //3.连接远端IP+远端port（127.0.0.0:9527
        //面向连接
        try(Socket socket = new Socket("127.0.0.1",9527)){
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osWriter = new OutputStreamWriter(os,"UTF-8");
            PrintWriter printWriter = new PrintWriter(osWriter);

            printWriter.print("发送一个请求");
            printWriter.flush();

            //裸用OutputStrean
            /*String[] requests = {"你好","世界","haha"};
            OutputStream os = socket.getOutputStream();
            for(String request:requests){
                request = String.format("%d:|%s|:%d",1,request,100);
                byte[] requestBytes = request.getBytes("UTF-8");
                os.write(requestBytes,0,requestBytes.length);
                os.flush();
            }*/

           /* OutputStream os = socket.getOutputStream();
            OutputStreamWriter osWriter = new OutputStreamWriter(os,"UTF-8");
            PrintWriter printWriter = new PrintWriter(osWriter);
            String[] requests = {"你好","世界","haha"};
            for(String request:requests){
                printWriter.printf("%d:|%s|:%d",1,request,100);
                os.flush();*/

        }
    }
}
