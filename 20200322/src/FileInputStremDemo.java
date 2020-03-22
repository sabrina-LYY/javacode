import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStremDemo {
    public static void main(String[] args) throws IOException {
        try(InputStream is = new FileInputStream("输入文件.txt")){
            byte[] buf = new byte[8192];
           int len;

            while((len = is.read(buf))!=-1) {
                for (int i = 0; i < len; i++) {
                    System.out.println(buf[i]);
                }
            }
        }
    }
}
