import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class Main {
  /*  public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();

            List<Integer> list = new ArrayList<>();
            for(int i=1;i<=n;i++){
                if(i<m){
                    list.add(i);
                }
                int j=m-i;
                if(i==j){
                    list.add(i);
                }

            }
            in.nextLine();

        }
    }

*/

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            ArrayList<String> list = new ArrayList<>();
            int n = in.nextInt();
            String[] a = new String[n];
            for(int i=0;i<a.length;i++){
                a[i] = in.nextLine();
                String ret = func(a[i]);
                ret = ret.substring(0,3)+"-"+
                        ret.substring(3,7);
                if(!list.contains(ret)){
                    list.add(ret);
                }
            }
            Collections.sort(list);
            for(int i=0;i<list.size();i++){
                System.out.println(list.get(i));
            }

        }
    }

    public static String func(String str){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c>='0' && c<='9'){
                sb.append(c);
            }
            if(c>='A' && c<='C'){
                sb.append('2');
            }
            if(c>='D' && c<='F'){
                sb.append('3');
            }
            if(c>='G' && c<='I'){
                sb.append('4');
            }
            if(c>='J' && c<='L'){
                sb.append('5');
            }
            if(c>='M' && c<='O'){
                sb.append('6');
            }
            if(c>='P' && c<='S'){
                sb.append('7');
            }
            if(c>='T' && c<='V'){
                sb.append('8');
            }
            if(c>='W' && c<='Z'){
                sb.append('9');
            }

        }
        return sb.toString();
    }
}
