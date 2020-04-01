package TCP;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class woker  extends  Thread{
    private final Socket socket;


    public woker(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //一个链接允许有多个请求-响应
        //利用\r\n进行请求分割
        try{
        InputStream is = socket.getInputStream();
        Scanner scanner = new Scanner(new InputStreamReader(is,"UTF-8"));

        OutputStream os = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(os,"UTF-8"));

        //Client 主动关闭连接后，不再循环
        while(scanner.hasNextLine()){
            //读取请求
            //如果手动作：1.按字符方式进行读取  2.找到\r\n进行分割
            // 就利用 Scanner -> InputStreamReader -> InputStream

            String request = scanner.nextLine();

            //处理请求->响应
            String response = business(request);

            // 发送响应
            // 如果手动做： 1. 把字符响应转化为字节形式 2. 手动拼接 \r\n
            // 就利用 PrintWriter -> OutputStreamWriter -> OutputStream
            writer.println(response);
            writer.flush();
        }
        socket.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private String business(String request) {
        return request;
    }
}
