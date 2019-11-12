public class TestDemo {
    public static void main(String[] args) {
        SingleList singleList  = new SingleList();
        singleList.addFirst(2);
        singleList.addFirst(8);
        singleList.addFirst(15);
        singleList.addFirst(9);
        singleList.display();
        singleList.reverseList();
        singleList.display();
    }
}
