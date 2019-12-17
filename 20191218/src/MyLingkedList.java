

class MyLinkedList {
    /** Initialize your data structure here. */
    class ListNode{
        public  int val;
        public  ListNode next;
        public  ListNode(int val){
            this.val = val;
        }
    }
    public  int size;
    public ListNode head = null;
    public MyLinkedList() {
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        ListNode cur = this.head;
        while(index>=0 &&index<size){
            for(int i=0;i<index;i++){
                cur = cur.next;
            }
            return cur.next.val;
        }
        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val);
        newHead.next = this.head;
        this.head = newHead;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        ListNode cur = this.head;
        while(cur.next!=null){
            cur = cur.next;
        }
        cur.next = node;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        ListNode node = new ListNode(val);
        ListNode cur = this.head;
        if(index<0){
            addAtHead(val);
        }
        if(index>size-1){
            return;
        }
        if(index == size){
            addAtTail(val);
        }else{
            for(int i=0;i<index;i++){
                cur = cur.next;
            }
            ListNode curNext = cur.next;
            cur.next = node;
            node.next = curNext;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        ListNode cur = this.head;
        if(index>0 && index<size-1){
            for(int i=0;i<index;i++){
                cur = cur.next;
            }
            ListNode curNext = cur.next;
            cur.next = curNext.next;
        }
        if(index == 0){
            this.head = cur.next;
        }
        if(index == size-1){
            for(int i=0;i<size-1;i++){
                cur = cur.next;
            }
            cur.next = null;
        }
    }
}

