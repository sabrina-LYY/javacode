import java.util.Arrays;
public class ArrayList {
    private int[] elem;
    private int usedSize;//有效数据个数
    private final int capacity = 5;

    public ArrayList(){
        this.elem = new int[capacity];
        this.usedSize = 0;
    }
    // 打印顺序表
    public void display() {
        for(int i=0;i<this.usedSize;i++){
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }
    // 在 pos 位置新增元素
    public boolean isFull(){
        return this.usedSize == this.elem.length;
    }
    public void add(int pos, int data) {
        if(isFull()){
            //Arrays.copyOf参数为被复制的数组和复制的长度
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
        }
        if(pos<0 || pos>this.usedSize){
            System.out.println("该位置不合法");
            return;
        }
        for(int i=this.usedSize-1;i>=pos;i--){
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;

    }
    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for(int i=0;i<this.usedSize;i++){
            if(this.elem[i] == toFind){
                return true;
            }
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int search(int toFind) {
        for(int i=0;i<this.usedSize;i++){
            if(this.elem[i]==toFind){
                return i;
            }
        }
        return -1;
    }
    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if(pos<0 || pos>=this.usedSize){
            return -1;
        }
        return this.elem[pos];

    }
    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        if(pos<0 || pos>=this.usedSize){
            return;
        }
        this.elem[pos] = value;
    }
    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        int index = search(toRemove);
        if(index == -1){
            System.out.println("找不到");
            return;
        }
        for(int i = index;i<this.usedSize-1;i++){
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
    }
    // 获取顺序表长度
    public int size() {
        return this.usedSize;
    }
    // 清空顺序表
    public void clear() {
        this.usedSize =0;
    }
}
