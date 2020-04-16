import java.util.*;
public class Main {
    //删除公共字符
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String src = in.nextLine();
            String str = in.nextLine();
            char[] a = src.toCharArray();
           for(int i=0;i<a.length;i++){
               if(!str.contains(String.valueOf(a[i]))){
                   System.out.print(a[i]);
               }
           }
            System.out.println();
        }
    }


    //逆置字符串
    //输入：who am i    输出：i am who
    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String  str= in.nextLine();
            String[] a = str.split(" ");
            for(int i=a.length-1;i>=0;i--){
                System.out.print(a[i]);
                if(i!=0){
                    System.out.print(" ");
                }else{
                    System.out.println();
                }
            }
        }
    }
}

