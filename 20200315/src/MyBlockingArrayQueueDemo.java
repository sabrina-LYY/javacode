import java.util.Scanner;

//定义队列对象，生产者线程是Producer，消费者是main线程
//队列是需要在生产者消费者之间共享的
public class MyBlockingArrayQueueDemo {
    static MyBlockingArrayQueue queue = new MyBlockingArrayQueue();
    //定义一个生产者线程类
    static class Producer extends Thread{
        @Override
        public void run() {
            try {
                for(int i=0;i<100;i++){
                    System.out.println("准备添加"+i);
                    queue.put(i);
                    System.out.println("成功添加");
                }
            }catch (InterruptedException e) {
                    e.printStackTrace();

            }

        }
    }


        public static void main(String[] args) throws InterruptedException {
            Producer producer = new Producer();
            producer.start();
            Thread.sleep(2*1000);

            Scanner scan = new Scanner(System.in);
            while(true){
                scan.nextLine();
                System.out.println(queue.take());
            }
        }
    }

