import java.util.*;
public class TestDemo {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            while (in.hasNextInt()) {
                int[] num = new int[10];
                for(int i=0;i<num.length;i++){
                    num[i] = in.nextInt();
                }
                StringBuffer sb = new StringBuffer();

                for(int i=1;i<num.length;i++){
                    if(num[i]>0){
                        sb.append(i);
                        num[i]--;
                        break;
                    }

                }
                for(int i=0;i<num.length;i++){
                    while(num[i]>0){
                        sb.append(i);
                        num[i]--;
                    }
                }
                System.out.println(sb.toString());
            }
        }

}
