import java.math.BigInteger;

public class PvtCmpOTc1 {
    public static int PvtCmpOTc(BigInteger[]C,int t){
        Elgamal elgamal = new Elgamal();
        for(int i=1;i<=t;i++){
            BigInteger k = elgamal.decrypt(C[i])
        }
    }
}
