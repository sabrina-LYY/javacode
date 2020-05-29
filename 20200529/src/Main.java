public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList();
        myArrayList.insert(1);
        myArrayList.insert(2);
        myArrayList.insert(5);
        myArrayList.insert(8);
        System.out.println(myArrayList.getPos(2));

    }


}
