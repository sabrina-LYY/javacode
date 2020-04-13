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
    public static BigInteger calculateb(BigInteger g,BigInteger y ,BigInteger p)
    {
        BigInteger b = null;
        b = g.modPow(y, p);
        return b;
    }

//解密
    public static BigInteger decrypt(BigInteger C1,BigInteger C2,BigInteger y,BigInteger p)
    {
        BigInteger m = null;
        m = C2.multiply(C1.modPow(y.negate(), p)).mod(p);
        return m;
    }




    public static void main(String[] args) {
        //String m="123";
       // BigInteger m = new BigInteger("11111111111111"); // 明文M 0<=m<p

        Scanner scan = new Scanner(System.in);
        BigInteger m = scan.nextBigInteger();


        System.out.println("消息m = " + m);

        int length = m.bitLength();
        System.out.println("length:"+length);

        // 随机的大素数p
        BigInteger p = getPrime(length);
        System.out.println("p = " + p.toString());
        // 下面计算时用到的p-1
        BigInteger p_MinusOne = p.subtract(ONE);
        System.out.println("p-1 = " + p_MinusOne.toString());
        // 枚举遍历求生成元g
        BigInteger g = null;
        g = getG(p, p_MinusOne);
        System.out.println("g = " + g.toString());



        //BigInteger m1 = new BigInteger(m); // 明文M 0<=m<p
        System.out.println("明文:"+m);//输出
       BigInteger b = null; // 公钥<b,g,p>
        BigInteger y = null;//私钥<a,g,p> 0<a<p
        BigInteger [] rtn = new BigInteger[2];

   /*    String signm = "";
        System.out.println("请输入消息M:");
        InputStream clav= System.in;
        BufferedReader rd = new BufferedReader(new InputStreamReader(clav));
        try {signm = rd.readLine();}
        catch(IOException e) {System.out.println(e.getMessage());}
   */     //System.out.println(new BigInteger(signm.getBytes()).bitLength());
        //System.exit(0);

        p = rtn[0];
        g = rtn[1];

        y = getRandoma(p);
        b = calculateb(g, y, p);

        rtn = encrypt(m, p, b, g);
        System.out.println("密文:"+rtn[0]+","+rtn[1]);
        BigInteger dm = decrypt(rtn[0], rtn[1], y, p);
        System.out.println("解密:"+dm);




   /*     System.out.println("原文:"+signm);
        byte[] mb = signm.getBytes();
      System.out.println("字节码构造的超大整数:"+new BigInteger(mb).toString());
     */   System.out.println("素数P:"+p);
        System.out.println("生成元:"+g);
        System.out.println("随机数a(私钥):"+y);
        System.out.println("b(公钥):"+b);
        //rtn = ElGamal.getRandomP(100);//取得随机数P,和P的生成元g
        //p = rtn[0];
        //g = rtn[1];
        System.out.println("密文:"+rtn[0]+","+rtn[1]);
      //  System.out.println("解密后的超大整数:"+new BigInteger(mb));
    }

}
