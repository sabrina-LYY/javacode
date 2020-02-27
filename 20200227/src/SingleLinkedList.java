/*class ListNode{
    public int data;
    public ListNode next;
    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}
// 1、无头单向非循环链表实现
public class SingleLinkedList {
    public ListNode head;
    public SingleLinkedList(){
        this.head = null;
    }
    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
        }else{
            node.next = this.head;
            this.head = node;
        }
    }
    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        ListNode cur = this.head;
        if(this.head == null){
            this.head = node;
        }else{
            while(cur.next!=null){
                cur = cur.next;
            }
            cur.next = node;
            node.next = null;
        }
    }
    //任意位置插入,第一个数据节点为0号下标
    public ListNode searchIndex(int index){
        ListNode prev = this.head;
        int count = 0;
        while(count<index-1){
            prev = prev.next;
            count++;
        }
        return prev;
    }

    public boolean addIndex(int index,int data){
        if(index<0 || index >=getLength()){
            return false;
        }
        if(index == 0){
            addFirst(data);
            return true;
        }
        ListNode prev = searchIndex(index);
        ListNode node = new ListNode(data);
        node.next  = prev.next ;
        prev.next = node;
        return true;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur = this.head;
        while(cur !=null){
            if(cur.data ==key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点

    public void remove(int key){
        //1.如果删除的是头节点
        if(this.head.data == key){
            this.head = this.head.next;
        }
        //2.找要删除的节点的前驱
        ListNode prev = SearchPrev(key);
        if(prev==null){
            System.out.println("没有要删除的节点");
        }
        ListNode del = prev.next;
        //进行删除
        prev.next = del.next;
    }

    public ListNode SearchPrev(int key){
        ListNode prev = this.head;
        while(prev.next !=null){
            if(prev.next.data==key){
                return prev;
            }
        }
        return null;
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
       ListNode prev = this.head;
       ListNode cur = this.head.next;
       while(cur != null){
           if(prev.next.data == key){
               prev.next = cur.next;
               cur = cur.next;
           }else{
               prev = cur;
               cur = cur.next;
           }
       }
       //最后处理头
        if(this.head.data == key){
           this.head = this.head.next;
        }
    }
    //得到单链表的长度
    public int getLength(){
        ListNode cur = this.head;
        int count = 0;
        while(cur !=null){
            count++;
            cur = cur.next;
        }
        return count;
    }
    //打印单链表数据
    public void display(){
        if(this.head==null){
            return;
        }
        ListNode cur = this.head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    //清空单链表
    public void clear(){
        ListNode cur = this.head.next;
        if(this.head.next !=null){
            this.head.next = cur.next;
        }
        this.head =null;
    }

}
*/