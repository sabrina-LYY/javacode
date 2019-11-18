public class TestDemo {

    //合并两个有序单链表
    public static ListNode mergeTwoLists(ListNode headA,ListNode headB){
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while(headA!=null && headB !=null){
            if(headA.data<headB.data){
                tmp.next = headA;
                headA = headA.next;
                tmp = tmp.next;

            }else {
                tmp.next = headB;
                headB = headB.next;
                tmp = tmp.next;
            }
        }
        if(headA!=null){
            tmp.next = headA;
        }
        if(headB!=null){
            tmp.next = headB;
        }
        return newHead.next;

    }

    //找到两个节点的公共节点（相交）
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode PL = headA;
        ListNode PS = headB;
        int lenA = 0;
        int lenB = 0;
        while(PL != null){
            lenA++;
            PL = PL.next;
        }
        while(PS != null){
            lenB++;
            PS = PS.next;
        }
        PL = headA;
        PS = headB;
        int len = lenA - lenB;
        if(len<0){
            PL = headB;
            PS = headA;
            len = lenB-lenA;
        }
        while(len>0){
            PL = PL.next;
            len--;
        }
        while(PL != PS){
            PL = PL.next;
            PS = PS.next;
        }
        if(PL==null){
            return null;
        }
        return PL;
    }
    public static void createCut(ListNode headA, ListNode headB) {
        headA.next = headB.next.next;
    }


    public static void main(String[] args) {


        SingleList singleList = new SingleList();
        singleList.addFirst(3);
        singleList.addFirst(8);
        singleList.addFirst(5);
        singleList.addFirst(6);
        singleList.addFirst(7);
        singleList.addLast(2);
        singleList.display();

        ListNode node = singleList.partition(5);
        singleList.display1(node);

        /*singleList.removeAllKey(6);
        singleList.display();

        singleList.remove(5);
        singleList.display();

        ListNode newHead = singleList.reverseList();
        singleList.display1(newHead);
        System.out.println(singleList.addIndex(2,8));
        singleList.display();

        System.out.println(singleList.contains(10));
        ListNode node = singleList.findKthToTail(3);
        System.out.println(node.data);*/
    }
}