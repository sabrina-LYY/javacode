import java.util.Scanner;
import java.util.Stack;

public class TestDemo {


    /*某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？”答案是5瓶，
    方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，
    这时候剩2个空瓶子。然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。
    输入描述:
        输入文件最多包含10组测试数据，每个数据占一行，仅包含一个正整数n（1<=n<=100），
        表示小张手上的空汽水瓶数。n=0表示输入结束，你的程序不应当处理这一行。
    输出描述:
        对于每组测试数据，输出一行，表示最多可以喝的汽水瓶数。如果一瓶也喝不到，输出0。
        示例1输入3  10  81  0 输出1 5  40*/
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            if (n != 0) {
                System.out.println(func(n));
            }
        }
        scan.close();
    }

    public static int func(int n){
        int count = 0;
        int empty = 0;
        int i= 0;

        while (n / 3 > 0) {
            count += (n / 3);
            empty = n / 3 + n % 3;
            n = empty;
        }
        if (n==2) {
            i=1;
        }
        return i+count;
    }



    /*
有一组数，对于其中任意两个数组，若前面一个大于后面一个数字，则这两个数字组成一个逆序对。
请设计一个高效的算法，计算给定数组中的逆序对个数。
给定一个int数组A和它的大小n，请返回A中的逆序对个数。保证n小于等于5000。

测试样例：[1,2,3,4,5,6,7,0],8  返回：7*/

    public int count(int[] A, int n) {
        int count = 0;
        for(int i=0;i<A.length-1;i++){
            for(int j=i;j<n;j++){
                if(A[i] >A[j]){
                    count++;
                }
            }
        }
        return count;
    }
}
