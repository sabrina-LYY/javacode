import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n= in.nextInt();
            while(n>=2 && n<100){
                Stack<Integer> stack = new Stack<>();
                StringBuilder sb = new StringBuilder();
                int N = n*n;
                while(N>10){
                    stack.push(N%10);
                    N/=10;
                }
                while(!stack.isEmpty()){
                    sb.append(stack.peek());
                    stack.pop();
                }
                String s = new String(sb);
                if(Integer.parseInt(s) == n){
                    System.out.println("Yes!");
                    break;
                }else{
                    System.out.println("No!");
                    break;
                }
            }
        }
    }
}