public class MyStack {
    private int[]elem;
    private  int usedSize;
    public MyStack(){
        this.elem = new int[10];
        this.usedSize = 0;
    }

    public void push(int val){
        if(isFull()){
           return;
        }
        this.elem[this.usedSize] = val;
        this.usedSize++;
    }
    public int pop(){
        if(empty()){
            throw new RuntimeException("栈为空");
        }
        int ret = this.elem[this.usedSize-1];
        this.usedSize--;

        return ret;
    }

    public boolean empty(){
        if(this.usedSize==0){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if(this.usedSize==this.elem.length){
            return true;
        }
        return false;
    }
    public int peek(){
        if(empty()){
            return -1;
        }
        int ret = this.elem[this.usedSize-1];
        return ret;

    }

}
