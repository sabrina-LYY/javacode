import java.util.Arrays;
import java.util.Stack;

public class TestDemo {
    //冒泡排序
    public static void bubbleSort(int[] array){
        boolean flg = false;
        //趟数
        for(int i=0;i<array.length-1;i++){
            //每趟的次数
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]>array[j+1]){//稳定的，如果是>=则不稳定
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flg = true;
                }
            }
            if(!flg){
                break;
            }
        }
    }


    //快排
    public static int partion(int[] array,int start,int end){
        int tmp = array[start];
        while(start<end){
            while(start<end && array[end]>=tmp){//start<end是如果有序，end减的时候不能出界
                end--;
            }
            if(start>=end){
                //array[start] = tmp;
                break;
            }else{
                array[start] = array[end];
            }
            while(start<end && array[start]<=tmp){
                start++;
            }
            if(start>=end){
                //array[start] = tmp;
                break;
            }else{
                array[end] = array[start];
            }
        }
        array[start] = tmp;
        return start;
    }


    public static void swap(int[]array,int low,int high){
        int tmp = array[low];
        array[low] = array[high];
        array[high] = tmp;
    }
    public static void ThreeNumOfMiddle(int[] array,int low,int high){
        //array[mid]<=array[low]<=array[high]
        int mid = (low+high)/2;
        if(array[mid]>array[high]){
            swap(array,mid,high);
        }
        if(array[mid]>array[low]){
            swap(array,mid,low);
        }
        if(array[low]>array[high]){
            swap(array,low,high);
        }

    }
    public static void insertSort(int[] array,int low,int high){
        for(int i=low+1;i<array.length;i++){
            int tmp = array[i];
            int j = 0;
            for(j=i-1;j>=low;j--){
                if(array[j]>tmp){
                    array[j+1] = array[j];
                }else{
                    break;
                }
                array[j+1] = tmp;
            }
        }
    }
    public static void quick(int[] array,int low,int high){
        //if(low == high) {} 两相遇有一个元素
        //if(low > high) {} 右边的情况
        if(low>=high){
            return;
        }

        //优化方式一
        if(high-low+1<100){
            insertSort(array,low,high);
            return;
        }
        //优化方式二
        ThreeNumOfMiddle(array,low,high);


        //写一个函数将数组分为两部分
        int pivot = partion(array,low,high);
        //递归，左，右
        quick(array,low,pivot-1);
        quick(array,pivot+1,high);
    }

    //用栈实现
    public static void quick2(int[] array,int low,int high){
        int pivot = partion(array,low,high);
        Stack<Integer> stack = new Stack<>();
        //要保证pivot的左右两边的数字个数都大于2
        if(pivot>low+1){
            stack.push(low);
            stack.push(pivot-1);
        }
        if(pivot<high-1){
            stack.push(pivot+1);
            stack.push(high);
        }
        while(!stack.empty()){
            high = stack.pop();
            low = stack.pop();
            pivot = partion(array,low,high);
            if(pivot>low+1){
                stack.push(low);
                stack.push(pivot-1);
            }
            if(pivot<high-1){
                stack.push(pivot+1);
                stack.push(high);
            }
        }
    }

    public static void quickSort(int[] array){

        quick(array,0,array.length-1);
    }



    public static void main(String[] args) {
        int[] array = {8,6,3,9,4,7};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));

        quickSort(array);
        System.out.println(Arrays.toString(array));

    }

}

