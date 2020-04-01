package TCP;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        try(Socket socket = new Socket("127.0.0.1",9527)){
            //建立链接，剩下的循环，全部在一个连接中完成

            Scanner netscanner = new Scanner(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            PrintWriter newWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
            while(true){
                String request = scanner.nextLine();

                newWriter.println(request);
                newWriter.flush();

                String response = netscanner.nextLine();
                System.out.println(response);
            }
        }
    }
}
