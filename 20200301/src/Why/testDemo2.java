package Why;

import java.util.Scanner;

public class testDemo2 {

    static class FibThread extends Thread{
        int n;
        FibThread(int n){
            this.n = n;
        }
        @Override
        public void run() {
            System.out.printf("fib(%d) = %d%n",n,fib(n));
        }
    }

    static long fib(int n){
        if(n<2){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.print("请输入要计算的数:");
            int n = scan.nextInt();
            scan.nextLine();

            new FibThread(n).start();//创建一个新的线程，要做的就是运行上面的run方法
        }
    }
}
