import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            double x0 = in.nextDouble();
            double y0 = in.nextDouble();
            double z0 = in.nextDouble();
            double x1 = in.nextDouble();
            double y1 = in.nextDouble();
            double z1 = in.nextDouble();
            double r2 = Math.pow(x1-x0,2)+ Math.pow(y1-y0,2)+ Math.pow(z1-z0,2);
            double r = Math.sqrt(r2);
            System.out.printf("%.3f",r);
            System.out.print(" ");
            double v=(4*Math.acos(-1)*Math.pow(r,3))/3;
            System.out.printf("%.3f",v);
            System.out.println();
        }
    }
}
