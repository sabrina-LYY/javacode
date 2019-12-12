public class MyListQueue{
    static class Node{
        public int data;
        public Node next;
        public Node(int data){
            this.data = data;
        }
    }
    public Node front;
    public Node rear;
    public int usedSize;
    public boolean isEmpty(){
        return this.usedSize == 0;
    }
    public void offer( int data) {//入队
        Node node = new Node(data);
        if(isEmpty()){
            this.front = node;
            this.rear = front;
        }else{
            this.rear.next = node;
            this.rear = node;
        }
        usedSize++;
    }

    public int poll(){//从头出队
        if(isEmpty()){
            throw new UnsupportedOperationException("队列为空");//为了防止都返回-1而无法区分
        }
        int val = this.front.data;
        this.front = this.front.next;
        this.usedSize--;
        return val;
    }
    public int peek(){//获取队头元素
        if(isEmpty()){
            throw new UnsupportedOperationException("队列为空");//为了防止都返回-1而无法区分
        }
        return this.front.data;
    }
}
