import java.util.Stack;

public class StackImpQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public StackImpQueue(){
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }
    public void push(int x){
        s1.push(x);
    }
    public int pop(){
        int e = 0;
        if(s2.empty()){
            while(!s1.empty()){
                s2.push(s1.pop());
            }
        }
        if(!s2.empty()){
            return s2.pop();
        }else{
            System.out.println("队列为空！");
            return -1;
        }

    }
    public int peek(){
        int e = 0;
        if(s2.empty()){
            while(!s1.empty()){
                s2.push(s1.pop());
            }
        }
        if(!s2.empty()){
            return s2.peek();
        }else{
            System.out.println("队列为空！");
            return -1;
        }
    }
    public boolean empty(){
        if(s1.empty() && s2.empty()){
            return true;
        }
        return false;
    }
}
