class Animal1{
    interface IFlying {
        void fly();
    }
    interface IRunning {
        void run();
    }
    interface ISwimming {
        void swim();
    }
}

class Cat extends Animal implements IRunning {
    public Cat(String name) {
        super(name);
    }
    @Override
    public void run() {
        System.out.println(this.name + "正在用四条腿跑");
    }
}

public class TestDemo4 {
    public static void main(String[] args) {

    }
}
