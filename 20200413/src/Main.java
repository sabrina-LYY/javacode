import java.util.Scanner;

public class Main {
    //将字符串中的空格用%20代替
    public static String replaceSpace(String iniString, int length) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<length;i++){
            char c = iniString.charAt(i);
            if(c==' '){
                sb.append("%20");
            }else{
                sb.append(c);
            }
        }
        String str = new String(sb);
        return str;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String ret = replaceSpace(str,str.length());
        System.out.println(ret);
    }
}
