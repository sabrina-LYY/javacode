import java.util.Scanner;
public class Main {

    /*
1、对输入的字符串进行加解密，并输出。
2加密方法为：
当内容是英文字母时则用该英文字母的后一个字母替换，
同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
其他字符不做变化。
3、解密方法为加密的逆过程。*/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String src = in.nextLine();
            String ensrc=in.nextLine();
            System.out.println(enCryption(src));
            System.out.println(deCryption(ensrc));
        }
    }


    public static String enCryption(String s){
        char[] cs = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < cs.length; i++){
            sb.append(encryption(cs[i]));
        }
        return sb.toString();
    }

    public static String deCryption(String ensrc){
        char[] cs = ensrc.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < cs.length; i++){
            sb.append(decryption(cs[i]));
        }
        return sb.toString();
    }
    public static char encryption(char c){

        if(c>='0' && c<'9'){
            return (char)(c+1);
        }else if(c=='9'){
            return c='0';
        }else if(c>='a' && c<'z'){
            return(char)(c-31);
        }else if(c == 'z'){
            return 'A';
        }else if(c>='A' && c<'Z'){
            return (char)(c+33);
        }else if(c=='Z'){
            return c='a';
        } else{
            return c;
        }
    }
    public static char decryption(char c){
        if(c>'0' && c<='9'){
            return (char)(c-1);
        }else if(c=='0'){
            return c='9';
        }else if(c>'A' && c<='Z'){
            return (char)(c+31);
        } else if(c=='A'){
            return c='z';
        }else if(c>'a' && c<='z'){
            return (char)(c-33);
        }else if(c=='a'){
            return c='Z';
        }else {
            return c;
        }
    }
}
