class ListNode{
    public int data;
    public ListNode next;
    public ListNode (int data){
        this.data = data;
        this.next = null;
    }
}
public class TestDemo1 {

        public ListNode head;
        public ListNode MySingleList() {
            this.head = null;
        }

        //头插法
        public void addFirst(int data) {
            ListNode cur = new ListNode(data);
            if (this.head == null) {
                this.head = cur;
            } else {
                cur.next = this.head;
                this.head = cur;

            }
        }

 /* //尾插法
             public void addLast(int data);
     //任意位置插入,第一个数据节点为0号下标
             public boolean addIndex(int index,int data);
     //查找是否包含关键字key是否在单链表当中
             public boolean contains(int key);
     //删除第一次出现关键字为key的节点
             public void remove(int key);
     //删除所有值为key的节点
             public void removeAllKey(int key);
     //得到单链表的长度
             public int size();
     public void display();
     public void clear();*/
    }

