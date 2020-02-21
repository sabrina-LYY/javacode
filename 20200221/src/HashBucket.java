public class HashBucket {
    static class Node{
        private Node next;
        private int key;
        private int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private Node[] array = new Node[8];//存放单链表的头结点
    private int size;//当前数据的个数

    public int getValue(int key){
        int index = key % array.length;
        //遍历array[index]下标的链表，找到值为key的数据，并返回
        Node cur = array[index];
        while(cur!=null){
            if(cur.key==key){
                return cur.value;
            }
            cur = cur.next;
        }
        return -1;
    }

    public void put(int key,int value){
        int index = key % array.length;
        Node cur = array[index];
        while(cur!=null){
            if(cur.key==key){//key相同，value不同就要用后一个value
                cur.value = value;
                return;
            }
            cur = cur.next;
        }

        //头插法
        Node node = new Node(key,value);
        node.next = array[index];
        array[index] = node;
        this.size++;

        if(loadFactor()>=0.75){
            resize();
        }

    }
    private double loadFactor() {
        return this.size*1.0 / array.length;
    }

    public void resize() {
        Node[] newArray = new Node[2*array.length];

        //重新哈希
        //1.遍历原来的数组，将里面的元素重新哈希到新的数组里面
        for(int i=0;i<array.length;i++){
            Node curNext = null;
            for(Node cur = array[i];cur!=null;cur = curNext){
                curNext = cur.next;
                int index = cur.key % newArray.length;
                //头插法插入新链表
                cur.next = newArray[index];
                newArray[index] = cur;
            }
        }
        array = newArray;

    }


}
