public class TestDemo {
    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        singleList.addFirst(3);
        singleList.addFirst(4);
        singleList.addFirst(5);
        singleList.addFirst(6);
        singleList.addFirst(7);
        singleList.addLast(2);
        singleList.display();

        System.out.println(singleList.addIndex(2,8));
        singleList.display();

        System.out.println(singleList.contains(10));
    }
}
