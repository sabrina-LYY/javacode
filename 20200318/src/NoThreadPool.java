import java.util.Scanner;

public class NoThreadPool {
    //这里是线程
    static  class Deliver extends  Thread{
        String 快递;
        public Deliver(String 快递){
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
        //主线程相当于前台
        Scanner scan = new Scanner(System.in);
        while(true){
            String 快递 = scan.nextLine();
            Thread worker = new Deliver(快递);
            worker.start();
        }
    }
}
