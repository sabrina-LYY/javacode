public class TestDemo {
    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        singleList.addFirst(1);
        singleList.addFirst(3);
        singleList.addFirst(12);
        singleList.addFirst(3);
        singleList.addFirst(5);
        singleList.display();
        singleList.addIndex(0,99);
        singleList.display();
        singleList.addIndex(3,9);
        singleList.display();

        ListNode node1 = singleList.reverseList();
        singleList.display2(node1);

        ListNode node3 =singleList.middleNode();
        singleList.display2(node3);


        ListNode node2 = singleList.findKthToTail(2);
        singleList.display2(node2);
    }
}
