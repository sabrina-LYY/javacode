import java.util.Arrays;

public class TestHeap {
    public int[] elem;
    public int usedSize;

    public TestHeap(){
        this.elem = new int[10];
        this.usedSize = 0;
    }

    //向下调整  为大根堆
    public void AdjustDown(int root,int len){
        int parent = root;
        int child = 2*parent+1;
        //判断是否有孩子(父亲节点为n，左孩子：2n+1,右孩子：2n+2)
        while(child  < len){
            if(child +1 <len && this.elem[child] < this.elem[child+1]){
                child = child+1;
            }
            //child是左右孩子的最大值下标
            if(this.elem[child]>this.elem[parent]){
                int tmp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;
                parent = child;
                child = 2*parent+1;
            }else{
                break;
            }
        }
    }
    //创建堆，即优先级堆队列
    public void createHeap(int [] array){
        for(int i=0;i<array.length;i++){
            this.elem[i] = array[i];
            this.usedSize++;
        }
        //i表示每棵树的根节点
        for(int i=(this.usedSize-1-1)/2;i>=0;i--){
            //按向下调整
            AdjustDown(i,this.usedSize);
        }
    }

    public void show(){
        for(int i = 0;i<this.usedSize;i++){
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }

    //向上调整
    public void AdjustUp(int child){
        int parent = (child-1)/2;
        while(child>0){
            if(this.elem[child]>this.elem[parent]){
                int tmp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;
                child = parent;
                parent = (child-1)/2;
            }else{
                break;
            }
        }
    }

    public boolean isFull(){
        return this.usedSize == this.elem.length;
    }

    //入队（向上调整）
    public void pushHeap(int val){
        if(isFull()){
            //二倍扩容
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
        }
        //先放到最后位置
        this.elem[this.usedSize] = val;
        this.usedSize++;
        //再向上调整
        AdjustUp(this.usedSize-1);
    }

    public boolean isEmpty(){
        return this.usedSize == 0;
    }
    //出队(向下调整)
    public void popHeap(){
        if(isEmpty()){
            return;
        }
        int tmp = this.elem[0];
        this.elem[0] = this.elem[this.usedSize-1];
        this.elem[this.usedSize-1] = tmp;
        this.usedSize--;
        AdjustDown(0,this.usedSize);
    }

    //得到堆顶元素
    public int getHeapTop(){
        if(isEmpty()){
            return -1;
        }
        return this.elem[0];
    }

    //堆排序
    public void heapSort(){
        int end = this.usedSize-1;
        while(end>0){
            int tmp = this.elem[end];
            this.elem[end] = this.elem[0];
            this.elem[0] = tmp;
            AdjustDown(0,end);
            end--;
        }
    }
}
