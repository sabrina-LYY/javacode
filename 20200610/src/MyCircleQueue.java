//循环队列
public class MyCircleQueue {
    private int rear;//队尾也代表当前可以存放数据元素的下标
    private int front;
    private int[] elem;
    public MyCircleQueue(int k){
        this.elem=new int[k+1];
    }
    //入队
    public boolean enQueue(int value){
        if(isFull()){
            return false;
        }
        this.elem[this.rear] = value;
        this.rear = (this.rear+1)%this.elem.length;
        return true;
    }
    //出队
    public boolean deQueue(){
        if(isEmpty()){
            return false;
        }
        this.front = (this.front+1)%this.elem.length;
        return true;

    }
    //拿到队头元素
    public  int Front(){
        if(isEmpty()){
            return -1;
        }
        return this.elem[front];
    }
    //拿到队尾元素
    public  int Rear(){
        if(isEmpty()){
            return -1;
        }
        return (this.rear==0)?this.elem.length-1:this.rear-1;

    }
    public boolean isEmpty(){
        if(this.front==this.rear){
            return true;
        }
        return false;

    }
    public boolean isFull(){
        if((this.rear+1)%this.elem.length ==this.front){
            return true;
        }
        return false;
    }
}
