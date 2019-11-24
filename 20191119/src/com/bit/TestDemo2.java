package com.bit;


interface IShape{//定义一个接口
    void draw();
    //public static final int a = 10;//定义成员变量默认是public static final
    //void func();//接口中定义方法，默认是public abstract

}
class Cycle implements IShape{
    @Override
    public void draw() {
        System.out.println("○");
    }
}

class Flower implements IShape{
    @Override
    public void draw() {
            System.out.println("❀");
    }
}
class Triangle implements IShape{
    @Override
    public void draw() {
        System.out.println("△");
    }
}
public class TestDemo2 {

    public static void drawMap(IShape shape){
        shape.draw();
    }
    public static void main(String[] args) {
        IShape shape = new Cycle();
        Cycle cycle = new Cycle();
        Flower flower = new Flower();
        drawMap(shape);
        drawMap(cycle);
        drawMap(flower);
    }
}

