//1、编写一个类Calculator,有两个属性num1,num2,这两个数据的值，不能在定义的同时初始化，最后实现加减乘
//        除四种运算.
/*class Calculator{
    private double num1;
    private double num2;

    public Calculator(){
        this.num1 = 5;
        this.num2 = 8;
    }
    public void show(){
        System.out.println("add="+(num1+num2)+" "+"div="+(num1-num2)
                +" "+"mult="+(num1*num2)+" "+"div="+(num1/num2));
    }
}
public class HomeWork {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        cal.show();
    }
}*/

//方法2
/*
class Calculator{
    private int num1;
    private int num2;

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }
}
public class HomeWork {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt;
        int num2 = scanner.nextInt;
        Calculator setNum1(num1);
        Calculator setNum2(num2);
        Calculator getNum1();
        Calculator getNum2();

    }
}
*/


//2、设计一个包含多个构造函数的类，并分别用这些构造函数来进行实例化对象。

/*
class Student{
    private String name;
    private int age;
    private String sex;

    public Student(){
        this.name = "小王";
        this.age = 12;
        this.sex = "女";
    }
    public Student(String name,int age,String sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public void eat(){
        System.out.println(name +age+sex+"在吃饭");
    }
    public void study(){
        System.out.println(name +age+sex+"在学习");
    }
    public void show(){
        System.out.println("name:"+name+",age:"+age+"岁,sex:"+sex);
    }
}
public class HomeWork {
    public static void main(String[] args) {
        Student stu1 = new Student();
        stu1.show();
        stu1.eat();
        Student stu2 = new Student("小刘",18,"男");
        stu2.show();
        stu2.study();
    }
}*/

//3、实现交换两个变量的值。要求：需要交换实参的值。
import java.util.Scanner;

class MyValue{
    private int val;
}
public class HomeWork {
    public static void swap2(MyValue a,MyValue b){
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt;
        int num2 = scanner.nextInt;
        MyValue myValue1 = new MyValue();
        myValue1.val = 10;
        MyValue myValue2 = new MyValue();
        myValue2.val = 20;
        System.out.println(myValue1.val + " " + myValue2.val);
        swap2(myValue1,myValue2);
        System.out.println(myValue1.val + " " + myValue2.val);
    }
}