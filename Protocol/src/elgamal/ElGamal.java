package Elgamal;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class elgamal {

    private static final BigInteger ONE = BigInteger.ONE;

    // 获取随机大素数
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
     * 加密一个消息m(m为BigInteger类型) 并返回加密结果为一个BigInteger数组
     * @param m
     * @param p
     * @param b
     * @param g
     * @return
     */
    public static BigInteger[] encrypt(BigInteger m, BigInteger p, BigInteger b, BigInteger g) {
        //随机选取一个k gcd(k,p-1)=1 0<=x<p
        BigInteger [] rtn = new BigInteger[2];//定义一个BigInteger数组,存贮返回的加密对象C1,C2
        BigInteger x = getRandomk(p); //随机取满足条件的x为（1，p-1）
        //计算密文C1,C1
        BigInteger C1 = g.modPow(x, p);
        BigInteger C2 = m.multiply(b.modPow(x, p)).mod(p);
        //保存密文到对象中
        rtn[0] = C1;
        rtn[1] = C2;
        return rtn;
    }
    /**
     * 取随机数k
     * @param p
     * @return
     */
    public static BigInteger getRandomk(BigInteger p)
    {
        ///随机取一个与p-1互质的数x & 0<=x<p-1
        Random r = new Random();
        BigInteger x = null;
        while(true) {
            x = new BigInteger(p.bitLength()-1,r);//产生一0<=x<p-1的随机数
            if(x.gcd(p.subtract(BigInteger.ONE)).equals(BigInteger.ONE)) {
                //如果随机数与p-1互质 则选取成功,返回随机数k
                break;
            }
        }
        return x;
    }


    /**
     * 取随机数y
     * @param p
     * @return
     */
    public static BigInteger getRandoma(BigInteger p)
    {
        Random r = new Random();

        //构造一个随机生成的BigInteger，均匀分布在0到（2^numBits - 1）的范围内。
        BigInteger y = new BigInteger(p.bitLength()-1,r);
        return y;
    }
    /**
     * 计算b的值
     * @param g
     * @param y
     * @param p
     * @return
     */
    public static BigInteger calculateb(BigInteger g,BigInteger y ,BigInteger p) {
        BigInteger b = null;
        b = g.modPow(y, p);
        return b;
    }


    /**
     * 取一个大的随机素数P,和P的生成元a
     * @param alpha 为该素数的比特位数
     * @return
     */
    public static BigInteger [] getRandomP(int alpha) {
        BigInteger rtn [] = {null,null};
        Random r = new Random();
        BigInteger p = null;
        BigInteger q = null;
        //选取一个安全素数Q, p = 2q+1 如果P为素数,选定成功
        while(true)
        {
            q = BigInteger.probablePrime(alpha, r);//new BigInteger(alpha,r); //取一个随机数q, r为随机数发生器 alpha 为想要得到随机数大小[2^alpha]p = 2^alpha
            if(q.bitLength() != alpha) //判断生成的随机数q<2^alpha 如果q<2^alpha 重新再生成一个随机数直到q>2^alpha
                continue;
            if(q.isProbablePrime(10)) //如果q为素数则再进一步计算生成元
            {
                p = q.multiply(new BigInteger("2")).add(BigInteger.ONE); // 选取一个安全素数P=2*Q+1
                if(p.isProbablePrime(10)) //如果P为素数则选取成功 否则继续第一步
                    break;
            }
        }
        //计算p 的乘法群
        //在Zp中选择一个g != 1
        BigInteger g = null;
        while(true)
        {
            g = BigInteger.probablePrime(p.bitLength()-1, r);//new BigInteger(p.bitLength()-1,r);//从Zp*中随机取出一个元
            if(!g.modPow(BigInteger.ONE, p).equals(BigInteger.ONE) && !g.modPow(q, p).equals(BigInteger.ONE))
            {////在Z*p中任选一元素a!=1,计算a^2 mod P 和a^Q mod P ,如它们都不等于1,则a是生成元,否则继续选取
                break;
            }
        }
        rtn[0] = p;
        rtn[1] = g;
        return rtn;
    }
//解密
    public static BigInteger decrypt(BigInteger C1,BigInteger C2,BigInteger y,BigInteger p)
    {
        BigInteger m = null;
        m = C2.multiply(C1.modPow(y.negate(), p)).mod(p);
        return m;
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

        // h ≡ g^x（ mod p ）
        BigInteger h = g.modPow(x,p);
        System.out.println("h = " + h.toString());

        // 随机的大素数y,满足区间(1,p-1)
        BigInteger y = getPrime(length);
        System.out.println("y = " + y.toString());

        // y的逆元
        BigInteger y_Reverse = y.modInverse(p_MinusOne);
        System.out.println("y对p-1的逆元 = " + y_Reverse.toString());



        BigInteger b = calculateb(g,y,p);
        encrypt(m,p,b,g);


        BigInteger [] rtn = {null,null};
        rtn = getRandomP(new BigInteger(bitLength());//取得随机数P,和P的生成元g

        p = rtn[0];
        g = rtn[1];
        a = getRandoma(p);
        b = calculateb(g, a, p);
        //rtn = ElGamal.encrypt(m, p, b, g);
        //System.out.println("密文:"+rtn[0]+","+rtn[1]);
        //BigInteger dm = ElGamal.decrypt(rtn[0], rtn[1], a, p);
        //System.out.println("解密:"+dm);
        decrypt(c1,c2,y,p);

    }

}
