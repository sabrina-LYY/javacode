import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.pow;


public class PvtCmps1 {

     public static BigInteger[] PvtCmps(int xo,int yo,int b1) {
         Random rand = new Random();
         Elgamal elgamal = new Elgamal();
         int t = 10;


         String xB =Integer.toBinaryString(xo);
         BigInteger[] x = new BigInteger[t];
         String yB = Integer.toBinaryString(yo);

         BigInteger[] y = new BigInteger[t];


         for(int i=0;i<t;i++){
             x[i]=BigInteger.valueOf(xB.charAt(i));
             y[i]=BigInteger.valueOf(yB.charAt(i));

         }


        BigInteger Ysum = null;
        BigInteger b = null;
        for(int i=1;i<=t;i++){
            b = BigInteger.valueOf((long) pow(2,t-i));
            Ysum=Ysum.add(y[i].multiply(b));


        }

        //计算c
        int s=0;
        s=1-(2*b1);
        int j=0;
        BigInteger[] c = new BigInteger[t];
        List<BigInteger> list = new ArrayList<>();
        BigInteger[][] ec = new BigInteger[t+1][2];
        BigInteger mid = null;

        int[] r = new int[t+1];

        String ps = (elgamal.p).toString();
        int pB = Integer.valueOf(ps);
         for(int i=1;i<=t;i++){
             //每次循环产生一个随机数
             r[i]=(int)(Math.random()*pB)+1;

            if(j<i){

                mid=mid.add(x[j].xor(y[j]));
            }
            j++;
            BigInteger b3 = new BigInteger("3");
            c[i]=(BigInteger.valueOf(r[i])).multiply(x[i].subtract(y[i]).add(BigInteger.valueOf(s).add(mid.multiply(b3))));
            //对c加密
            ec[i]= elgamal.encrypt(c[i]);
        }
         for(int i=1;i<=t;i++){
             for(int k=0;k<2;k++){
                 list.add(ec[i][k]);
             }
         }
        BigInteger[] C = list.toArray(new BigInteger[list.size()]);

        return C;
    }



}
