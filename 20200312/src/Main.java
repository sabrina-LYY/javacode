import java.util.Scanner;
public class Main {
    //求n的阶乘结果的末尾有几个0；
    /*本题就是找规律
    *会发现2*5=10，这样子就多出来一个0了，所以问题可以转化成求有多少对2和5，
    但2的个数明显比5还要多，所以只关心5的个数就好了。
    当然了，有时候一个数里可不止一个5，比如25=5*5，125=5*5*5。

    */
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int count = 0;
            while(n>0){
                count+=n/5;
                n/=5;
            }
            System.out.println(count);
        }
    }



    //整数以字符串形式逆序输出
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            StringBuffer sb = new StringBuffer();
            while(n>0){
                sb.append(String.valueOf(n%10));
                n/=10;
            }
        }
    }
}
