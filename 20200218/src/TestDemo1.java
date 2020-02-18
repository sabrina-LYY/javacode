
//写一个通用栈
class MyStack<T>{
    public T[] elem;
    public int top;
    public MyStack(){
        //this.elem = new T[10];//不能new 泛型数组
        this.elem = (T[])new Object[10];
        this.top = 0;
    }
    public void push(T data){
        this.elem[top++] = data;
    }

    public T pop(){
        T oldData = this.elem[top-1];
        top--;
        return oldData;
    }
}

//写一个泛型类，找出数组中的最大值
class Algorithm<T extends Comparable>{
    public T findMaxValue(T[] array){
        T maxVal = array[0];
        for(int i=0;i<array.length;i++){
            if(array[i].compareTo(maxVal)>0){//T是引用类型，要实现comparable,但object没有实现comparable
                maxVal = array[i];
            }
        }
        return maxVal;
    }
}

//变成静态方法就可以直接通过类名进行调用
class Algorithm2{
    public static<T extends  Comparable> T findMaxValue(T[] array){
        T maxVal = array[0];
        for(int i=0;i<array.length;i++){
            if(array[i].compareTo(maxVal)>0){//T是引用类型，要实现comparable,但object没有实现comparable
                maxVal = array[i];
            }
        }
        return maxVal;
    }
}


//写一个泛型类，打印数组中的所有元素
class Algorithm3{
    public static<T> void printList(T[] array){
        for(T obj:array){
            System.out.print(obj+" ");
        }
        System.out.println("");
    }


}


public class TestDemo1 {

    public static void main(String[] args) {
        Algorithm<Integer> algorithm = new Algorithm<>();
        Integer[] array = {10,5,88,25,2};
        Integer ret = algorithm.findMaxValue(array);
        System.out.println(ret);

        //静态的方法，可以通过实参array的类型推导出形参T的类型
        Integer ret2 = Algorithm2.findMaxValue(array);
        System.out.println(ret2);

        Algorithm3.printList(array);
    }


    public static void main1(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        int a = myStack.pop();
        System.out.println(a);

        //泛型的参数不能是简单类型，只能是引用类型（Integer等）

        MyStack<String> myStack2 = new MyStack<>();
        myStack2.push("li");
        String s = myStack2.pop();
        System.out.println(a);
        /*MyStack myStack = new MyStack();
        myStack.push(1);
        Object a=myStack.pop();
        System.out.println(a);*/
    }
}
