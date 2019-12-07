
class Animal{
    protected String name;
    public Animal(String name) {
        this.name = name;
    }
}
interface IFlying{
    void fly();
}
interface IRunning {
    void run();
}
interface ISwimming {
    void swim();
}

class Cat extends Animal implements IRunning{
    public Cat(String name){
        super(name);
    }
    @Override
    public void run() {
        System.out.println(this.name+"正在跑");
    }
}
class Fish extends Animal implements ISwimming{
    public Fish(String name){
        super(name);
    }

    @Override
    public void swim() {
        System.out.println(this.name+"正在游泳");
    }
}
class Frog extends Animal implements IRunning,ISwimming{
    public Frog(String name){
        super(name);
    }

    @Override
    public void run() {
        System.out.println(this.name+"跑");
    }

    @Override
    public void swim() {
        System.out.println(this.name+"正在游泳");
    }
}
public class TestDemo4 {

    public static void walk(IRunning running){
        System.out.println("散步");
        running.run();
    }
    public static void main(String[] args) {
        Cat cat = new Cat("猫");
        walk(cat);
    }
}
