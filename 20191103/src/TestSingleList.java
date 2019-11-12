class ListNode {
    public int data;
    public ListNode next;
    public ListNode (int data){
        this.data = data;
        this.next = null;
    }

}

public class TestSingleList {
    public ListNode head;
    public TestSingleList(){
        this.head = null;
    }
    //头插法
    public void addFirst(int data){
        ListNode cur = new ListNode(data);
        if(this.head == null){
            cur = this.head;
        }
        else{
            cur.next = this.head;
            head = cur;
        }
    }

    //尾插法
    public void addLast(int data){
        ListNode cur = new ListNode(data);
        if(this.head == null){
            cur = this.head;
        }
        else{
            cur = this.head.next;
            cur.next = null;
        }
    }
    //删除所有值为key的节点
    public void removeALLKey(int key) {
        ListNode prev = this.head;
        ListNode cur = this.head.next;
        while(cur!=null){
            if(cur.data == key){
                prev.next = cur.next;
                cur = cur.next;
            }
            else{
                prev = cur;
                cur = cur.next;
            }
        }
        if(this.head.data == key){
            this.head = this.head.next;
        }
    }
}
