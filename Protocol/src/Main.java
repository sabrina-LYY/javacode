import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = 10;//bit长度

        //生成一个二进制随机数
        int b1 = new Random().nextInt( 2 );
        int s=1-(2*b1);

        //将输入的x转化为二进制每一位存到整型数组
        int X[] = new int[t+1];
        int x0 = scan.nextInt();

        String result1 = Integer.toBinaryString(x0);//将整数转化为二进制字符串
        while(result1.length()<=t){
            result1 = "0" + result1;
        }

        for(int i=1;i<=t;i++){
            char c = result1.charAt(i);
            X[i] = Integer.valueOf(c)-'0';
        }

        //将输入的y 转化为二进制每一位存到整型数组
        int Y[] = new int[t+1];
        int y0 = scan.nextInt();

        String result2 = Integer.toBinaryString(y0);//将大整数转化为二进制字符串
        while(result2.length()<=t){
            result2 = "0" + result2;
        }

        for(int i=1;i<=t;i++){
            char c = result2.charAt(i);
            Y[i] = Integer.valueOf(c)-'0';
        }



        int p = scan.nextInt();
        int[] r = new int[t];
        for(int i=0;i<t;i++){
            r[i]=new Random().nextInt(p)+1 ;     // r属于[0，p)之间的随机整数
        }

        //BigInteger[] C = PvtCmps1.PvtCmps(x,y,b1,r);
        //int  b2 = PvtCmpc1.PvtCmpc(C,t);
        //对二进制x按位加密
        Elgamal elgamal = new Elgamal();
        BigInteger[][] encX = new BigInteger[t+1][2];
        for(int i=1;i<=t;i++){
            encX[i] =elgamal.encrypt(BigInteger.valueOf(X[i]));
        }
    }
}
