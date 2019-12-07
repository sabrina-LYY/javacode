
/*
Cloneable为什么是一个空接口？
        一般称空接口为标记接口
        Person implements Cloneable认为person将来可以被克隆
*克隆：
* 1.implements Cloneable
* 2.重写Object clone()
* 3.如果当前类包含了引用类型，
*   Person包含了money,在person的clone方法内不仅克隆自己本身还需要clone money
*/

class Money implements Cloneable{
    double money = 12.5;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class Person implements Cloneable{
    public String name;
    public Money m;
    public Person(){
        this.m = new Money();
    }


    //重写clone方法：Object
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person per = (Person)super.clone();
        per.m = (Money)this.m.clone();
        return per;
    }
}
public class TestDemo6 {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        Person person2 = (Person)person.clone();
        person2.m.money = 99;
        System.out.println(person.m.money);  //money克隆，进行深拷贝
        System.out.println(person2.m.money);
    }


    public static void main1(String[] args)throws CloneNotSupportedException {
        Person person = new Person();
        person.name = "caocao";
        System.out.println(person.name);
        Person person2 = (Person)person.clone();//person2为person的副本
        person2.name = "zhangfei";
        System.out.println(person2.name);
    }
}
