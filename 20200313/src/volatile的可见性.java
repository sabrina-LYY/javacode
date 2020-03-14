import java.util.Scanner;

public class volatile的可见性 {
    static volatile  boolean flag = true;
    static class MyThread extends Thread{
        @Override
        public void run() {
            int n=0;
            while(flag){
                n++;
            }
            System.out.println(n);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        t.start();
        Scanner scan = new Scanner(System.in);
        System.out.println("输入，使线程停下来");
        scan.nextLine();
        flag = false;//没有volatile，会出现输入之后敲回车，线程没有停下来的错误情况
        Thread.sleep(3*1000);
        System.out.println(t.isAlive());
    }
}
