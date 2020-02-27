import java.util.Scanner;

public class TestDemo {

        public static void main(String[] args){
            Scanner scanner=new Scanner(System.in);
            int n=scanner.nextInt();
            boolean flag=false;
            int k=0;
            long res=0;
            while (flag == false){
                long t0=n-Fibonaaci(k);
                long t1=n-Fibonaaci(k+1);
                long t=t0*t1;
                if (t==0){
                   flag=true;
                   res=0;
                }else  if (t<0){
                   flag=true;
                   res=Math.min(Math.abs(t0),Math.abs(t1));
                }else {
                    k++;
                }
    }
            System.out.println("res-->"+res);
}
        public static int Fibonaaci(int i){
            if(i==0 ||i==1){
                return i;
            }
            while(i>=2){
                return Fibonaaci(i-1)+Fibonaaci(i-2);
            }
            return -1;
        }
}
