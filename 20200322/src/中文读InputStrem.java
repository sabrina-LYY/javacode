import java.io.*;
import java.util.Scanner;

public class 中文读InputStrem {
    public static void main(String[] args) throws IOException {
        try(InputStream is = new FileInputStream("中文输入utf8.txt")){
            try(InputStreamReader isReader = new InputStreamReader(is, "UTF-8")){

                /*int ch;
                while ((ch = isReader.read()) != -1) {
                    char c = (char) ch;
                    System.out.println(c);
                }*/

                /*
                char[] buf = new char[1024];
                int len;
                while ((len = isReader.read(buf)) != -1) {
                    for (int i = 0; i < len; i++) {
                        System.out.println(buf[i]);
                    }
                }*/

                Scanner scanner = new Scanner(isReader);
                while(scanner.hasNextLine()){
                    System.out.println(scanner.next());
                }
            }
        }
    }




    public static void main1(String[] args) throws IOException {
        try(InputStream is = new FileInputStream("中文输入utf8.txt")){
            readContent(is,"UTF-8");
        }
        try(InputStream is = new FileInputStream("中文输入gb18030.txt")){
            readContent(is,"GB18030");
        }
    }
    public static void readContent(InputStream is,String charset) throws IOException {
        byte[] buf = new byte[8192];
        int len;

        // 这里利用了一个特性，buf 可以一次性的把所有数据都都进来
        while ((len = is.read(buf)) != -1) {
            for (int i = 0; i < len; i++) {
                System.out.println(buf[i]);
            }

            String s = new String(buf, 0, len, charset);
            System.out.println(s);
        }
    }
}
