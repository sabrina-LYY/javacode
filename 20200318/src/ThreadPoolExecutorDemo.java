import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        //创建一个最多有10个正式员工
        //最多有20个员工包括正式和临时
        // 临时工空闲时间最多有 60 SECONDS
        // 传递任务的队列是一个 ArrayBlockingQueue（容量是 30）
        // 执行默认的拒绝策略：处理不过来之后抛出异常
        ExecutorService p1 = new ThreadPoolExecutor(
                10,
                20,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(30)
        );
        //ExecutorService引用够可以指向一个线程池对象
        //提交任务
        p1.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
        //也是提交任务
        p1.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
        //关闭线程池
        p1.shutdown();//推荐使用这个
        p1.shutdownNow();
    }
}
