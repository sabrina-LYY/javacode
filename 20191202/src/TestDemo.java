/*
*包含抽象方法的类   叫做抽象类
*抽象类和普通类最大的区别：包含抽象方法
*抽象类不能被实例化（不能new）
* 抽象类存在的意义是----肯定要被继承
*
* 抽象类一旦被继承就要重写抽象方法
* 一个类继承了抽象类，如果不重写抽象类的方法，那么当前类需要设置为抽象类
* （设置为抽象类，重写与否都可以）

*/
abstract class Shape{
    /*public int a;
    public void func(){
        System.out.println("func()");//此处的func和a只能继承之后由子类来使用，不能直接使用
    }*/
    public abstract void draw();//抽象方法
}



class Rect extends Shape{
    @Override
    public void draw() {
        System.out.println("♦");
    }
}
class Rect2 extends Rect{  //此处必须重写，因为Rect没有重写
   /* @Override
    public void draw() {
        System.out.println("♦");
    }*/
}



class Flower extends Shape{
    @Override
    public void draw() {
        System.out.println("❀");
    }
}

public class TestDemo {
    public static void drawMap(Shape shape){
        shape.draw();
    }
    public static void main(String[] args) {
        //抽象类 可以  提前检查代码的错误
       // Shape shape = new Shape();错误代码
        Rect rect = new Rect();
        Flower flower = new Flower();
        drawMap(rect);
        drawMap(flower);

    }
}
