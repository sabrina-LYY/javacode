public class 懒汉模式之提高效率 {

    private volatile  static 懒汉模式之提高效率 instance = null;
    private 懒汉模式之提高效率(){}




    //单例只需要new一次，所以只需要在有一次instance==null即可，
    // 其他次数都是不为空直接跳出判断
    private static Object lock = new Object();
    public static 懒汉模式之提高效率 getInstance(){
        if(instance == null){
            synchronized (lock){
                //只需要在为null时加锁即可
                if(instance==null){
                    instance = new 懒汉模式之提高效率();//有重排序问题，
                    // 可能导致instance不为Null时，instance指向的对象没有完全初始化好,所以要加volatile
                }

            }
        }
        return instance;
    }


    static  class MyThread extends Thread{
        @Override
        public void run() {
            懒汉模式之提高效率 ins1 = 懒汉模式之提高效率.getInstance();
            System.out.println(ins1);
        }
    }
    public static void main(String[] args) {
        MyThread[] threads = new MyThread[20];
        for(int i=0;i<20;i++){
            threads[i] = new MyThread();
        }
        for(int i=0;i<20;i++){
            threads[i].start();
        }

    }
}
