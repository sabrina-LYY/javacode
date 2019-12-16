import java.util.Stack;

public class TestDemo {

    //给定一个只包含‘（’、‘）’、'['、‘]’、‘{‘、’}‘的字符串，判断是否有效，即是否能匹配
    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<Character>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='(' || ch=='[' || ch=='{'){
                stack.push(ch);
            }else{
                if(stack.empty()){
                    System.out.println("右括号多");
                    return false;
                }
                char top = stack.peek();
                if(top == '(' && ch==')' ||
                        top == '[' && ch==']'||
                        top =='{' && ch=='}'){
                    stack.pop();
                }else{
                    System.out.println("右括号匹配错误");
                    return false;
                }
            }
        }
        if(!stack.empty()){
            System.out.println("左括号多");
            return false;
        }
        return true;

    }

    public static void main(String[] args) {
        MyListQueue myListQueue = new MyListQueue();
        myListQueue.offer(1);
        myListQueue.offer(2);
        myListQueue.offer(3);
        myListQueue.offer(4);
        System.out.println(myListQueue.peek());

    }
}
