package com.bit.demo1;

public class Bird extends Animal{
    //public String name;
    private String yumao;
    public Bird(String name,String yumao){
        super(name);
        //this.name = name;
        this.yumao = yumao;
    }
    public void fly(){
        System.out.println(this.name+"fly");
    }
}
