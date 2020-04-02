import java.util.*;
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            if(Len(str) && Repeat(str) && Kinds(str)){
                System.out.println("OK");
            }else{
                System.out.println("NG");
            }

            System.out.println(Len(str));
            System.out.println(Kinds(str));
            System.out.println(Repeat(str));

        }
    }
    public static boolean Len(String str){
        if(str.length()>8){
            return true;
        }
        return false;
    }
    public static boolean Repeat(String str){
        for(int i=0;i<str.length()-2;i++){
            if(str.substring(i+1).contains(str.substring(i,i+3))){
                return false;
            }
        }
        return true;
    }
    public static boolean Kinds(String str){
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        char[] arr = str.toCharArray();
        for(char s:arr){
            if(s>='a' && s<='z'){
                a = 1;
            }else if(s>='A' && s<='Z'){
                b = 1;
            }else if(s>='0' && s<='9'){
                c = 1;
            }else{
                d = 1;
            }
            if((a+b+c+d)>=3){
                return true;
            }
        }
        return false;
    }

}