
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class CustomThreadPool {
    static class Worker extends Thread{
        private BlockingQueue<Runnable> workQueue;
        Worker(BlockingQueue<Runnable> workQueue){
            this.workQueue = workQueue;
        }
        @Override

        public void run() {
            //员工要做的事不停取任务
            while(!Thread.interrupted()){
                //从队列不同取任务，队列为空时，线程就会阻塞，否则就一直工作
                Runnable task = null;
                try {
                    task = workQueue.take();
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                    //这里表示收到了interrupt通知
                    break;
                }
                //完成任务
                task.run();
            }
        }
    }
    //1.传递任务引用的阻塞队列
    BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>();
    //2.记住所有线程对象
    //公司管理员工用的员工表
    List<Worker> workerList = new ArrayList<>();
    CustomThreadPool(int nThreads){
        //1.创建阻塞队列，done
        //2.创建所有工作线程
        for(int i=0;i<nThreads;i++){
            Worker worker = new Worker(workQueue);
            worker.start();
            workerList.add(worker);
        }
    }

    //前台要做的是把接到的任务放到队列中即可
    //工作线程会在合适的时候来取任务
    void execute(Runnable task) throws InterruptedException {
        workQueue.put(task);
    }
    void shutDown(){
        //让所有线程停止工作
        //可以使用interrupt建议一个线程停下来，时实际停止的时间处理不了
        for(Worker worker:workerList){
            worker.interrupt();
        }
    }

}
