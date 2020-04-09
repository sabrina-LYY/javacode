import java.math.*;
import java.util.*;

public class Paillier {
/*/**
 * 密钥生成：
 * 1、随机选择两个大质数p和q满足gcd（pq,(p-1)(q-1)）=1。 这个属性是保证两个质数长度相等。
 * 2、计算 n = pq和λ= lcm (p - 1,q-1)。
 * 3、选择随机整数g使得gcd(L(g^lambda % n^2) , n) = 1,满足g属于n^2;
 * 4、公钥为（N，g）
 * 5、私钥为lambda。
 * :加密
 * 选择随机数r满足
 * 计算密文
 * 其中m为加密信息
*/

     //随机选择两个大质数p和q满足gcd（pq,(p-1)(q-1)）=1。 这个属性是保证两个质数长度相等。
    //lamada=lcm(p-1,q-1)表示lamada是p-1,q-1的最小公倍数
      //lambda = lcm(p-1, q-1) =(p-1)*(q-1)/gcd(p-1, q-1).
    private BigInteger p, q, lambda;
    //n = p*q
    public BigInteger n;
    //nsquare = n*n
    public BigInteger nsquare;
    /**
     * 随机选取一个整数 g,g属于小于n的平方中的整数集,且 g 满足:g的lambda次方对n的平方求模后减一后再除与n，
     * 最后再将其与n求最大公约数，且最大公约数等于一。
     * a random integer in Z*_{n^2} where gcd (L(g^lambda mod nsquare), n) = 1.
     */
    private BigInteger g;
    //number of bits of modulus
    private int bitLength;


    public Paillier(int bitLengthVal, int certainty) {
        KeyGeneration(bitLengthVal, certainty);
    }

    /**
     构造一个具有512位模和至少1-2^（-64）个素数生成确定性的Paillier密码系统的实例。     */
    public Paillier() {
        KeyGeneration(512, 64);
    }

    /**
     * 产生公钥【N,g】       私钥lamada
     * @param bitLengthVal
     *            number of bits of modulus.
     * @param certainty
     *            certainty - 调用方允许的不确定性的度量。
     *            新的 BigInteger 表示素数的概率超出 (1 - 1/2certainty)。
     *            此构造方法的执行时间与此参数的值是成比例的。
     */

    public void KeyGeneration(int bitLengthVal, int certainty) {
        bitLength = bitLengthVal;

        //构造两个随机生成的正的大质数，长度可能为bitLength/2，它可能是一个具有指定 bitLength 的素数
        p = new BigInteger(bitLength / 2, certainty, new Random());
        q = new BigInteger(bitLength / 2, certainty, new Random());
        n = p.multiply(q);
        nsquare = n.multiply(n);

        g = new BigInteger("2");
        lambda = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE))
                .divide(p.subtract(BigInteger.ONE).gcd(q.subtract(BigInteger.ONE)));
        //检验g是否符合公式的要求， gcd (L(g^lambda mod nsquare), n) = 1
        if (g.modPow(lambda, nsquare).subtract(BigInteger.ONE).divide(n).gcd(n).intValue() != 1) {
            System.out.println("g is not good. Choose g again.");
            System.exit(1);
        }
    }

    /**
     * 加密明文 m.  密文c = g^m * r^n mod n^2. 这个函数明确的需要随机输入r来帮助加密
     *
     * @param m   作为一个大整数的明文
     * @param r  有助于加密的随机明文
     * @return   作为一个大整数的密文
     */
    public BigInteger Encryption(BigInteger m, BigInteger r) {
        return g.modPow(m, nsquare).multiply(r.modPow(n, nsquare)).mod(nsquare);
    }

    //构造一个随机生成的 大整数 r，它是在 0 到 (2numBits - 1)（包括）范围内均匀分布的值。
    public BigInteger Encryption(BigInteger m) {
        BigInteger r = new BigInteger(bitLength, new Random());
        return g.modPow(m, nsquare).multiply(r.modPow(n, nsquare)).mod(nsquare);

    }

    /**
     * 利用私钥lamada对密文c进行解密返回明文 m = L(c^lambda mod n^2) * u mod n, where
     * u = (L(g^lambda mod n^2))^(-1) mod n.
     */
    public BigInteger Decryption(BigInteger c) {
        BigInteger u = g.modPow(lambda, nsquare).subtract(BigInteger.ONE).divide(n).modInverse(n);
        return c.modPow(lambda, nsquare).subtract(BigInteger.ONE).divide(n).multiply(u).mod(n);
    }

    /**
     * 两个密文的和
     * @param em1
     * @param em2
     * @return
     */
    public BigInteger cipher_add(BigInteger em1, BigInteger em2) {
        return em1.multiply(em2).mod(nsquare);
    }

/*
    public static void main(String[] str) {

        Paillier paillier = new Paillier();
        // 实例化两个密文
        BigInteger m1 = new BigInteger("20");
        BigInteger m2 = new BigInteger("60");
        //加密
        BigInteger em1 = paillier.Encryption(m1);
        BigInteger em2 = paillier.Encryption(m2);
        //输出加密后的结果
        System.out.println("m1加密后："+em1);
        System.out.println("m2加密后"+em2);
        //输出解密后的结果
        System.out.println("m1加密之后进行解密的结果= "+paillier.Decryption(em1).toString());
        System.out.println("m2加密之后进行解密的结果= "+paillier.Decryption(em2).toString());

       //测试同态性 D(E(m1)*E(m2) mod n^2) = (m1 + m2) mod n
        // m1+m2,求明文数值的和
        BigInteger sum_m1m2 = m1.add(m2).mod(paillier.n);
        System.out.println("明文的和: " + sum_m1m2.toString());
        // em1+em2，求密文数值的乘
        BigInteger product_em1em2 = em1.multiply(em2).mod(paillier.nsquare);
        System.out.println("密文的和: " + product_em1em2.toString());
        System.out.println("解密后的和: " + paillier.Decryption(product_em1em2).toString());
*/
  /*      // 测试同态性 ->   D(E(m1)^m2 mod n^2) = (m1*m2) mod n
        // m1*m2,求明文数值的乘
        BigInteger prod_m1m2 = m1.multiply(m2).mod(paillier.n);
        System.out.println("明文的乘积: " + prod_m1m2.toString());
        // em1的m2次方，再mod paillier.nsquare
        BigInteger expo_em1m2 = em1.modPow(m2, paillier.nsquare);
        System.out.println("密文的结果: " + expo_em1m2.toString());
        System.out.println("解密后的结果: " + paillier.Decryption(expo_em1m2).toString());

    }*/
}

