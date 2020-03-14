public class 单例模式之饿汉模式 {
    //饿汉--一开始就初始化。
    private static 单例模式之饿汉模式 instance= new 单例模式之饿汉模式();
    private 单例模式之饿汉模式(){}
    public static 单例模式之饿汉模式 getInstance(){
        return instance;
    }
    private static class MyThread extends Thread{
        @Override
        public void run() {
            单例模式之饿汉模式 ins1 = 单例模式之饿汉模式.getInstance();
            System.out.println(ins1);
        }
    }

    //理论上，多线程下也是正确的
    public static void main(String[] args) {
        MyThread[] threads = new MyThread[20];
        for(int i=0;i<20;i++){
            threads[i] = new MyThread();
        }
        for(int i=0;i<20;i++){
            threads[i].start();
        }





        /*单例模式之饿汉模式 ins1 = 单例模式之饿汉模式.getInstance();
        单例模式之饿汉模式 ins2 = 单例模式之饿汉模式.getInstance();
        单例模式之饿汉模式 ins3 = 单例模式之饿汉模式.getInstance();


        System.out.println(ins1==ins2);
        System.out.println(ins2==ins3);
*/
    }

}
