import java.math.BigInteger;

public class PvtCmpc1 {
    public int PvtCmpc(BigInteger[]C,int t){
        Paillier paillier = new Paillier();

        int b2;
        for(int i=1;i<=t;i++){
            if (((paillier.Decryption(C[i])).compareTo(BigInteger.valueOf(0)))==0) {
                return b2=0;
            }
        }
        return b2=1;
    }
}
