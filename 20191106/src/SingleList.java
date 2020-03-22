class ListNode{
    public int data;
    public ListNode next;
    public ListNode(int data){
        this.data = data;
        this.next = null;
    }
}

public class SingleList {
    public ListNode head;
    public SingleList(){
        this.head = null;
    }

    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
        }
        else{
            node.next = this.head;
            this.head = node;
        }

    }

    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        ListNode cur = this.head;
        //0、判断是否是第一次插入
        if(this.head == null) {
            this.head = node;
        }else {
            //1、找尾巴
            while (cur.next != null) {
                cur = cur.next;
            }
            //2、进行插入
            cur.next = node;
        }
    }

    //任意位置插入,第一个数据节点为0号下标
    //1.先找到index-1的位置
    public ListNode SearchIndex(int index){
        ListNode prev = this.head;
        int count = 0;
        while(count<index-1){
            prev = prev.next;
            count++;
        }
        return prev;

    }
    //2.进行插入
   public boolean addIndex(int index,int data) {
        if(index<0||index>getLength()){
            return false;
        }
        if(index == 0){
            addFirst(data);
            return true;
        }
        ListNode prev = SearchIndex(index);
        ListNode node = new ListNode(data);
        node.next = prev.next;
        prev.next = node;
        return true;
   }

    //反转单链表
    public ListNode reverseList() {
        ListNode prev = null;
        ListNode newHead = null;
        ListNode cur = this.head;
        while (cur != null) {  //cur不为空是为了避免cur.next空指针异常
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

    public ListNode searchPrev(int key){
        ListNode prev = this.head;
        while(prev.next!=null){
            if(prev.next.data == key){
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }

    public void remove(int key){
        if(this.head == null){
            return;
        }
        //找到前一个结点
        ListNode prev = searchPrev(key);
        if(prev == null){
            System.out.println("没有此结点！");
            return;
        }
        ListNode del = prev.next;
        //进行删除
        prev.next = del.next;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode prev = this.head;
        ListNode cur = this.head.next;
        while(cur!=null){
            if(cur.data == key){
                prev.next = cur.next;
                cur = cur.next;
            }
            prev = cur;
            cur = cur.next;
        }
        //最后处理删除的数是头结点数的情况
        if(this.head.data==key){
            this.head = this.head.next;
        }
    }

    //清空链表
    public void clear(){
        while(this.head.next!=null){
            ListNode cur = this.head.next;
            this.head.next = cur.next;

        }
        this.head = null;
    }

    //给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
    // 如果有两个中间结点，则返回第二个中间结点
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

    //计算链表长度
    public int getLength(){
        int count = 0;
        ListNode cur = this.head;
        while(cur!=null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    //输入一个链表，输出该链表中倒数第k个结点
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
            }
            else {
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

    public void display2(ListNode newHead){
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

    public void display(){
        if(this.head==null){
            return;
        }
        ListNode cur = this.head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println("");
    }

    //6. 编写代码，以给定值x为基准将链表分割成两部分，
    // 所有小于x的结点排在大于或等于x的结点之前
    public ListNode  partition(int x) {
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        ListNode cur = this.head;
        if(this.head ==null||this.head.next==null){
            return this.head;
        }
        while(cur != null){
            if(cur.data < x){
                //判断是否第一次插入
                if(bs == null){
                    bs = cur;
                    be = cur;
                }else{
                    be.next = cur;
                    be = be.next;
                }
            }else{

                //判断是否第一次插入
                if(as == null){
                   as = cur;
                   ae = cur;

                }else{
                  ae.next = cur;
                  ae = ae.next;
                }
            }
            cur = cur.next;
        }
        if(bs == null){ //第一个区间没有数据
            return as;
        }
        be.next = as;//将两个段链接
        if(as!=null){
            ae.next = null;  //定结尾为空
        }
        return bs;
    }

    //7. 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
    // 重复的结点不保留，返回链表头指针。
    public ListNode deleteDuplication(){
        ListNode cur = this.head;
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        if(this.head==null){
            return null;
        }
        while(cur!=null){

            if(cur.next!=null && cur.data==cur.next.data){//重复结点
                while(cur.next!=null && cur.data==cur.next.data){
                    cur = cur.next;
                }
                cur = cur.next;
            }
            else{
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        tmp.next = null;//最后几个数相同的情况处理
        return newHead.next;
    }

    //8. 链表的回文结构。
    public boolean chkPalindrome() {
        if(this.head == null){
            return false;
        }
        if(this.head.next == null){
            return true;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        //找到单链表的中间结点
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //2.反转单链表
        ListNode cur = slow.next;
        while(cur!=null){
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        //3.fast/slow往前走，head往后走，直到相遇就是回文
        while(slow!=this.head){
            if(slow.data!=this.head.data){
                return false;
            }
            //判断偶数个结点的情况
            if(this.head.next == slow){
                return true;
            }
            slow = slow.next;
            this.head = this.head.next;
        }
        return true;
    }

    //创造环
    public void creteLoop(){
        ListNode cur = this.head;
        while(cur.next!=null){
            cur = cur.next;
        }
        cur.next = this.head.next.next;
    }
    //判断是否有环
    public boolean hasCycle() {
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast != null && fast.next != null) {
            return false;
        }
        return true;
    }
        //给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
        public ListNode detectCycle(){
            ListNode fast = this.head;
            ListNode slow = this.head;
			//第一次相遇
            while(fast!=null && fast.next!=null){
                fast = fast.next.next;
                slow = slow.next;
                if(slow == fast){
                    break;
                }
            }
            if(fast!=null && fast.next!=null){
                return null;
            }
            slow = this.head;
			
            while(slow!=fast){
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
    }
	
	
}
