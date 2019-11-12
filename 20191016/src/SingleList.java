class ListNode {
    public int data;
    public ListNode next;
    public ListNode(int data){
        this.data = data;
        this.next = null;
        }
}

public class SingleList {
    public ListNode head;
    public  SingleList(){
        this.head = null;
    }

    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        //第一次插入
        if(this.head==null){//要习惯加this
            this.head = node; //node代表当前节点的地址
        }
        //第二次插入
        else{
            node.next = this.head;
            this.head = node;
        }
    }
        // 反转一个单链表。
    //逆置          //方法二 利用头插法逆置
    public ListNode reverseList() {
        ListNode prev = null;
        ListNode newHead = null;
        ListNode cur = this.head;
        while (cur != null) {
            ListNode curNext = cur.next;
            if(curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }

    //3. 给定一个带有头结点 head 的非空单链表，
    // 返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点
    public ListNode middleNode() {
        /*int len = getLength()/2;
        ListNode cur = this.head;
        for (int i = 0; i < len; i++) {
            cur = cur.next;
        }
        return cur;*/
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    //

    public int getLength(){
        int count = 0;
        ListNode cur = this.head;
        while(cur.next!=null){
            count++;
            cur = cur.next;
        }
        return count;
    }
    //4. 输入一个链表，输出该链表中倒数第k个结点。
    public ListNode findKthToTail1(int k) {
        if(k <= 0 ||k > getLength()) {
            return null;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (k-1 > 0) {
            fast = fast.next;
            k--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    //
    public ListNode findKthToTail(int k) {
        if(k <= 0) {
            return null;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (k-1 > 0) {
            if(fast.next != null) {
                fast = fast.next;
                k--;
            }else {
                System.out.println("没有这个节点");
                return null;
            }

        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


    public void display(ListNode newHead){
        if(newHead == null) {
            return;
        }
        ListNode cur = newHead;
        while (cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
}
