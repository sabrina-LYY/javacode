package com.bit.demo1;

//继承is--a的关系,是为了代码的复用
//继承的是父类除构造方法的所有
//子类继承父类，子类需要帮助父类进行构造
//protected--受保护的，主要体现在继承
public class Animal {
    protected String name;

    public Animal(String name){
        this.name = name;
    }
    public void eat(){
        System.out.println(this.name+"eat()!");
    }
}
