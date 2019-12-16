public class MyArrayList<T> {
    public T[] elem;
    public int usedSize;
    public MyArrayList(){
        this.elem = (T[]) new Object[10];
        this.usedSize = 0;
    }

    public void add(T data){
        this.elem[this.usedSize] = data;
        this.usedSize++;
    }
    public T get(){
        return this.elem[this.usedSize--];
    }
}
