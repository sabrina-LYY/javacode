import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.util.InputMismatchException;
import java.util.Scanner;

//继承的异常时编译时异常，必须通过try  catch块处理
class MyException extends Exception{
    public MyException(String s){
        super(s);
    }
}
public class TestDemo2 {

    public static void func4() throws MyException {
        int a=10;
        if(a==10){
            throw new MyException("MyException异常");
        }
    }
    public static void main(String[] args) {
        try{
            func4();
        }catch(MyException e){
            e.printStackTrace();
        }
    }



    //编译时期的异常必须编译通过(处理异常)才能运行
    public static String readFile(){
        //尝试打开文件，并读其中的一行
        File file = new File("d:test.txt");
        try{
            //使用文件对象构造Scanner对象
            Scanner sc = new Scanner(file);
            return sc.nextLine();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
    public static void main10(String[] args) {
        System.out.println(readFile());
    }


    //finally中最好不要有return，如果catch中有return，finally中的return 依然最后执行。
    // （finally中的return会抑制try和catch中的return ）
    public static int func3(){
        try{
            int a = 10/0;
            return 8;
        }catch(ArithmeticException e){
            e.printStackTrace();
            return 10;
        }finally{
            System.out.println("finally");
            return 9;//仍然最后执行
        }
    }
    public static void main9(String[] args) {
        int ret = func3();
        System.out.println(ret);

    }




    public static void func2(int a,int b){
        if(b==0){
            throw new ArithmeticException();//手动抛出异常
        }
        System.out.println(a/b);
    }
    public static void main8(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        try{
            func2(a,b);
        }catch(ArithmeticException e){
            e.printStackTrace();
        }finally{
            scanner.close();
        }
        System.out.println("java");
    }





    public static void main7(String[] args) {
        int[] array = {1,2,3,4};
        try (Scanner scanner = new Scanner(System.in)) {
            int a = scanner.nextInt();
            int b = 10 / a;
            System.out.println(b);
        } catch (ArithmeticException | InputMismatchException e) {
            e.printStackTrace();
            System.out.println("捕获到了异常");
        } finally {
            //关闭的位置,或者把Scanner scanner = new Scanner(System.in)放在try中就不用写关闭
            System.out.println("finally永远、最后执行");
        }
        System.out.println("after");

    }
    public static void main6(String[] args) {
        int[] array = {1,2,3,4};
        try{
            array = null;
            System.out.println(array[4]);
        }catch(ArrayIndexOutOfBoundsException | NullPointerException e){//捕获多个异常
            e.printStackTrace();
            System.out.println("捕获到了异常");
        }
        System.out.println("after");
    }



    public static void main5(String[] args) {
        int[] array = {1,2,3,4};
        try{
            //array = null;此处为空指针异常但是捕获的是数组下标越界异常，
            // 会向上反馈，最终交由JVM处理，则after就不会打印出来
            System.out.println(array[4]);
        }catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println("捕获到了异常");
        }
        System.out.println("after");
    }




    public static void main1(String[] args) {
        int a = 10;
        try {
            if (a == 10) {
                throw new Exception("异常");
            }
        } catch (Exception e) {
            e.printStackTrace();//信息被输出到标准输出流
        } finally {
            System.out.println("finally");
        }
    }

    public static void main2(String[] args) {
        try {
            String str = null;
            str.length();
        } catch (NullPointerException e) {
            e.printStackTrace();//信息被输出到标准输出流
        }
    }

    public static void main3(String[] args) {
        int[] array = {1, 2, 3, 4};
        try {
            System.out.println(array[100]);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("捕获到了异常");
        }
    }

    public static void main4(String[] args) {

    }

}