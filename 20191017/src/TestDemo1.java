public class TestDemo1 {
    /*public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};    //new表示产生一个对象
        System.out.println(arr);               //输出结果为数组首地址
        System.out.println(arr[0]);            //输出为数组首元素
        System.out.println(arr.length);     //.length  计算数组长度
        Print(arr);
    }
    public static void Print(int[] a){
        for(int x:a){
            System.out.println(x);
        }
    }*/
    public static void main(String[] args) {         //函数的引用
        int[] arr = {1,2,3};
        func(arr);
        System.out.println("arr[0]="+arr[0]);
    }


   public static void func(int[] a){
        a[0] = 10;
        System.out.println("a[0]="+a[0]);
        }
}
