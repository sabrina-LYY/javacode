package TCP;

import com.oracle.xmlns.internal.webservices.jaxws_databinding.SoapBindingParameterStyle;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//有连接的
public class Server {
    public static void main(String[] args) throws IOException {
        //1.创建TCP的Server Socket
        //  1.创建 （create）socket
        //  2.绑定（bind）socket《--》本地IP+本地port
        //  3.监听（listen）socket等待客户端过来连接
        try(ServerSocket serverSocket = new ServerSocket(9527)){
            while(true){
                //不断接待客户
                //和UDP不同，不是以请求为单位接待的，而是以连接(connection)
                try(Socket connectionSocket =serverSocket.accept() ){
                //TCP是面向字节流的
                    //IO 中的字节流
                    //is可以读取client发送过来的数据
                    InputStream is = connectionSocket.getInputStream();
                    //os可以把写给client的数据发送过去
                    OutputStream os = connectionSocket.getOutputStream();

                    //TCP字节流的特性
                    //把字节流封装成字符流
                    InputStreamReader isReader = new InputStreamReader(is,"UTF-8");
                    OutputStreamWriter osWriter = new OutputStreamWriter(os,"UTF-8");

                    //封装成Scanner 和PrintWriter方便读写
                    //Scanner isScanner = new Scanner(isReader);
                    PrintWriter osPrintWriter = new PrintWriter(osWriter);

                    //一个连接中只能发送一个请求（短连接）
                    int offset = 0;
                    int capacity = 8192;
                    char[] receiveBuffer = new char[capacity];//假设请求一定不会这么长
                    int len;
                    while(true){
                        len = isReader.read(receiveBuffer,0,capacity-offset);
                        if(len==-1){
                            break;
                        }
                        offset+=len;
                    }
                    len = offset;



                    /*char[] receiveBuffer = new char[8192];
                    int len = isReader.read(receiveBuffer);
                    System.out.println(isReader.read());//期待读到-1

                    String request = new String(receiveBuffer,0,len);
                    System.out.println("%"+request+"%");*/


                }
            }
        }
    }

}
