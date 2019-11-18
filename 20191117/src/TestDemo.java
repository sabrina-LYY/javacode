public class TestDemo {
    public static void main(String[] args) {
        DoubleList doubleList = new DoubleList();
        doubleList.addLast(5);
        doubleList.addLast(4);
        doubleList.addLast(3);
        doubleList.addLast(4);
        doubleList.addLast(10);
        //doubleList.display();
        doubleList.addIndex(2,8);
        doubleList.display();


        /*doubleList.remove(4);
        doubleList.display();*/
        doubleList.removeAllKey(4);
        doubleList.display();

    }
}
