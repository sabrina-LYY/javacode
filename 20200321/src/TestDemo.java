import java.util.*;
public class TestDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            int n = in.nextInt();
            int max =0;
            int begin = 0;
            for(int i=0;i <= str.length()-n;i++){
                int count = 0;
                for(int j = i;j< i+n;j++){
                    if(str.charAt(j)=='G'||str.charAt(j)=='C'){
                        count++;
                    }
                }
                if(count>max){
                    begin = i;
                    max = count;
                }
            }
            System.out.println(str.substring(begin,begin+n));
        }
    }
}