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
    public SingleList() {
        this.head = null;
    }

    //逆置       反转一个单链表。    //方法二 利用头插法逆置
    public ListNode reverseList(int data) {
        ListNode prev = null;
        ListNode newHead = null;
        ListNode cur = this.head;
        while (cur != null) {
            ListNode curNext = cur.next;
            if (curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }


    //求列表长度
    public int getLength() {
        int count = 0;
        ListNode cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //要求只遍历一遍列表就能找到位置,fast走两步，slow走一步
    public ListNode middleNode(int data) {
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public void display2(ListNode newHead) {
        if (newHead == null) {
            return;
        }
        ListNode cur = newHead;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //4. 输入一个链表，输出该链表中倒数第k个结点。
    public ListNode findKthToTail1(int k) {
        if (k <= 0 || k > getLength()) {
            return null;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (k - 1 > 0) {
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
        if (k <= 0) {
            return null;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (k - 1 > 0) {
            if (fast.next != null) {
                fast = fast.next;
                k--;
            } else {
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
}