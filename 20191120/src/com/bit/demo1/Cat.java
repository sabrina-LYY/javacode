package com.bit.demo1;

//public final class Cat extends Animal{//final修饰变量，修饰的类叫密封类，不能被继承
public  class Cat extends Animal{
    //public String name;
    private String color;//子类独有
    public Cat(String name,String color){
        super(name);//显示的调用父类的构造方法，帮助父类进行构造,必须要放在第一行，因为子类要构造，必须先构造父类
        //this.name = name;
        this.color = color;
    }
    /*public void eat(){
        System.out.println(this.name+"eat()");
    }*/
    public void func(){
        String name = super.name;//
        super.eat();//调用父类的eat方法
    }
}

class ChineaeGardenCat extends Cat{
    public String sex;
    public ChineaeGardenCat(String name,String color,String sex){
        super(name,color);//多继承
        this.sex = sex;
    }
}