package ECC_p;

import java.math.BigInteger;

public class Test {
    public static void main(String[] args) {
        BigInteger M = new BigInteger("1234567890abcdef", 16);
        System.out.println("明文：M=" + M.toString(16));
        ECC_p ecc;
        BigInteger k = new BigInteger("abcdef", 16);
        BigInteger[] C;
        ECPoint X1;

        System.out.println("256k1：");
        ecc = new ECC_p(2561);
        C = ecc.encrypt(M, k);
        X1 = new ECPoint(C[0], C[1]);
        System.out.println("密文：(" + X1 + ", " + C[2].toString(16) +")");
        M = ecc.decrypt(C);
        System.out.println("明文：M=" + M.toString(16));//M的16进制字符串形式
    }
}