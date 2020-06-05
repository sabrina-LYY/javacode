import java.util.Stack;

public class TestDemo {

    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            //如果左括号，入栈
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
                stack.push(s.charAt(i));
            }else{
                //右括号
                if(stack.empty()){
                    System.out.println("右括号多！");
                    return false;
                }else{
                    if(s.charAt(i)=='('&&stack.peek()==')' ||s.charAt(i)=='{'&&stack.peek()=='}' ||
                            s.charAt(i)=='['&&stack.peek()==']'){
                        stack.pop();
                    }else{
                        System.out.println("括号匹配失败");
                        return false;
                    }
                }
            }
        }
        if(!stack.empty()){
            System.out.println("左括号多！");
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "(({)))";
        System.out.println(isValid(s));
    }
}

