
/*
* 类和接口是实现implements
* 接口之间是继承extends
* */


interface A{
    void funcA();
}
interface B{
    void funcB();
}
interface D extends A,B{ //接口之间是继承extends
    void funcD();
}
class C implements A,B{//接口的多继承
    @Override
    public void funcA() {

    }

    @Override
    public void funcB() {

    }
}
class F implements D{  //不仅要重写D，还要重写A、B
    @Override
    public void funcB() {

    }

    @Override
    public void funcD() {

    }

    @Override
    public void funcA() {

    }
}

public class TestDemo3 {
    public static void main(String[] args) {

    }
}
