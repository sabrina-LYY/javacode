/*
class Person{
    public int age;
    public String name;
    public String sex;

    public void eat(){
        System.out.println("吃饭");
    }
    public void sleep(){
        System.out.println("睡觉");
    }
}

class TestDemo {
    public static void main(String[] args){
        Person person = new Person();//通过new实例化一个对象
        person.eat();                //访问实例成员方法
        person.sleep();
        Person person2 = new Person();
        Person person3 = new Person();
        }
*/


//字段本地初始化
/*class Person{
    public String name = "张三";
    public int age = 18;
}
class TestDemo {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.name);
        System.out.println(person.age);
    }
}*/


/*class Person{
    public int age = 18;
    public String name = "张三";
    public void show(){
        System.out.println("我叫"+name +",今年"+ age +"岁");
    }
}
class TestDemo{
    public static void main(String[] args) {
        Person person = new Person();
        person.show();  //成员方法的调用需要通过对象引用来调用
    }
}*/


//static关键字的用法
/*class TestDemo1{
    public int a;
    public static int count;
}
public class TestDemo{
    public static void main(String[] args) {
        TestDemo1 t1 = new TestDemo1();
        t1.a++;
        TestDemo1.count++;
        System.out.println(t1.a);
        System.out.println(TestDemo1.count);
        System.out.println("===============");
        TestDemo1 t2 = new TestDemo1();
        t2.a++;
        TestDemo1.count++;     //count为static修饰，所有类共享，且不属于对象，访问方式：类名.属性
        System.out.println(t2.a);
        System.out.println(TestDemo1.count);
    }
}*/



/*class Person {
    public int age;
    public String name;
    public String sex;
    public static int count;
    public final int SIZE = 10;
    public static final int COUNT = 99;  //public 修饰的成员变量或方法，可以被类的调用者使用

    public void eat() {
        int a = 10;
        System.out.println("eat()!");
    }

    public void sleep() {
        System.out.println("sleep()!");
    }

    public static void staticTest() {
        System.out.println("staticTest()");
    }
}
public class TestDemo {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.age);
        System.out.println(person.name);
        System.out.println(person.sex);
        System.out.println(person.SIZE);//实例变量，person.实例成员变量
        System.out.println(Person.count);//静态变量，类名.变量名
        System.out.println(Person.COUNT);
        Person.staticTest();
        person.eat();
        person.sleep();
    }
}*/


//需要获取private的属性，就要使用getter/setter
/*class Person{
    private String name;
    private int age;

    public void setName(String name){
        this.name = name; //this表示当前实例的引用
    }
    public String getName(){
        return name;
    }
    public void show(){
        System.out.println("name:"+name+",age:"+age);
    }
}
class TestDemo{
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("王五");

        String name = person.getName();
        System.out.println(name);
        person.show();

    }
}*/


//构造函数的用法
/*class Person{
    private String name;
    private int age;
    private String sex;

    public Person(){
        this.name = "张三";
        this.age = 29;
        this.sex = "男";
    }
    public Person(String name,int age,String sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public void show(){
        System.out.println("name:" +name+",age:"+age+",sex:"+sex);
    }
}
class TestDemo{
public static void main(String[]args){
        Person per1 = new Person();//此构造函数无参
        per1.show();
        Person per2 = new Person("zhangsan",52,"男");//含三个参数的构造函数
        per2.show();
        }
}*/

//this关键字
/*class Person{
    private String name;
    private int age;
    private String sex;

    public Person(){
        //this调用构造函数，必须放在第一行，this代表当前对象的引用
        this("lala",54,"man");
    }
    public Person(String name,int age,String sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public void show(){
        System.out.println("name:"+name+",age:"+age+",sex:"+sex);
    }
}
class TestDemo{
    public static void main(String[] args) {
        Person person = new Person();
        person.show();
    }
}*/

/*class Person{
    private String name;
    private int age;
    private String sex;
    private static int count = 0;

    public Person(){
        System.out.println("I am Person init()!");
    }
    //2.实例代码块
    {
        this.name = "zhang";
        this.age = 19;
        this.sex = "女";
        System.out.println("I am instance init()!");
    }

    public void show(){
        System.out.println("name:"+name+"age:"+age+"sex:"+sex);
    }
    //1.静态代码块:一般初始化静态成员属性(最先执行，且只执行一次)
    static{
        count = 99;
        System.out.println("I am static init()!");
    }
}
public class TestDemo{
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();
    }
}*/

/*
//使用toString
class Person{
    private String name;
    private int age;
    public Person(String name,int age){
        this.age = age;
        this.name = name;
    }
    public void show(){
        System.out.println("name:"+name+",age:"+age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class TestDemo{
    public static void main(String[] args) {
        Person person = new Person();
        person.show();
        System.out.println(person);
    }
}
*/

class TestDemo {
    public static void main(String[] args) {
        MyArrayList myarraylist = new MyArrayList();
        myarraylist.add(0, 10);
        myarraylist.add(1, 5);
        myarraylist.add(2, 3);
        myarraylist.add(0, 9);
        myarraylist.display();
        myarraylist.remove(5);
        myarraylist.display();
    }
}



