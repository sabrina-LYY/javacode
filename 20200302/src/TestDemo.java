import java.util.Scanner;
import java.util.Stack;

/*输入描述:

每组输入数据共两行。
第一行为字符串A
第二行为字符串B
字符串长度均小于100且只包含小写字母

输出描述:
输出一个数字，表示把字符串B插入字符串A之后构成一个回文串的方法数*/
public class TestDemo {
    public static boolean Ishuiwen(String str){
        int i=0;
        int len = str.length()-1;
        while(i<len){
            if(str.charAt(i) != str.charAt(len)){
                return false;
            }
            i++;
            len--;
        }
        return true;
    }
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       String A = scan.nextLine();
       String B = scan.nextLine();
       int lenA = A.length();
       int count = 0;

       for(int i=0;i<lenA;i++){
           StringBuilder str = new StringBuilder(A);
           str.insert(i,B);
           if(Ishuiwen(str.toString())){
               count++;
           }
       }
        System.out.println(count);
    }


/*有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。

给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。

测试样例：
[1,3,5,2,2],5,3
返回：2*/
    public int findKth(int[] a, int n, int K) {
        return QuickSort(a,0,n-1,K);
    }

    private  int QuickSort(int[] a,int start,int end,int k){
        int pivot = partion(a,start,end);
        if(k ==  pivot-start+1){
            return a[pivot];
        }else if(k > pivot-start+1){
            //在后半部分
            return QuickSort(a,pivot+1,end,k-(pivot-start+1));
        }else{
            //在前半部分
            return QuickSort(a,start,pivot-1,k);
        }
    }

    private  int partion(int[] a,int start,int end) {
        int tmp = a[start];
        while(start<end){
            //注意a[end] <=tmp
            while(start<end && a[end] <=tmp){
                end--;
            }
            if(start>=end){
                break;
            }else{
                a[start] = a[end];
            }
            //注意a[start]>=tmp
            while(start<end && a[start]>=tmp){
                start++;
            }
            if(start>=end){
                break;
            }else{
                a[end] = a[start];
            }
        }
        a[start] = tmp;
        return start;
    }
}



