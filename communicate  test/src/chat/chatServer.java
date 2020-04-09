package chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class chatServer {
    public static void main(String [] args) throws EOFException {
        System.out.println("服务器运行...");
        Thread thread=new Thread(()->{//lambda表达式

            try (
                    //创建监听端口
                    ServerSocket serverSocket = new ServerSocket(8080);
                    //服务端监听客户端，那么服务端肯定是先执行，但是不能一下执行完，否则客户端无法连接，
                    //所以在打开监听端口后将会阻塞，使用accept()方法，
                    // 同时应该放在子线程中，因为主线程中最好不要出现阻塞
                    Socket socket=serverSocket.accept();

                    DataInputStream inputStream=new DataInputStream(socket.getInputStream());
                    DataOutputStream outputStream=new DataOutputStream(socket.getOutputStream());
                    //作为缓冲输入，拥有比InputStream更高的效率
                    BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
            ){
                //执行通信
                while(true) {
                    String iString=inputStream.readUTF();//读取信息要放在最前面，以读取客户端发来的信息
                    System.out.println(iString);
                    //从控制台读入信息
                    String aString=bufferedReader.readLine();
                    if(aString.equals("bye"))break;

                    //写到输出流中，由于有了连接，客户端的读入流可以读到输出流中的内容
                    outputStream.writeUTF(aString);
                    //将输出流刷新
                    outputStream.flush();


                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("服务器停止");
        });
        thread.start();
    }
}

