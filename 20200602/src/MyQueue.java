class Node{
    public int data;
    public Node next;
    public Node(){};
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}


public class MyQueue {
    //链式队列，底层是单链表
    public Node front;
    public Node rear;

    public void offer(int data) {
        //是否第一次插入
        Node node = new Node(data);
        if(this.front==null){
            this.front = node;
            this.rear = node;
            return;
        }
        this.rear.next = node;
        this.rear = node;
    }

    public int poll(){
        if(empty()){
            return -1;
        }
        int data = this.front.data;
        this.front = this.front.next;
        return data;
    }
    public int peek(){
        if(empty()){
            return -1;
        }
        return this.front.data;
    }
    public boolean empty(){
        return false;
    }

}
