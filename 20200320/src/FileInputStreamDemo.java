
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamDemo {

    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("一个用于读的文件.txt");
        //is.read();//一次只读一个字节

        /*int b;
        while((b = is.read())!=-1){//返回-1就是读完了
            System.out.println(b);
        }
        */

        //一次读完所有字节,如果文件中是5个字母，buf只有2，要分三次读
        byte[]buf = new byte[2];
        int len ;
        while((len = is.read(buf))!=-1){
            System.out.println("读一次");
            for(int i=0;i<len;i++){
                System.out.println(buf[i]);
            }
        }
        is.close();
    }
}
