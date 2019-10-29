/*
public class TestDemo1 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        print(array);
    }
    public static void print(int [] a){
        for (int x:a){
            System.out.println(x);

     }
    }
}
*/

//不修改原数组，将数组每个数扩大2倍
/*
import java.util.Arrays;
public class TestDemo1 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        int[] ret = transform(array);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(ret));
    }
    public static int[] transform(int[] array){
        int[] tmp = new int[array.length];
        for(int i=0;i<array.length;i++){
            tmp[i] = array[i]*2;
        }
        return tmp;
    }
}*/

//模拟实现Array.toString()方法  [1,2,3,4,5,6]
/*
public class TestDemo1 {
    public static void main(String[] args) {
        int [] array = {1,2,3,4,5,6};
        String str = toString(array);
        System.out.println(str);
        }
public static String toString(int[] array){
        //字符串拼接
        String str = "[";
        for(int i=0;i<array.length;i++){
            str += array[i];
            if(i!=array.length-1){
            str+=",";
            }
        }
        str +="]";
        return str;
    }*/

import java.util.Arrays;

//求数组中的最大值
/*public class TestDemo1{
    public static void main(String[] args){
        int[] array = {1,2,3,4};
        int max = MaxNum(array);
        System.out.println(max);
    }
    public static int MaxNum(int[] array){
        int max = array[0];
        for(int i=0;i<array.length;i++){
            if(array[i]>max){
                max = array[i];
            }
        }
        return max;
    }
}*/
//求数组中的最小值
/*public class TestDemo1{
    public static void main(String[] args){
        int[] array = {1,2,3,4};
        int min = MinNum(array);
        System.out.println(min);
    }
    public static int MinNum(int[] array){
        int min = array[0];
        for(int i=0;i<array.length;i++){
            if(array[i]<min){
                min = array[i];
            }
        }
        return min;
    }
}*/
//求数组中的平均值
/*public class TestDemo1{
    public static void main(String[] args){
        int[] array = {1,2,3,4};
        double avenum = AveNum(array);
        System.out.println(avenum);
    }
    public static double AveNum(int[] array){
        double avenum = 0;
        int sum = 0;
        for(int i=0;i<array.length;i++){
            sum += array[i];
        }
        avenum = sum/(array.length);
        return avenum;
        }
    }*/
//数组的逆置
/*public class TestDemo1{
    public static void main(String[] args){
        int[] array = {1,2,5,4};
        Opposit(array);

    }
    public static void Opposit(int[] array){
        int i = 0;
        int j = array.length-1;
        while(i<j){
            int tmp=array[i];
            array[i]=array[j];
            array[j]=tmp;
            j--;
            i++;
        }
        System.out.println(Arrays.toString(array));
    }
}*/
// 将数组中的奇数放到偶数前*****
/*public class TestDemo1{
    public static void main(String[] args){
        int[] array = {1,2,3,4,5};
        eveafterOdd(array);
        System.out.print(Arrays.toString(array)+" ");
    }
    public static void eveafterOdd (int[] array){
        int i = 0;
        int j = array.length-1;
        while(i<j) {
            if (i < j && array[i] % 2 != 0) {
                i++;         //i保存偶数的下标
            }
            if (i < j && array[j] % 2 == 0) {
                j--;     //j保存奇数的下标
            }

            if (i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
    }
}*/
//实现二分查找(递归)
/*public class TestDemo1{
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        int ret = binarySearch(array,3,0,3);
        System.out.println(ret);
    }
    public static int binarySearch(int[] array,int key,int left,int right){
        if(left>right){
            return -1;
        }
        int mid = (left+right)>>>1;
        if(array[mid]==key){
            return mid;
        }else if(array[mid]<key){
            left = mid;
            return binarySearch(array,key,mid+1,right);
        }else {
            return binarySearch(array, key, left, mid-1);
        }
    }
}*/

//函数库实现
/*public class TestDemo1{
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        int ret = Arrays.binarySearch(array,0,4, 10);//显示-5意思是10要插入从下标为4的位置返回-（要插入的位置）-1
        System.out.println(ret);
    }
}*/
//实现冒泡排序即冒泡排序的优化代码
/*public class TestDemo1{
    public static void main(String[] args) {
        int[] array =  {10,5,1,3,4};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
    //趟数
    public static void bubbleSort(int[] array){
    //每趟的次数
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    int tmp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                }
            }
        }

    }
}*/

//冒泡优化  ******
/*
public class TestDemo1{
    public static void main(String[] args) {
        int[] array =  {10,5,1,3,4};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void bubbleSort(int[] array){
        boolean flag = false;
        for(int i=0;i<array.length-1;i++){
            flag = false;//每趟都有可能有序
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    int tmp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                    flag = true;
                }
            }
            if(!flag){
                return;
            }
        }

    }
}
*/

//可变参数编程
/*
public class TestDemo1{
    public static void main(String[] args){
        System.out.println(Sum(1,2,3,4,5));
        System.out.println(Sum(1,2,3));
    }
    public static int Sum(int... array){
        int ret = 0;
        for(int x:array){
            ret += x;
        }return ret;
    }
}
*/

//匿名数组
//public class TestDemo1{
//    public static void main(String[] args){
//        System.out.println(Sum(new int[]{1,2,3,4,5,6}));  //这里创建了一个匿名数组
//    }
//    public static int Sum(int... array){
//        int ret = 0;
//        for(int x:array){
//            ret += x;
//        }return ret;
//    }
//}



