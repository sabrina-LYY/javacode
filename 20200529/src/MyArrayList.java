public class MyArrayList<T> {
    public T[] elem;
    public int usedSize;

    public MyArrayList(){
        this.elem = (T[])new Object[10];
        this.usedSize = 0;
    }

    //插入，每次放到最后
    public void insert(T val){
        //把值放到usedSize位置
        this.elem[this.usedSize] = val;
        this.usedSize++;
    }
    //得到顺序表pos位置的值
    public T getPos(int pos){
        return this.elem[pos];
    }

}
