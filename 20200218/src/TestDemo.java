

class OuterClass{
    public int data1=2;
    public int data2=3;
    int data3;
    public static int size = 10;

    public OuterClass(){
        System.out.println("outerClass");
    }


    //实例内部类
    class InnerClass{
        public int data4 = 4;
        public int data1 =22;
        //public static int size = 10;在实例内部类当中，不能定义static 的属性或方法，
        public static final int size = 10;//实例内部类里的数据成员，一定是在编译期间就能确定的）因为final是编译期间形成的
        public InnerClass(){
            System.out.println("InnerClass");
        }
        public void test(){
            System.out.println("data1:"+data1);
            System.out.println("out::data1:"+OuterClass.this.data1);
            System.out.println("test()");
        }
    }

}

class OuterClass2 {
    public int data1 = 2;
    public int data2 = 3;
    int data3;
    public static int data5 = 5;

    public OuterClass2() {
        System.out.println("outerClass");
    }
    //静态内部类
    static class InnerClass2{
        public int data4 = 4;
        public static int data5 = 5;

        OuterClass2 outerClass2;
        public InnerClass2(OuterClass2 o){//传入一个外部类对象的引用来访问外部类的静态方法
            this.outerClass2 = o;
            System.out.println("OuterClass2.InnerClass2");
        }
        public InnerClass2(){
            System.out.println("InnerClass2");
        }
        public void test(){
            //System.out.println("data1:"+data1);错误，静态内部类不能访问外部类的非静态数据成员
            System.out.println("data1:"+this.outerClass2.data1);
            System.out.println("data5:"+ OuterClass2.data5);
            System.out.println("InnerClass2::test");
        }
    }

}
//匿名内部类
class OuterClass3{
    public int data1 = 10;

    public void test(){
        System.out.println("Outerclass:test()");
    }
}



public class TestDemo {
    //把Node 定义为TestLink的内部类在类外使用如下
    public static<T extends Comparable<T>> TestLink.Node<T> mergeLink(TestLink.Node<T> headA, TestLink.Node<T> headB){
        //静态内部类实现
        TestLink.Node<T> newHead = new TestLink.Node<>();
        TestLink.Node tmp = newHead;

        while(headA!=null && headB!=null){
            if(headA.data.compareTo(headB.data)<0){
                tmp.next = headA;
                headA = headA.next;
                tmp=tmp.next;
            }else{
                tmp.next = headB;
                headB = headB.next;
                tmp=tmp.next;
            }
        }
        if(headA !=null){

            tmp.next=headA;
        }
        if(headB !=null){
            tmp.next=headB;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        TestLink<Integer> testLink = new TestLink<>();
        testLink.show();
        testLink.InsertTail(1);
        testLink.InsertTail(3);
        testLink.InsertTail(5);
        testLink.InsertTail(7);
        testLink.show();
        TestLink<Integer> testLink2 = new TestLink<>();
        testLink2.InsertTail(2);
        testLink2.InsertTail(4);
        testLink2.InsertTail(6);
        testLink2.InsertTail(8);
        testLink2.show();
        TestLink.Node<Integer> newHead = mergeLink(testLink.head,testLink2.head);
        testLink.show2(newHead);
    }


    public static void main3(String[] args) {
        new OuterClass3(){

        }.test();
    }

    public static void main2(String[] args) {
        OuterClass2 outerClass2 = new OuterClass2();
        //获取静态内部类的对象
        OuterClass2.InnerClass2 innerClass2 = new OuterClass2.InnerClass2(outerClass2);

        innerClass2.test();
    }


    public static void main1(String[] args) {

        OuterClass outerClass = new OuterClass();
        //System.out.println(outerClass.data1);
        //获取实名内部类的对象
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();

        innerClass.test();
    }
}
