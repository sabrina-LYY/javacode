import java.util.Scanner;
public class 如何通知一个线程停止 {
    static class 写作业 implements Runnable {
        @Override
        public void run() {
            Thread current = Thread.currentThread();
            while(Thread.interrupted()){
                //interrupted调用结束后线程内部收到一个异常：InterruptedException
                //isInterrupted()仍返回false
                try {
                    System.out.println("第一份作业");
                    Thread.sleep(3*1000);
                    System.out.println("第二份作业");
                    Thread.sleep(3*1000);
                    System.out.println("第三份作业");
                    Thread.sleep(3*1000);
                    System.out.println("第四份作业");
                    Thread.sleep(3*1000);
                    System.out.println("第五份作业");
                    Thread.sleep(3*1000);
                } catch (InterruptedException e) {

                    break;
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new 写作业());
        t.start();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        System.out.println("准备通知停止写作业");
        t.interrupt();
        System.out.println("已经通知停止写作业");

        t.join();
        System.out.println("已经停止写作业");
    }
}
