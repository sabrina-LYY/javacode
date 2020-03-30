package UDP;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


import javax.sql.DataSource;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



//必须公开port，否则客户端找不到
//端口可以在0~65535之间随便选，但不能使用被其他进程使用的端口

//重构第一步：把收到的请求内容作为响应发送给客户
//重构第二步：多加些调试打印信息，便于观察发生了什么
//重构第三步：增加业务
public class Server {
    static  final int PORT = 9527;
    static final String charest = "UTF-8";
    private static final DataSource dataSource;

    static{
        MysqlDataSource mysqlDataSource = new MysqlDataSource();

        //通过ip+port确定互联网上的唯一一个进程（mysql）
        mysqlDataSource.setServerName("127.0.0.1");
        mysqlDataSource.setPort(3306);

        //MYSQL登录需要用到的信息--应用层使用的
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("");
        mysqlDataSource.setDatabaseName("java20_0329");
        mysqlDataSource.setCharacterEncoding("utf8");

        //设置MYSQL连接用的属性---不用SSL连接
        mysqlDataSource.setUseSSL(false);
        dataSource = mysqlDataSource;
    }



/*
    //Map<英文单词，中文含义>
    private static final Map<String,String> meaningMap = new HashMap<>();
    //Map<英文单词，实例语句>
    private static final Map<String,List<String>> exampleCentencesMap = new HashMap<>();

    static {
        //在静态代码块中对两个map进行初始化
        meaningMap.put("give","v. 给;交给;赠送;赠与;送给;(为某人)提供，供给，供应");
        exampleCentencesMap.put("give",new ArrayList<>());
        exampleCentencesMap.get("give").add("What are you giving your father for his birthday?");
        exampleCentencesMap.get("give").add("She was given a huge bunch of flowers");
        meaningMap.put("send","v.邮寄;发送;传达;转致;告知;派遣;打发;安排去");
        exampleCentencesMap.put("send",new ArrayList<>());
        exampleCentencesMap.get("send").add("Have you sent your mother a postcard yet?");
        exampleCentencesMap.get("send").add("I'll send you a text message.");
    }
*/
    public static void main(String[] args) throws IOException {
        //1.创建套接字
        //DatagramSocket是UDP协议专用的套接字
        //port是选好准备开饭店的地址
        System.out.println("DEBUG:准备开一家饭店");

        try(DatagramSocket serverSocket = new DatagramSocket(PORT)) {
            System.out.printf("DEBUG:在%d这个端口开好一家饭店了%n", PORT);

            //提前准备好一个字节数组，用来存放接收到的数据（请求）
            //一次最多可以接受8192个字节
            byte[] receiveBuffer = new byte[8192];
            while(true){
                //一次循环就是一次请求-响应的处理过程
                //1.接收对方发送来的请求（数据）
                //1.1必须先创建DatagramPacket数据报文对象
                DatagramPacket packetFromClient = new DatagramPacket(receiveBuffer
                ,0,receiveBuffer.length);
                System.out.println("DEBUG:准备好接收用的packet");
                //1.2接受数据
                serverSocket.receive(packetFromClient);//不是立即返回
                //走到这里，数据一定接收到了
                //packetFromClient.getlength()；一共接收到多少字节的数据
                //1.3因为收到的是字节格式的数据，所以把数据解码成字符格式
                //利用String 的一个构造方法，
                // 把字节数组的数据解码(decode)成字符格式的数据 String
                String request = new String(receiveBuffer,0,packetFromClient.getLength(),charest);
                System.out.println("DEBUG: 收到的请求是: " + request);

                //1.4跳过了理解请求这一步---没有设计应用层协议
                //1.5业务处理
                //String response = request;
                //1.5.1请求就是英文单词，
                //          根据英文单词获取含义+实例语句，
                //          要考虑用户的请求不是我们支持的单词
  /*              String response = "不存在这个单词";
                String template = "含义:\r\n%s\r\n示例语句：%s\r\n";
                String exampleTemplate ="%d.%s\r\n";
                if(meaningMap.containsKey(request)){
                    String meaning = meaningMap.get(request);
                    List<String> sencetenceList = exampleCentencesMap.get(request);
                    StringBuilder exampleSb = new StringBuilder();
                    for(int i=0;i<sencetenceList.size();i++){
                        exampleSb.append(String.format(exampleTemplate,i+1,sencetenceList.get(i)));
                    }
                    response = String.format(template,meaning,exampleSb.toString());
                }

*/

                String response = "没有这个单词！";
                try(Connection con = dataSource.getConnection()){
                    String sql = "SELECT ch FROM vocabulary WHERE en = ?";
                    try(PreparedStatement stmt = con.prepareStatement(sql)){
                        stmt.setString(1,request);
                        //尤其要防止SQL注入，用户发来的数据不要完全相信，可能会有恶意用户

                        try(ResultSet rs = stmt.executeQuery()){
                            if(rs.next()){
                                response = rs.getString("cn");
                            }
                        }
                    }
                }catch(SQLException e){
                    e.printStackTrace();//打印在server这边
                    response = e.getMessage();//准备发送给客户端的响应

                }



                //1.6发送响应

                //如何获取客户端进程的IP+PORT
                InetAddress clientAddress = packetFromClient.getAddress();
                int clientPort = packetFromClient.getPort();
                System.out.printf("DEBUG: 客户端的唯一标识是(%s:%d)%n",
                        clientAddress.getHostAddress(),clientPort);

                byte[] responseBytes = response.getBytes(Server.charest);
                DatagramPacket packetToClient = new DatagramPacket(
                        responseBytes,0,responseBytes.length,clientAddress,clientPort
                );
                System.out.println("DEBUG: 准备好了发送用的 packet");

                serverSocket.send(packetToClient);
                System.out.println("DEBUG: 成功把响应发送给客户端了");
                System.out.println("==========================================");
            }
        }
    }
}
