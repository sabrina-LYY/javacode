import java.io.*;

public class 中文写OutPutStrem {
    public static void main(String[] args) throws IOException {
        String s = "张三";
        try(OutputStream os = new FileOutputStream("输出内容utf8.txt")){
            writeContent(os,s,"UTF-8");
        }
        try(OutputStream os = new FileOutputStream("输出内容gb18030.txt")){
            writeContent(os,s,"GB18030");
        }
    }
    private static void writeContent(OutputStream os,String s,String charest ) throws IOException {
        byte[] bytes = s.getBytes(charest);
        System.out.println(charest);
        System.out.println(bytes.length);

        os.write(bytes);
        os.flush();


    }
}
