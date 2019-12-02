
public class TestDemo2 {
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

}