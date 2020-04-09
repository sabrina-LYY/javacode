import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class PvtCmps1 {
    public  static BigInteger[] PvtCmps(int[]x,int[]y,int b1,int[] r) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int t = 10;
        Paillier paillier = new Paillier();




        int Ysum = 0;
        for(int i=1;i<=t;i++){
            Ysum+=y[i]*(Math.pow(2,t-i));
        }

        //计算c
        int s=0;
        s=1-(2*b1);

        int j=0;
        int mid = 0;
        int[] c = new int[t];
        List<BigInteger> list = new ArrayList<>();
        for(int i=1;i<=t;i++){
            if(j<i){
                mid+=x[j]^y[j];
            }
            c[i]=r[i]*(x[i]-y[i]+s+(3*mid));

            //对c加密
            BigInteger m = new BigInteger(String.valueOf(c[i]));
            BigInteger ec = paillier.Encryption(m);
            list.add(ec);
        }
        BigInteger[] C = list.toArray(new BigInteger[list.size()]);
        return C;
    }

}
