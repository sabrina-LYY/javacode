import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack(){
        this.stack =new Stack<>();
        this.minStack = new Stack<>();
    }
    public void push(int x){
        stack.push(x);
        //第一次放
        if(minStack.empty()){
            minStack.push(x);
        }else{
            if(minStack.peek()>=x){
                minStack.push(x);
            }
        }
    }

    public void pop(){
        if(!stack.empty()){
            int tmp = stack.pop();
            if(tmp==minStack.peek()){
                minStack.pop();
            }
        }
    }

    public int top(){
        if(stack.empty()){
            return -1;
        }
        return stack.peek();
    }
    public int getMin(){
        return minStack.peek();
    }
}
