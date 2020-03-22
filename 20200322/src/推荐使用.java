import java.io.*;
import java.util.Scanner;

public class 推荐使用 {
    private static void 读取的是二进制数据时() throws IOException {
        //图片、视频InputStream
        try(InputStream is = new FileInputStream("一张图片.jpg")){
            byte[] buf = new byte[8192];
            int len;
            while((len=is.read(buf))!=-1){
                //使用读到的数据buf[0,len)
            }
        }
    }
    private static void 写的是二进制数据时() throws IOException {
        //图片、视频InputStream
        try(OutputStream os = new FileOutputStream("某张图片")){
            byte[]buf = new byte[1024];
            for(int i=0;i<5;i++){
                int start = 5;
                int len = 10;
                os.write(buf,start,len);
            }
            os.flush();
        }
    }

    //读的是文本（中文、英文、其他文本）
    private static void 读取的是字符数据() throws IOException {
        try(InputStream is = new FileInputStream("某篇文章.txt")){
            try(InputStreamReader isReader = new InputStreamReader(is,"UTF-8")){
                try(Scanner scanner = new Scanner(isReader)){
                    //按行读
                    while(scanner.hasNextLine()){
                        String line = scanner.nextLine();
                    }
                }
            }
        }
    }

    //写的是文本
    private static void 写的是字符数据() throws IOException {
        try(OutputStream os = new FileOutputStream("某篇文章.txt")){
            try(OutputStreamWriter osWrite = new OutputStreamWriter(os,"UTF-8")){
                try(PrintWriter printWriter = new PrintWriter(osWrite)){
                    printWriter.println("");
                    printWriter.printf("");
                    printWriter.print("");
                    printWriter.format("");

                    printWriter.flush();
                }
            }
        }
    }


}
