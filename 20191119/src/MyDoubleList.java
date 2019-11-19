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
}
