public class 演示不同线程下的状态 {
    private static void print(){
        Thread current = Thread.currentThread();//拿到当前线程的引用
        //全部带着ID，希望分辨出是哪个线程打印的
        System.out.println(current.getId()+":"+current.getName());
        System.out.println(current.getId()+":"+current.getPriority());
        System.out.println(current.getId()+":"+current.getState());
        System.out.println(current.getId()+":"+current.isDaemon());
        System.out.println(current.getId()+":"+current.isAlive());
        System.out.println(current.getId()+":"+current.isInterrupted());
    }

    public static void main(String[] args) {
        Thread t = new Thread(() ->{
            print();//在子线程打印
        });
        t.start();

        print();//在主线程打印
    }
}
