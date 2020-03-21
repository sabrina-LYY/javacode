import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        /*{//传入路径（绝对/相对）构造文件对象
            //File 对象文件不存在
        String path = "G:\\论文\\没有这个文件.txt";
        File file = new File(path);
        System.out.println(file);
        }

        {
            //File 对象文件存在
            String path = "G:\\论文\\我是一个文件.txt";
            File file = new File(path);
            System.out.println(file);

        }

        {
            //传入一个父路径
            String parent = "G:\\论文";
            String path ="我是一个文件.txt";
            File file = new File(parent,path);
            System.out.println(file);

            //获取常见属性
            System.out.println(file.exists());
            System.out.println(file.getAbsoluteFile());
            System.out.println(file.getName());
            System.out.println(file.getParent());
            System.out.println(file.isAbsolute());
            System.out.println(file.isDirectory());//是目录吗
            System.out.println(file.canRead());
            System.out.println(file.canWrite());
        }
        {
            //普通文件创建
            String parent = "G:\\论文";
            String filename ="啦啦啦.txt";

            File file = new File(parent,filename);
            System.out.println(file.exists());
            boolean success = file.createNewFile();
            if(success){
                System.out.println(filename+"创建成功");
            }else{
                System.out.println(filename+"已经存在");
            }
        }

        {
            //文件夹的创建过程
            String parent = "G:\\论文";
            String filename = "一个新的文件夹";
            File file = new File(parent,filename);
            System.out.println(file.exists());

            //file.mkdir()和file.mkdirs()有区别，
            //file.mkdirs()会把需要创建的中间文件夹一并创建出来。
            boolean success = file.mkdir();

            if(success){
                System.out.println(filename+"创建成功");
            }else{
                System.out.println(filename+"文件夹原来就存在");
            }

        }
        {
            //直接删除存在的文件，不是移动到回收站
            String parent = "G:\\论文";
            String filename = "我是一个文件.txt";

            File file = new File(parent,filename);
            System.out.println(file.exists());

            file.delete();

        }*/
        {
            //遍历文件夹
            String path = "G:\\论文";
            File dir = new File(path);
            File[] files = dir.listFiles();
            //files == null  或  files.length = 0
            if (files != null) {
                for (File file : files) {
                    System.out.println(file.getName());
                }
            }
        }
    }
}
