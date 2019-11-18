public class TestDemo {
    //合并两个有序链表
    public static ListNode  mergeTwoLists(ListNode headA, ListNode headB){
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while(headA !=null && headB!=null){
            if(headA.data < headB.data){
                tmp = headA;
                headA = headA.next;
                tmp = tmp.next;
            }else{
                tmp = headB;
                headB = headB.next;
                tmp = tmp.next;
            }

        }
        if(headA != null){
            tmp.next = headA;
        }
        if(headB !=null){
            tmp.next = headB;
        }
        return newHead.next;
    }

//找到两个链表相交的节点
public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode PL = headA;
        ListNode PS = headB;
        int lenA = 0;
        int lenB = 0;
        while(PL !=null){
            lenA++;
            PL = PL.next;
        }
        while(PS !=null){
            lenB++;
            PS = PS.next;
        }
        PL = headA;
        PS = headB;
        int len = lenA-lenB;
        if(len <0){
            PL = headB;
            PS = headA;
            len = lenB-lenA;
        }
        while(len>0){
            PL = PL.next;
            len--;
        }
        if(PL !=PS){
            PL = PL.next;
            PS = PS.next;
        }
        if(PL == null){
            return null;
        }
        return PL;
}

    public static void main(String[] args) {
        SingleList singleList = new SingleList();
    }
}
