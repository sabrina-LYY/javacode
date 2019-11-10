public class TestDemo {
    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        singleList.addFirst(9);
        singleList.addFirst(8);
        singleList.addFirst(10);
        singleList.addFirst(8);
        singleList.addFirst(9);
        singleList.display();

        System.out.println(singleList.chkPalindrome());

        singleList.creteLoop();
        System.out.println(singleList.hasCycle());
        /*singleList.addIndex(0,1);
        singleList.display();
        singleList.addIndex(3,9);
        singleList.display();*/
        /*singleList.removeAllKey(3);
        singleList.display();*/

        ListNode head =  singleList.deleteDuplication();
        singleList.display2(head);



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
