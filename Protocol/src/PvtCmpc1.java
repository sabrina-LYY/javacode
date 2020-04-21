import java.math.BigInteger;

public class PvtCmpc1 {
    public static int PvtCmpc(BigInteger[]C,int t){
        Elgamal elgamal = new Elgamal();
        int b2;
        for(int i=1;i<=t;i++){
            if ((elgamal.decrypt(C[i]).compareTo(BigInteger.ZERO))!=0){
                return b2=1;
            }
        }
        return b2=1;
    }
}
