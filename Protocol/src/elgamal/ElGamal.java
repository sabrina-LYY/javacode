package Elgamal;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class elgamal {

    private static final BigInteger ONE = BigInteger.ONE;

    // 获取随机大素数p
    public static BigInteger getPrime(int bitLenth) {
        BigInteger p = BigInteger.probablePrime(bitLenth, new Random());
        while(!p.isProbablePrime(6)) {
            p.nextProbablePrime();
        }
        return p;
    }


    // 枚举遍历求生成元g
    public static BigInteger getG(BigInteger p, BigInteger p_MinusOne) {
        BigInteger g = null;

        outterLoop: for (int i = 2; i < 50; i++) {
            //p_MinusOne阶循环群
            for (int x1 = 1; x1 <= Integer.valueOf(p_MinusOne.toString()); x1++) {
                String str1 = String.valueOf(i);
                String str2 = String.valueOf(x1);
                BigInteger tmp1 = new BigInteger(str1);
                BigInteger tmp2 = new BigInteger(str2);
                if (tmp1.modPow(tmp2, p).compareTo(ONE) == 0 && tmp2.compareTo(p_MinusOne) == -1) {
                    break;
                } else if (tmp1.modPow(tmp2, p).compareTo(ONE) == 0 && tmp2.compareTo(p_MinusOne) == 0) {
                    g = tmp1;
                    break outterLoop;
                }
            }
        }

        return g;
    }


    /**
     * 取随机数k
     * @param p
     * @return
     */
    public static BigInteger getRandomk(BigInteger p) {
        ///随机取一个与p-1互质的数k & 0<=k<p-1
        Random r = new Random();
        BigInteger k = null;
        while(true)
        {
            k = new BigInteger(p.bitLength()-1,r);//产生一0<=x<p-1的随机数
            if(k.gcd(p.subtract(BigInteger.ONE)).equals(BigInteger.ONE))
            {//如果随机数与p-1互质 则选取成功,返回随机数k
                break;
            }
        }
        return k;
    }



    /**
     2  * 判断a是否为模m的原根，其中m为素数
     3  * @param a
     4  * @param m
     5  * @return
     6  */
    public static boolean isOrigin(BigInteger a, BigInteger m) {
        if (a.gcd(m).intValue() != 1) return false;
        BigInteger i = new BigInteger("2");
        while (i.compareTo(m.subtract(BigInteger.ONE)) == -1) {
            if (m.mod(i).intValue() == 0) {
                if (a.modPow(i, m).intValue() == 1)
                    return false;
                while (m.mod(i).intValue() == 0)
                    m = m.divide(i);
                }
            i = i.add(BigInteger.ONE);
            }
        return true;
        }


    /**
     * 加密一个消息m(m为BigInteger类型) 并返回加密结果为一个BigInteger数组
     * @param m
     * @param p
     * @param b
     * @param g
     * @return
     */
    public static BigInteger[] encrypt(BigInteger y, BigInteger g, BigInteger p, BigInteger a) {
        //随机选取一个k gcd(k,p-1)=1 0<=x<p
        BigInteger [] rtn = new BigInteger[2];//定义一个BigInteger数组,存贮返回的加密对象C1,C2
        BigInteger k = getRandomk(p); //随机取满足条件的k为（1，p-1）
        //计算密文C1,C1
        BigInteger C1 = g.modPow(k, p);
        BigInteger C2 = ((y.modPow(k,p)).multiply(a.modPow(m, p)));
        //保存密文到对象中
        rtn[0] = C1;
        rtn[1] = C2;
        return rtn;
    }


//解密
    public static BigInteger decrypt(BigInteger C1,BigInteger C2,BigInteger a,BigInteger p) {
        BigInteger m = null;
        a.modPow(m,p) = C2.multiply((C1.modPow(x, p)).modPow(-1,p)).mod(p);
        return a.modPow(m,p);
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BigInteger m = scan.nextBigInteger();//明文M 0<=m<p
        int length = m.bitLength();

        BigInteger p = getPrime(length);
        BigInteger p_MinusOne = p.subtract(ONE);


        // 枚举遍历求生成元g
        BigInteger g = null;
        g = getG(p, p_MinusOne);
        System.out.println("g = " + g.toString());

         //随机数x,满足区间[2,p-1)
        BigInteger x = new BigInteger(length,new Random());
        System.out.println("x = " + x.toString());

        // 计算y ≡ g^x（ mod p ）
        BigInteger y = g.modPow(x,p);
        System.out.println("y = " + y.toString());




        BigInteger [] rtn = {null,null};
        BigInteger b = calculateb(g,y,p);
        rtn = encrypt(m, p, b, g);

        p = rtn[0];
        g = rtn[1];
        y = getRandoma(p);
        b = calculateb(g, y, p);
        //rtn = ElGamal.encrypt(m, p, b, g);
        //System.out.println("密文:"+rtn[0]+","+rtn[1]);
        //BigInteger dm = ElGamal.decrypt(rtn[0], rtn[1], a, p);
        //System.out.println("解密:"+dm);
        decrypt(c1,c2,y,p);

    }

}
