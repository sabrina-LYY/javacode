import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    //用队列实现栈，用两个队列
    public Queue<Integer> queue1 = new LinkedList<>();
    public Queue<Integer> queue2 = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyStack() {
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(!queue1.isEmpty()){
            queue1.offer(x);
        }else if(!queue2.isEmpty()){
            queue2.offer(x);
        }else{
            queue1.offer(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(!queue1.isEmpty()){
            int size1 = queue1.size()-1;//保持size大小不变
            for(int i=0;i<size1;i++){
                queue2.offer(queue1.poll());//offer 入队 poll 出队
            }
            return queue1.poll();
        }else if(!queue2.isEmpty()){
            int size2 = queue2.size()-1;//保持size大小不变
            for(int i=0;i<size2;i++){
                queue1.offer(queue2.poll());//offer 入队 poll 出队
            }
            return queue2.poll();
        }
        return -1;
    }

    /** Get the top element. */
    public int top() {
        //peek 为队首元素
        if(!queue1.isEmpty()){
            int tmp = 0;
            int size1 = queue1.size()-1;//保持size大小不变
            for(int i=0;i<size1;i++){
                tmp = queue1.poll();
                queue2.offer(tmp);//offer 入队 poll 出队
            }
            return tmp;
        }else if(!queue2.isEmpty()){
            int tmp2 = 0;
            int size2 = queue2.size()-1;//保持size大小不变
            for(int i=0;i<size2;i++){
                tmp2 = queue2.poll();
                queue1.offer(tmp2);//offer 入队 poll 出队
            }
            return tmp2;
        }
        return -1;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(queue1.isEmpty() && queue2.isEmpty()){
            return true;
        }
        return false;
    }
}
