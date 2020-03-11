
public class 演示线程状态的变化 {
    static class MyThread extends Thread {
        @Override
        public void run() {
            for(long i=0;i<100_0000_0000L;i++){


            }
        }
    }

    public static void main1(String[] args) {
        MyThread t = new MyThread();
        System.out.println(t.getState());//NEW
        t.start();
        System.out.println(t.getState());//RUNNING

        while(t.isAlive());//只要线程活着，一直循环
        System.out.println(t.getState());//TERNIMATED
    }

    static class MyThread2 extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(100*100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main2(String[] args) throws InterruptedException {
        MyThread2 t = new MyThread2();
        t.start();
        System.out.println(t.getState());
        //还是RUNNABLE，因为大概率情况下t还没抢到CPU

        Thread.sleep(1000);//主线程放弃CPU，使得t大概率能抢到CPU
        System.out.println(t.getState());//TIMED_WAITING
    }

    static class 张三 extends Thread{
        @Override
        public void run() {
            while(true){
                System.out.println("张三在唱歌");
                Thread.yield();
            }
        }
    }
    //不加yield。基本一样多，加了张三就会变少。
    static class 李四 extends Thread{
        @Override
        public void run() {
            while(true){
                System.out.println("李四在唱歌");
            }
        }

        public static void main(String[] args) {
            Thread zs = new 张三();
            Thread ls = new 李四();
            zs.start();
            ls.start();
        }
    }
}
