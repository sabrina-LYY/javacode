import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HasThreadPool {
    //这里是一个任务，不是线程
    static  class 送快递任务 implements   Runnable{
        String 快递;
        public 送快递任务(String 快递){
            this.快递 = 快递;
        }
        @Override
        public void run() {
            System.out.println("开始送快递"+快递);
            try {
                Thread.sleep(5*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("快递送完了"+快递);
        }
    }

    public static void main(String[] args) {
        ExecutorService 公司 =Executors.newFixedThreadPool(10);

        //主线程相当于前台
        Scanner scan = new Scanner(System.in);
        while(true){
            String 快递 = scan.nextLine();
            送快递任务 task = new 送快递任务(快递);
            公司.execute(task);
        }
    }
}
