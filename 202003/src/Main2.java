import java.util.Scanner;

//统计每月兔子的总数
/*有一只兔子，从出生后第3个月起每个月都生一只兔子，
小兔子长到第三个月后每个月又生一只兔子，
假如兔子都不死，问每个月的兔子总数为多少？
输入int型表示month，输出兔子总数int型*/
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int month = in.nextInt();
            System.out.println(func(month));
        }
    }

    public static int func(int month){
        if(month<3){
            return 1;
        }
        return func(month-1)+func(month-2);
    }

}
