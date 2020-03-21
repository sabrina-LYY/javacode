import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class HowToScanDirectory {
    public static void main(String[] args) {
        File root = new File("G:\\论文");
        travelDepth(root);
        travelBroad(root);
    }

    public static void travelDepth(File node){
        System.out.println(node.getAbsoluteFile());
        if(node.isDirectory()){
            File[] files = node.listFiles();
            if(files!=null){
                for(File file:files){
                    //只有不是叶子结点才能走到这
                    travelDepth(file);
                }

            }
        }
    }
    public static void travelBroad(File root){
        Queue<File> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            File front = queue.remove();
            System.out.println(front.getAbsoluteFile());
            if(front.isDirectory()){
                File[] files = front.listFiles();
                if(files!=null){
                    for(File file:files){
                        queue.add(file);
                    }
                }
            }
        }
    }
}
