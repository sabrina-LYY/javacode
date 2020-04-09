package chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;


public class chatClient {
    public static void main(String [] args) throws EOFException{
        System.out.println("客户端启动...");
        Thread thread=new Thread(()->{
            try (
                    //127.0.0.1是回送地址，指本地机，一般用来测试使用。
                    // 回送地址是本机回送地址（Loopback Address），
                    // 即主机IP堆栈内部的IP地址，主要用于网络软件测试以及本地机进程间通信，
                    // 无论什么程序，一旦使用回送地址发送数据，协议软件立即返回，不进行任何网络传输。
                    //8080是自己的电脑的端口号

                    //用socket在本机实现连接
                    Socket socket=new Socket("127.0.0.1",8080);
                    //将socket在本机中获得的输入流和输出流赋给当前程序
                    DataInputStream inputStream=new DataInputStream(socket.getInputStream());
                    DataOutputStream outputStream=new DataOutputStream(socket.getOutputStream());
                    //额外定义输入流，System.in表示从控制台也就是console可以输入到bufferedReader中
                    BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
            ){
                while(true) {
                    String aString=bufferedReader.readLine();
                    if(aString.equals("bye"))break;
                    outputStream.writeUTF(aString);
                    outputStream.flush();

                    String iString=inputStream.readUTF();
                    System.out.println(iString);
                }
            } catch (UnknownHostException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

            }
            catch (ConnectException e) {
                System.out.println("服务器未启动！");
            }catch (IOException e) {//必须放在所有的catch的最后
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("客户端停止");
        });
        thread.start();
    }
}

