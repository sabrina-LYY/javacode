package ECC_p;

import java.math.BigInteger;
import java.util.Random;

public class ECC_p {
    public static BigInteger p, a, b, x, y, n, h;
    static EC_p ec;
    public static ECPoint G, Q;
    private static BigInteger d;

    public ECC_p() {
        int k = new Random().nextInt(2);
        init(2561);
    }

    public ECC_p(int k) {
        init(k);
    }

    static void init(int k) {
        p = new BigInteger("2").pow(256).subtract(new BigInteger("2").pow(32)).subtract(new BigInteger("2").pow(9)).subtract(new BigInteger("2").pow(8)).subtract(new BigInteger("2").pow(7)).subtract(new BigInteger("2").pow(6)).subtract(new BigInteger("2").pow(4)).subtract(new BigInteger("1"));
        a = new BigInteger("0");
        //将radix进制的字符串转化为BigInteger
        b = new BigInteger("7", 16);
        x = new BigInteger("6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296", 16);
        y = new BigInteger("4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5", 16);
        n = new BigInteger("fffffffffffffffffffffffffffffffebaaedce6af48a03bbfd25e8cd0364141", 16);
        h = new BigInteger("1");


        ec = new EC_p(p, a, b);
        G = new ECPoint(x, y);
        //随机生成 0到2的n.bitLength()次方 -1的随机数
        d = new BigInteger(n.bitLength(), new Random());//私钥
        Q = ec.multiply(G, d);//公钥
    }

    /**
     * 加密
     * @param M
     * @return
     */
    BigInteger[] encrypt(BigInteger M) {
        BigInteger k;
        ECPoint X1, X2;
        do {
            k = new BigInteger(n.bitLength(), new Random());
        } while ((X2 = ec.multiply(Q, k)).x == null);
        X1 = ec.multiply(G, k);
        BigInteger[] C = new BigInteger[3];
        C[0] = X1.x;
        C[1] = X1.y;
        C[2] = M.multiply(X2.x).mod(n);
        return C;
    }

    /**
     * 加密
     * @param M
     * @param k
     * @return
     */
    BigInteger[] encrypt(BigInteger M, BigInteger k) {
        ECPoint X1 = ec.multiply(G, k);
        ECPoint X2 = ec.multiply(Q, k);
        BigInteger[] C = new BigInteger[3];
        C[0] = X1.x;
        C[1] = X1.y;
        C[2] = M.multiply(X2.x).mod(n);
        return C;
    }

    /**
     * 解密
     * @param C
     * @return
     */
    BigInteger decrypt(BigInteger[] C) {
        ECPoint X1 = new ECPoint(C[0], C[1]);
        ECPoint X2 = ec.multiply(X1, d);
        BigInteger M = C[2].multiply(X2.x.modPow(new BigInteger("-1"), n)).mod(n);
        return M;
    }
}