public class 加锁练习 {

    //A线程执行方法1，B线程执行方法2，A,B会互斥
    static Object o1 = new Object();
    static void 方法1(){
        Object o2 = o1;
        synchronized (o2){

        }

    }
    static void 方法2(){
        Object o3 = o1;
        synchronized (o3){

        }
    }
}
