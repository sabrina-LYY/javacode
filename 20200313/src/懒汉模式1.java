public class 懒汉模式1 {
    private static 懒汉模式1 instance = null;
    private 懒汉模式1(){}

    public synchronized static 懒汉模式1 getInstance(){
        if(instance==null){
            instance = new 懒汉模式1();
        }
        return instance;
    }

    public static 懒汉模式1 getInstance2(){
        synchronized (懒汉模式1.class){
            if(instance==null){
                instance = new 懒汉模式1();
            }
            return instance;
        }
    }

    /*public static Object lock = new Object();
    public static 懒汉模式1 getInstance3(){
        synchronized (lock){
            if(instance==null){
                instance = new 懒汉模式1();
            }
            return instance;
        }
    }*/
    private  static  class MyThread extends Thread{
        @Override
        public void run() {
            懒汉模式1 ins1 = 懒汉模式1.getInstance();
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




        /*懒汉模式1 ins1 = 懒汉模式1.getInstance();
        懒汉模式1 ins2 = 懒汉模式1.getInstance();
        懒汉模式1 ins3 = 懒汉模式1.getInstance();
        System.out.println(ins1==ins2);
        System.out.println(ins2==ins3);*/
    }
}
