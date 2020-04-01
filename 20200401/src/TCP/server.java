package TCP;




import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class server {
    public static void main(String[] args) throws IOException {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        //线程只有10个。同时能处理的链接，也就只有10个
        try(ServerSocket serverSocket = new ServerSocket(9527)){
            while(true){
                Socket socket =serverSocket.accept();
                //socket代表一个建好的链接

                //每次过了一个链接，就创建一个线程
               /* Thread thread = new Worker(socket);
                thread.start();*/

                //线程池好处：不需要每次创建、销毁线程
                //正式员工、临时工、队列多长
                threadPool.execute(new woker(socket));
            }
        }
    }
}
