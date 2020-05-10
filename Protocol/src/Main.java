import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = 10;

        //生成一个二进制随机数
        int b1 = new Random().nextInt( 2 );
        int s=1-(2*b1);

        //将输入的x转化为二进制的数组
        BigInteger x0 = scan.nextBigInteger();

        String result1 = x0.toString(2);//将大整数转化为二进制字符串
        char[]X = result1.toCharArray();
        int[]x = new int[t];
        for(int i=1;i<=t;i++){
            x[i] = X[i]-'0';
        }

        //将输入的y 转化为二进制的数组
        BigInteger y0 = scan.nextBigInteger();

        String result2 = y0.toString(2);//将大整数转化为二进制字符串
        char[]Y = result2.toCharArray();
        int[]y = new int[t];
        for(int i=1;i<=t;i++){
            y[i] = Y[i]-'0';
        }

        int p = scan.nextInt();
        int[] r = new int[t];
        for(int i=0;i<t;i++){
            r[i]=new Random().nextInt(p)+1 ;     // r属于[0，p)之间的随机整数
        }

        BigInteger[] C = PvtCmps1.PvtCmps(x,y,b1,r);
        int  b2 = PvtCmpc1.PvtCmpc(C,t);
    }



}
