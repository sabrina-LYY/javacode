class Animal{
    public String name;
    public Animal(String name){
        this.name = name;
    }
    public void eat(){

        System.out.println(this.name+"正在吃");
    }
}
class Cat extends Animal{
    public String sex;
    public Cat(String name,String sex){
        super(name);
        this.sex = sex;
    }
    public void jump(){

        System.out.println(this.name+"jump");
    }
}

class Bird extends Animal{
    public String sex;
    public Bird(String name,String sex){
        super(name);
        this.sex = sex;
    }
    public void fly(){

        System.out.println(this.name+"fly");
    }


}

public class TestDemo1 {
    public static void main(String[] args) {
        //向上转型
        Animal animal = new Cat("小花","nan");
        animal.eat();
        //向下转型
        Animal animal2 = new Bird("小米","nan");
        animal2.eat();
        Bird bird =(Bird)animal2;
        bird.fly();
    }
}
