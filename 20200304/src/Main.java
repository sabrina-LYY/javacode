import java.util.Scanner;
import java.util.Stack;

public class Main{

    //输出一行字符串中连续最长的数字串
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str = scan.nextLine();
            int count = 0;
            int end = 0;
            int max = 0;
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)>='0' && str.charAt(i)<='9'){
                    count++;
                    if(max<count){
                        max = count;
                        end = i;
                    }
                }else{
                    count = 0;
                }
            }
            System.out.println(str.substring(end-max+1,end+1));
        }
    }


    //括号是否合法
    public boolean chkParenthesis(String A, int n) {
        Stack<Character> stack = new Stack<>();
        int stackLen =0;
        for(int i=0;i<A.length();i++){
            char c = A.charAt(i);
            if(c=='(' ){
                stack.push(c);
                stackLen++;
            }else if(c==')' && !stack.isEmpty() ){
                stack.pop();
                stackLen--;
            }else{
                return  false;
            }
        }
        return true;
    }
}
