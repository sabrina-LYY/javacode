import java.math.BigInteger;
import java.util.Scanner;
public class test {
    /*完成两个超长正整数的加法。
    输入两个字符串数字,输出相加后的结果，string型
    示例1
    输入9999999999999999999999999999999999999999999999     1
    输出100000000000000000000000000000000000000000000000000000000000000*/

    //参考BigInteger类就可以处理
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str1 = scan.nextLine();
            String str2 = scan.nextLine();
            BigInteger num1 = new BigInteger(str1);
            BigInteger num2 = new BigInteger(str2);
            System.out.println(num1.add(num2));
        }
    }
}
