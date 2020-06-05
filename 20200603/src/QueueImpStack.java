import java.util.LinkedList;
import java.util.Queue;

public class QueueImpStack {
    private Queue<Integer> qu1;
    private Queue<Integer> qu2;
    private int usedSize;
    public QueueImpStack(){
        qu1 = new LinkedList<>();
        qu2 = new LinkedList<>();
        this.usedSize = 0;
    }

    public void push(int x){
        if(!qu1.isEmpty()){
            qu1.offer(x);
        }else if(!qu2.isEmpty()){
            qu2.offer(x);
        }else{
            qu1.offer(x);
        }
        this.usedSize++;
    }
    public int top(){
        int e=0;
        if(!qu1.isEmpty()){
            for(int i=0;i<this.usedSize-1;i++){
                e = qu1.poll();
                qu2.offer(e);
            }
            return e;

        }else if(!qu1.isEmpty()){
            for(int i=0;i<this.usedSize-1;i++){
                e=qu2.poll();
                qu1.offer(e);
            }
            return e;

        }
        return -1;
    }

    public int pop(){
        int e=0;
        if(empty()){
            throw new RuntimeException("栈为空");
        }
        if(!qu1.isEmpty()){
            for(int i=0;i<this.usedSize;i++){
                qu2.offer(qu1.poll());
            }
            e=qu1.poll();

        }else if(!qu1.isEmpty()){
            for(int i=0;i<this.usedSize;i++){
                qu1.offer(qu2.poll());
            }
            e=qu2.poll();

        }
        this.usedSize--;
        return e;

    }
    public boolean empty(){
        return this.usedSize==0;
    }
}
