package UDP;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

//重构第一步：通过命令行读取用户输入作为请求大发送
//重构第二步：读取服务器发回的响应
public class Client {
    //127.0.0.1代表本机
    private static final String serverIP = "127.0.0.1";

    public static void main(String[] args) throws IOException {
        //1.创建UDP的Socket
        //不需要传入端口，让OS 自动分配
        try(DatagramSocket clientSocket = new DatagramSocket()){
            Scanner scanner = new Scanner(System.in);

            byte[] receiveBuffer = new byte[8192];

            System.out.println("请输入请求");
            while(scanner.hasNextLine()) {
                //1.准备好请求，同时传输的必须是字符格式
                String request = scanner.nextLine();

                byte[] requestBytes = request.getBytes(Server.charest);

                //2.发送请求
                //2.1先准备DatagramPacket 需要指定服务器的 ip + port
                //1)需要发送的数据信息 requestBytes+0,requestBytes+length
                //2)接受信息的唯一标识（ip+port)
                // InetAddress.getByName("127.0.0.1")会把ip转成InetAddress对象;
                DatagramPacket packetToServer = new DatagramPacket(
                        requestBytes, 0, requestBytes.length, //要发送的是数据
                        InetAddress.getByName(serverIP), Server.PORT);//要发送到互联网的那个进程上

                clientSocket.send(packetToServer);

                //接收响应
                DatagramPacket packetFromServer = new DatagramPacket(
                        receiveBuffer, 0, receiveBuffer.length//提供的是用来装数据的容器信息
                );
                clientSocket.receive(packetFromServer);

                String response = new String(receiveBuffer, 0, packetFromServer.getLength());
                System.out.println("服务器应答: " + response);

                System.out.print("请输入请求> ");
            }
        }
    }
}
