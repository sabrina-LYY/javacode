public class TestDemo {
    public static void main(String[] args) {
        Integer a = 10;
        System.out.println(a);

        Integer i = 100;
        Integer j = 100;
        System.out.println(i==j);//-128<-->127之间，返回true

        Integer m = 128;
        Integer n = 128;
        System.out.println(m==n);//false
    }
}
