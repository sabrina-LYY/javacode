import java.io.File;
import java.io.IOException;

public class RelativePathDemo {
    public static void main(String[] args) throws IOException {
        String workingDirectory = System.getProperty("user.dir");
        System.out.println("相对路径是相对于这个工作路径");
        System.out.println("这个工作路径就是进程启动所在的路径");
        String filename = "一个相对路径的文件名.txt";

        File file = new File(filename);
        System.out.println(file.getAbsoluteFile());
        file.createNewFile();
    }
}
