public class test {
    private  static class A extends Thread{
        @Override
        public void run() {
            System.out.println("A");
        }
    }
    private  static class B extends Thread{
        @Override
        public void run() {
            System.out.println("B");
        }
    }
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        b.setPriority(Thread.MAX_PRIORITY);//优先级只是建议

        //把a,b放到就绪队列中
        a.start();
        b.start();
        System.out.println("main");
    }
}
