class ListNode{
    public int data;
    public ListNode next;
    public ListNode(int data){
        this.data = data;
        this.next = null;
    }
}

class SingleList {
    public ListNode head;
    public SingleList(){
        this.head = null;
    }

    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(this.head==null){
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
        if(this.head==null){
            this.head = node;
        }else{
            while(cur.next!=null){
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    //计算结点长度
    public int getLength(){
        int count = 0;
        ListNode  cur = this.head;
        while(cur!=null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    //任意位置插入,第一个数据节点为0号下标,插入到index位置
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
        if(index<0||index>getLength()){
            return false;
        }
        ListNode node = new ListNode(data);
        if(index == 0){
            addFirst(data);
            return true;
        }
        //找到index-1的位置
        ListNode prev = searchIndex(index);
        //进行插入
        node.next = prev.next;
        prev.next = node;
        return true;

    }

    //查找是否包含关键字key在单链表当中
    public boolean contains(int key){
        ListNode cur = this.head;
        if(this.head==null){
            return false;
        }
        while(cur!=null){
            if(cur.data==key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }


    //找到倒数第k个结点
    public ListNode findKthToTail(int k){
        ListNode fast = this.head;
        ListNode slow = this.head;

        if(k<=0){
            return null;
        }
        while(k-1>0){
            if(fast!=null){
                fast = fast.next;
                k--;
            }
            else{
                return null;
            }
        }
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverseList(){
        ListNode prev=null;
        ListNode cur = this.head;
        ListNode newHead = null;
        if(this.head==null){
            return null;
        }
        while(cur!=null){
            ListNode curNext = cur.next;
            if(curNext==null){
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = cur.next;

        }
        return newHead;
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
        System.out.println(" ");
    }


}
