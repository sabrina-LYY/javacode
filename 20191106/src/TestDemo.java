public class TestDemo {
    //将两个有序链表合并为一个新的有序链表并返回。
    // 新链表是通过拼接给定的两个链表的所有节点组成的
    public static ListNode mergeTwoLists(ListNode headA, ListNode headB) {
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while(headA!=null && headB!=null){
            if(headA.data < headB.data){
                tmp.next = headA;
                headA = headA.next;
            }else{
                tmp.next = headB;
                headB = headB.next;
            }
            tmp = tmp.next;
        }
        if(headA==null){
            tmp.next = headB;
        }
        return newHead.next;
    }


    //输入两个链表，找出它们的第一个公共结点
    //1.地址相同
    //2.Y型
    public static ListNode getIntersectionNode(ListNode headA,ListNode headB){
        if(headA==null || headB==null){
            return null;
        }
        ListNode pL = headA;
        ListNode pS = headB;
        int lenA = 0;
        int lenB = 0;
        //求lenA,lenB
        while(pL!=null){
            lenA++;
            pL = pL.next;
        }
        while(pS!=null){
            lenB++;
            pS = pS.next;
        }

        pL = headA;
        pS = headB;
        //差值，最长的先走len步
        int len =lenA-lenB;
        if(len<0){
            pL = headB;
            pS = headA;
            len = lenB-lenA;
        }
        while(len>0){
            pL=pL.next;
            len--;
        }
        if(pL!=pS){
            pL = pL.next;
            pS = pS.next;
        }
        if( pL==null ){
            return null;
        }
        return pL;
    }

    public static void createCut(ListNode headA,ListNode headB){
        headA.next.next = headB.next.next.next;
    }
    public static void main(String[] args) {
        SingleList singleList = new SingleList();

        singleList.addLast(1);
        singleList.addLast(2);
        singleList.addLast(5);
        singleList.addLast(8);
        singleList.addLast(12);
        singleList.display();

        SingleList singleList2 = new SingleList();
        singleList2.addLast(3);
        singleList2.addLast(6);
        singleList2.addLast(7);
        singleList2.addLast(11);
        singleList.display();
        createCut(singleList.head,singleList2.head);
        ListNode node =  getIntersectionNode(singleList.head,singleList2.head);
        System.out.println(node.data);


        //System.out.println(singleList.chkPalindrome());


        /*singleList.creteLoop();
        boolean flag = singleList.hasCycle();
        System.out.println(flag);
        /*singleList.addIndex(0,1);
        singleList.display();
        singleList.addIndex(3,9);
        singleList.display();*/
        /*singleList.removeAllKey(3);
        singleList.display();*/

        /*ListNode head =  singleList.deleteDuplication();
        singleList.display2(head);
*/


        /*ListNode node4 = singleList.partition(4);
        singleList.display2(node4);
*/
/*

        ListNode node3 = singleList.middleNode();
        System.out.println(node3.data);

        System.out.println(singleList.contains(5));

        ListNode node2 = singleList.findKthToTail1(7);
        System.out.println(node2.data);

        ListNode node1 = singleList.reverseList();
        singleList.display2(node1);
*/



    }
}
