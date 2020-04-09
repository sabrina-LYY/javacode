package ELGamal;

import java.math.BigInteger;
import java.util.Random;
/*
实现ELGamal算法，需要实现以下几个部分：
　　1.对大数的素数判定；
　　2.判断原根；
　　3.模指运算；
　　4.模逆运算。
公钥:y
私钥：d
明文：M
秘钥：k
密文：c
*/
public class ELGamal {
    public BigInteger p, alpha, y;
    private BigInteger d;

    public ELGamal() {
        do {
            //随机地选择一个大素数p，且要求p-1有大素数因子，将p公开。
            p = BigInteger.probablePrime(100, new Random());
            //(p-1)/2      isProbablePrime(certainty)返回true表示是数字是否为素数，概率为1 -> 1 / 2^certainty
            //  参数 certainty 是对调用者愿意忍受的不确定性的度量
        } while (p.subtract(BigInteger.ONE).divide(new BigInteger("2")).isProbablePrime(100));
        do {
            //选择一个模p的原根α
            alpha = new BigInteger(100, new Random());
        } while (! isOrigin(alpha, p));
        do {
            //随机数，100表示位数
            d = new BigInteger(100, new Random());
            //随机地选择一个整数d（1＜d＜p-1）作为私钥，并对d保密
        } while (d.compareTo(BigInteger.ONE) != 1 || d.compareTo(p.subtract(BigInteger.ONE)) != -1);
        //计算公钥y=alpha^d(mod p)，并将y公开
        y = alpha.modPow(d, p);
    }

    public ELGamal(BigInteger p, BigInteger alpha, BigInteger d) {
        this.p = p;
        this.alpha = alpha;
        this.d = d;
        y = alpha.modPow(d, p);
    }

    /**
     * 加密
     * @param M
     * @return
     */
    BigInteger[] encrypt(BigInteger M) {
        BigInteger[] C = new BigInteger[2];
        BigInteger k, U;
        do {
            do {
                //随机地选取一个整数k（1＜k＜p-1）
                k = new BigInteger(100, new Random());
            } while (k.compareTo(BigInteger.ONE) != 1 || k.compareTo(p.subtract(BigInteger.ONE)) != -1);

            //计算U=y^k(mod p)、C0=α^k(mod p)、C1=UM(mod p)。取(C1,C2)作为密文

            U = y.modPow(k, p);//y的k次方mod p
        } while (U.intValue() != 1);
        C[0] = alpha.modPow(k, p);
        C[1] = U.multiply(M).mod(p);
        return C;
    }

    /**
     * 解密
     * @param C
     * @return
     */
    BigInteger decrypt(BigInteger[] C) {
        //计算V=C[0]d(mod p)。
        BigInteger V = C[0].modPow(d, p);
        //计算M=C[1]*V^-1 (mod p)
        BigInteger M = C[1].multiply(V.modPow(new BigInteger("-1"), p)).mod(p);
        return M;
    }

    /**
     * 判断a是否为模m的原根，其中m为素数
     * @param a
     * @param m
     * @return
     */
    static boolean isOrigin(BigInteger a, BigInteger m) {
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

    public BigInteger getD() {
        return d;
    }
}
