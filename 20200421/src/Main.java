import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            char[] ch = str.toCharArray();
            for(int i=0;i<ch.length;i++){
                if(!isAlpha(ch[i])){
                    ch[i]=' ';
                }
            }
            str = String.valueOf(ch).trim();//去掉两端的空格
            String[] s = str.split(" ");
            StringBuilder sb = new StringBuilder();

            for(int i=s.length-1;i>=0;i--){
                if(i!=0){
                    sb.append(s[i]+" ");
                }else{
                    sb.append(s[i]);
                }
            }
            System.out.println(sb.toString());
        }
    }

    public static Boolean isAlpha(char c){
        if((c>='a' && c<='z')||(c>='A' && c<='Z')){
            return true;
        }
        return false;
    }





    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String a = in.nextLine();
            String[] b = a.split("_");
            StringBuilder sb = new StringBuilder();
            sb.append(b[0]);
            for(int i=1;i<b.length;i++){
                sb.append((char)(b[i].charAt(0)-'a'+'A'));
                for(int j=1;j<b[i].length();j++){
                    sb.append(b[i].charAt(j));
                }
            }
            System.out.println(sb.toString());
        }
    }
}