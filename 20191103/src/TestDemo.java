public class TestDemo {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addLast(1);
        mySingleList.addLast(2);
        mySingleList.addFirst(55);
        mySingleList.addLast(2);
        mySingleList.addFirst(2);
        mySingleList.addLast(9);
        mySingleList.display();
        mySingleList.remove(55);
        mySingleList.display();
        mySingleList.removeAllKey(2);
        mySingleList.display();

        System.out.println("dffasf");

    }
}
