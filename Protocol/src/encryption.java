import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class encryption {
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


    public encryption(int bitLengthVal, int certainty) {
        KeyGeneration(bitLengthVal, certainty);
    }

    /**
     * 构造一个具有512位模和至少1-2^（-64）个素数生成确定性的Paillier密码系统的实例。
     */
    public encryption() {
        KeyGeneration(512, 64);
    }

    /**
     * 产生公钥【N,g】       私钥lamada
     *
     * @param bitLengthVal number of bits of modulus.
     * @param certainty    certainty - 调用方允许的不确定性的度量。
     *                     新的 BigInteger 表示素数的概率超出 (1 - 1/2certainty)。
     *                     此构造方法的执行时间与此参数的值是成比例的。
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
     * @param m 作为一个大整数的明文
     * @param r 有助于加密的随机明文
     * @return 作为一个大整数的密文
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
     *
     * @param em1
     * @param em2
     * @return
     */
    public BigInteger cipher_add(BigInteger em1, BigInteger em2) {
        return em1.multiply(em2).mod(nsquare);
    }


    public static void main(String[] str) {

        Paillier paillier = new Paillier();
        // 实例化两个密文
        Scanner scanner = new Scanner(System.in);
        BigInteger m = scanner.nextBigInteger();
    }
}