class ListNode{
    public int data;
    public ListNode next;
    public ListNode prev;
    public ListNode (int data){
        this.data = data;
    }

        }
public class MyDoubleList {
    public ListNode head;
    public ListNode last;
    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(this.head==null){
            this.head = node;
            this.last = node;
        }else{
            node.next = this.head;
            this.head.prev = node;
            this.head = node;

        }
    }
    //尾插法
    public void addLast(int data){
        ListNode node  = new ListNode(data);
        if(this.head == null){
            this.head = node;
            this.last = node;
        }else{
            this.last.next = node;
            node.prev = this.last;
            this.last = node;

        }
    }

    //任意位置插入，第一个结点下标是0
    public int size(){
        ListNode cur = this.head;
        int count = 0;
        while(cur!=null){
            count ++;
            cur = cur.next;
        }
        return count;
    }

    //找到Index位置的节点
    public ListNode searchIndex(int index){
        if(index<0 || index>size()){
            return null;
        }
        ListNode cur = this.head;
        while(index>0){
            cur = cur.next;
            index--;
        }
        return cur;
    }
    public void addIndex(int index,int data) {
        //头插
        if(index == 0){
            addFirst(data);
            return;
        }
        //尾插
        if(index == size()){
            addLast(data);
            return;
        }
        //中间插入
        ListNode node = new ListNode(data);
        ListNode cur = searchIndex(index);
        node.next = cur;
        node.prev = cur.prev;
        cur.prev = node;
        cur.prev.next = node;
    }

    //查找链表中是否包含关键字key
    public boolean contains(int key){
        ListNode  cur = this.head;
        while(cur !=null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除第一次出现key的节点
    public void remove(int key){

        ListNode cur = this.head;
        while(cur != null){
            if(cur.data == key) {
                //三种情况
                //头
                if (cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else {//中间和尾巴
                    cur.prev.next = cur.next;
                    if(cur.next != null){
                    cur.next.prev = cur.prev;
                    }else{
                        this.last = cur.prev;
                    }
                }
                return;
            }
            cur = cur.next;
        }
    }

    //删除所有值为key的节点
    public void removeAllKey(int key){

        ListNode cur = this.head;
        while(cur != null){
            if(cur.data == key) {
                //三种情况
                //头
                if (cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else {//中间和尾巴
                    cur.prev.next = cur.next;
                    if(cur.next != null){
                        cur.next.prev = cur.prev;
                    }else{
                        this.last = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }

    public void display(){
        ListNode cur = this.head;
        while(cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void clear(){
        while(this.head != null){
            ListNode cur = this.head.next;
            this.head.next = null;
            this.head.prev = null;
            this.head = cur;
        }
        this.last = null;
    }
}
