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


    //重写clone方法
    @Override
    protected Object clone() throws CloneNotSupportedException {//为object类型，所以main中要强转；
        Person per = (Person)super.clone();
        per.m = (Money)this.m.clone();
        return per;
    }
}

public class TestDemo2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        /*person.name = "caocao";
        Person person2 = (Person)person.clone();
        person2.name = "zhangfei"; 
        System.out.println(person.name);
        System.out.println(person2.name);*/
        Person person2 = (Person)person.clone();
        person2.m.money = 55.5;
        System.out.println("person.m.money");
        System.out.println("person2.m.money");

    }
}
