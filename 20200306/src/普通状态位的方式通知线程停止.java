import java.util.Scanner;

public class 普通状态位的方式通知线程停止 {
    //普通的方法会在标志位置为false之后，再慢慢把剩下的都输出完整再结束。
    private static boolean condition = true;
    static class 写作业 implements Runnable {
        @Override
        public void run() {
            while(condition){
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
        condition = false;//condition = false不具备让sleep抛出异常的功能
        System.out.println("已经通知停止写作业");

        t.join();
        System.out.println("已经停止写作业");
    }
}
