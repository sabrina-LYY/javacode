package com.bit.demo1;



//组合示例：
class Address{  //不重写就只能出现哈希值
    private String house;
    private int floor;

    public Address(String house,int floor){
        this.floor = floor;
        this.house = house;
    }

    @Override //重写之后才出现内容
    public String toString() {
        return "Address{" +
                "house='" + house + '\'' +
                ", floor=" + floor +
                '}';
    }
}



class Student{
    public String name;
    public Address address;
    public Student(String name,Address address){
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
public class Test {
    public static void function(Animal animal){

    }
    public static Animal function2(){
        Cat cat = new Cat("小花2","黑色");
        return cat;//方法的返回值，只要继承了Animal所有的类，都可以返回
    }
    public static void main(String[] args){
        Cat cat = new Cat("小花2","黑色");
        function(cat);//父类可以引用子类对象，
    }

    public static void main3(String[] args) {
        //Animal animal = new Animal("小花");
       // Cat cat = new Cat("小花2","黑色");

       // Animal animal = cat;//子类对象赋值给父类，向上转型
        Animal animal= new Cat("小花2","黑色");//向上转型
        //animal.func();//animal 中没有func方法，父类引用只能调用父类自己的方法或访问自己的属性
    }

    public static void main2(String[] args) {
        Address address = new Address("2号楼",3);
        Student student = new Student("zhangsan",address);
        System.out.println(student);
    }

    public static void main1(String[] args) {
        Cat cat = new Cat("小花","黑色");
        cat.eat();
        Bird bird = new Bird("小明","yumao");
        bird.eat();
        bird.fly();
    }
}
