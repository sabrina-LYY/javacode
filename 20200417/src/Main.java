import java.util.*;
public class Main {
    //坐标移动
   /*
    开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。
    从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
    输入：合法坐标为A(或者D或者W或者S) + 数字（两位以内） 坐标之间以;分隔。
    非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 如：A10;S20;W10;D30;X;A1A;B10A11;;A10;
    处理过程：
    起点（0,0)
    +A10=（-10,0）
    +S20=(-10,-20)
    +W10=(-10,-10)
    +D30=(20,-10)
     +x=无效
     +A1A=无效
     +B10A11=无效
     +一个空 不影响
     +A10  =  (10,-10)
    结果 （10， -10）
    */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            String[] a = str.split(";");
            int x=0;
            int y=0;
            for(int i=0;i<a.length;i++){
                if(a[i].length()<=3){
                    //[0-9]+ 匹配1个或更多数字
                    if(a[i].charAt(0)=='A'&& a[i].substring(1).matches("[0-9]+")){
                        x-=Integer.valueOf(a[i].substring(1));
                    }
                    if(a[i].charAt(0)=='S'&& a[i].substring(1).matches("[0-9]+")){
                        y-=Integer.valueOf(a[i].substring(1));
                    }
                    if(a[i].charAt(0)=='W'&& a[i].substring(1).matches("[0-9]+")){
                        y+=Integer.valueOf(a[i].substring(1));
                    }
                    if(a[i].charAt(0)=='D'&& a[i].substring(1).matches("[0-9]+")){
                        x+=Integer.valueOf(a[i].substring(1));
                    }
                }

            }
            System.out.println(x+","+y);
        }
    }
}