/*
* 1.接口中定义的方法默认是public abstract
* 2.定义的成员变量默认是public static final
* 3.类和接口的关系是实现即implements
* 4.实现了接口必须重写方法
* 5.*/

interface IShape{
    //public static final int a=10;
    //public abstract void draw();
    //void func1();
    void draw();
}

class Rect1 implements IShape{
    @Override
    public void draw() {
        System.out.println("♦");
    }
}

class Flower1 implements IShape{
    @Override
    public void draw() {
        System.out.println("❀");
    }
}
public class TestDemo2 {
    public static void drawMap(IShape shape){
        shape.draw();
    }
    public static void main(String[] args) {
        IShape shape = new Rect1();//实现了接口就可以向上转型
        Rect1 rect = new Rect1();
        drawMap(shape);
        drawMap(rect);
    }
}
