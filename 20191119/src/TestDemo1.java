class Animal{
    public String name;
    public Animal(String name){
        this.name = name;
    }

    public void eat(String food){
        System.out.println(this.name+"正在吃"+food);
    }
}
class Cat extends Animal{
    public Cat(String name){
        super(name);
    }
}

class Bird extends Animal{
    public Bird(String name){
        super(name);
    }

    public void fly(){
        System.out.println(this.name+"正在飞");
    }
}
public class TestDemo1 {
    public static void main(String[] args) {

        Cat cat = new Cat("小花");
        cat.eat("猫粮");
        Bird bird = new Bird("小明");
        bird.fly();
        /*//向上转型
        Animal animal = new Cat("小花","nan");
        animal.eat();
        //向下转型
        Animal animal2 = new Bird("小明","nan");
        animal2.eat();
        Bird bird =(Bird)animal2;
        bird.fly();*/
    }
}
