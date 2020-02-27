// 2、无头双向链表实现
class ListNode{
    public int data;
    public ListNode next;
    public ListNode prev;

    public ListNode(int data){
        this.data = data;
        this.next = null;
    }
}
public class DoubleLinkedList {

    public ListNode head;
    public ListNode tail;

    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
            this.tail = node;
        }else{
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }
    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
            this.tail = node;
        }else{
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        if(index == 0){
            addFirst(data);
            return;
        }
        if(index == size()){
            addLast(data);
            return;
        }
        ListNode node = new ListNode(data);
        ListNode cur = SearchIndex(index);
        node.prev = cur;
        cur.next = node;
        cur.prev.next = node;
        cur.prev = node;

    }

    public ListNode SearchIndex(int index){
        if(index<0 || index>size()){
            return null;
        }
        ListNode cur = this.head;
        for(int i=0;i<index;i++){
            cur = cur.next;
        }
        return cur;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur = this.head;
        while(cur!=null){
            if(cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        ListNode cur = this.head;
        while(cur != null){
            if(cur.data == key){
                //分三种情况
                if(cur == this.head){
                    this.head = this.head.next;
                    this.head.prev = null;
                }else{
                    //中间和最后位置
                    cur.prev.next = cur.next;
                    if(cur.next!=null){
                        cur.next.prev = cur.prev;
                    }else{
                        this.tail = cur.prev;
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
            if(cur.data == key){
                //分三种情况
                if(cur == this.head){
                    this.head = this.head.next;
                    this.head.prev = null;
                }else{
                    //中间和最后位置
                    cur.prev.next = cur.next;
                    if(cur.next!=null){
                        cur.next.prev = cur.prev;
                    }else{
                        this.tail = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }
    //得到单链表的长度
    public int size(){
        ListNode cur = this.head;
        int count = 0;
        while(cur !=null){
            count++;
            cur = cur.next;
        }
        return count;
    }
    //显示链表中的值
    public void display(){
        ListNode cur = this.head;
        while(cur.next!=null){
            System.out.println(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    //清空链表
    public void clear(){
        while(this.head != null){
            ListNode cur = this.head.next;
            this.head.next = null;
            this.head.prev = null;
            this.head = cur;
        }
        this.tail = null;
    }
}
