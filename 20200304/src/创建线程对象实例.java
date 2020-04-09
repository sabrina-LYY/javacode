public class 创建线程对象实例 {
    private static  class MyThread extends Thread{

    }
    private static class MyRunnable implements Runnable{

    }
    public static void main(String[] args) throws InterruptedException {
        Thread a = new MyThread();
        a.start();
        a.join();//1.主线程放弃cpu2.z直到a结束之前，承诺再也不抢cpu。主线程会一直阻塞在这，直到a线程执行结束，才接着执行

        Thread b = new MyThread();
        b.start();
        b.join();
    }
}
