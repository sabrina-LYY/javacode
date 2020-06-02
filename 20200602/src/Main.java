import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(5);
        queue.offer(6);
        queue.offer(9);
        System.out.println(queue.poll());//得到队头元素，并删除
        System.out.println(queue.peek());//得到队头元素
    }


    public static void main1(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(5);
        myStack.push(8);
        myStack.push(9);
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
    }

}
