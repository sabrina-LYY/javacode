public class TestDemo {
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