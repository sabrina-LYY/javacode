class Animal{
    public String name;
    public Animal(String name){
        this.name = name;
    }
    public void eat(){
        System.out.println(this.name+"eat");
    }
}
class Cat extends Animal{
    public String sex;

    public Cat(String name,String sex){
        super(name);
        this.sex = sex;
    }
    public void jump(){
        System.out.println(this.name+"jump");//此处的name是从Animal继承过来的
    }
}

class Bird extends Animal{
    public Bird(String name){
        super(name);
    }
    public void fly(){
        System.out.println(this.name+"fly");
    }
}
public class TestDemo {
    public static void main(String[] args) {
        Animal animal = new Cat("小花","man");//向上转型
        animal.eat();
        Animal animal2 = new Bird("小明");//向下转型
        if(animal2   instanceof  Bird){
            Bird bird = (Bird)animal2;
            bird.fly();//注意，向下转型必须先向上转型
        }

    }
}
