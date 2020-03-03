package Why;

/**
 * 计算 0 + 1 + 2 + ... + NUMBER 和
 * 这个过程计算 COUNT 次
 *
 * 1. 单线程情况：我们之前的写法
 * 2. 多线程情况（COUNT) 个线程同时算
 */
public class testDemo {

    static final int count = 10;
    static final long number = 10_0000_0000;

    static long sum(){
        long r = 0;
        for(long i=0;i<number;i++){
            r+=i;
        }
        return r;
    }
    static void 单线程(){
        long b = System.nanoTime();
        for(int i=0;i<count;i++){
            System.out.println(sum());
        }
        long e = System.nanoTime();
        double s = (e-b)/1000_000_000.0;
        System.out.printf("单线程，运行时间：%f%n",s);
    }

    static class SumThread extends Thread{
        @Override
        public void run() {
            System.out.println(sum());
        }
    }

    static void 多线程() throws InterruptedException {
        long b = System.nanoTime();
        //// 因为当前也处于一个线程中，所以，只需要再创建 COUNT - 1 个线程
        Thread[] threads = new Thread[count-1];
        for(int i=0;i<count-1;i++){
            //最后执行的就是上面定义的类中的run方法
            threads[i] = new SumThread();
            threads[i].start();
        }
        //剩下的一次，当前线程来计算
        System.out.println(sum());

        //当前线程计算结束，但还要等另外的count-1个线程计算结束
        for(int i=0;i<count-1;i++){
            threads[i].join();
        }

        long e = System.nanoTime();
        double s = (e-b)/1000_000_000.0;
        System.out.printf("多线程，运行时间：%f%n",s);
    }

    public static void main(String[] args) throws InterruptedException {
        单线程();
        多线程();
    }
}
