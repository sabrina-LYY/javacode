package com.bit;

import com.bit.demo1.Animal;

public class Demo2 extends Animal{

    public Demo2(String name) {
        super(name);
    }

    public void func(){
        System.out.println(this.name);//this代表demo2这个对象的引用
    }
    public static void main(String[] args) {
        Demo1 demo = new Demo1();
        System.out.println(demo.value);
    }
}
