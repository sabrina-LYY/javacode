import java.io.*;

public class 中文写PrintWrite {
    public static void main(String[] args) throws IOException {
        try(OutputStream os = new FileOutputStream("写入中文内容utf8.txt")){
            try(OutputStreamWriter osWriter = new OutputStreamWriter(os,"UTF-8")){
                //true表示自动刷新
                PrintWriter printWriter = new PrintWriter(osWriter,true);

                printWriter.println("今天天气不错");
                printWriter.println("   20200322");
                printWriter.println("春天到了");

                printWriter.flush();

            }

        }
    }



}
