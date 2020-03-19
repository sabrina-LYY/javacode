import java.util.Scanner;
public class UseOfWait {
    static Object o = new Object();
    static class Print extends Thread{
        @Override
        public void run() {
            try {
                for(int i=0;i<50;i++){
                    System.out.println(i);

                    if(i==30){
                        //在o位置等
                        synchronized (o){
                            o.wait();
                        }
                    }
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Print print = new Print();
        print.start();
        Thread.sleep(2*1000);
        System.out.println("输入，唤醒print线程");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();

        synchronized (o){
            o.notify();
        }
    }
}
