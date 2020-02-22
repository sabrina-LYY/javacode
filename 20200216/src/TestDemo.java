import java.util.Arrays;

public class TestDemo {
    //归并排序
    /*public static void mergeSortInternal(int[] array,int low,int high){

        int mid = (low+high)/2;
        mergeSortInternal(array,low,mid);
        mergeSortInternal(array,mid+1,high);
    }
    public static void mergeSort(int[] array){
        mergeSortInternal(array,0,array.length-1);
    }
*/
    //冒泡排序
    public static void BubbleSort(int[] array){
        boolean flag = false;
        //趟数
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    int tmp = array[j];
                    array[j]=array[j+1];
                    array[j+1] = tmp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
    }

    public static void insertSort(int[] array,int low,int high){
        for(int i=low+1;i<=high;i++){
            int tmp = array[i];
            int j=0;
            for(j=i-1;j>=low;j++){
                if(array[j]>tmp){
                    array[j+1] = array[j];
                }else{
                    break;
                }
            }
            array[j+1]=tmp;
        }
    }

    //快排 时间复杂度O（nlog2n）  空间复杂度 O（log2n）  不稳定
    public static void QuickSort(int[] arr){
        quick(arr,0,arr.length-1);

    }
    public static void quick(int[]arr,int low,int high){
        if(low>=high){
            return;
        }
        //优化方式一
        if(high-low+1<100){
            insertSort(arr,low,high);
            return;
        }

        int pivot = partion(arr,low,high);
        quick(arr,low,pivot-1);
        quick(arr,pivot+1,high);
    }
    public static int partion(int [] arr,int start,int end) {
        int tmp = arr[start];
        while(start<end){
            while((start<end)&&arr[end]>=tmp){
                end--;
            }
            if(start>=end){
                arr[start] = tmp;
                break;
            }else{//arr[end]<tmp
                arr[start] = arr[end];
            }
            while((start<end)&&arr[start]<=tmp){
                start++;
            }
            if(start>=end){
                arr[start] = tmp;
                break;
            }else{//arr[end]<tmp
                arr[end] = arr[start];
            }
        }
        return start;
    }

    //堆排
    public static void AdjustDown(int[] array,int root,int len){
        int parent = root;
        int child = 2*parent+1;
        while(child < len){
            if(child+1 <len && array[child] <array[child+1]){
                child++;
            }

            //child保存的是最大值得下标
            if(array[child] >array[parent]){
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
                parent = child;
                child = 2*parent+1;
            }else{
                break;
            }
        }


    }
    public static void CreateHeap(int[]array){
        for(int i=(array.length-1-1)/2;i>=0;i--){
            AdjustDown(array,i,array.length);
        }
    }

    public static void heapSort(int[] array){
        CreateHeap(array);
        int end = array.length-1;
        while(end>0){
            int tmp = array[end];
            array[end] = array[0];
            array[0] = tmp;
            AdjustDown(array,0,end);
            end--;
        }
    }



    //归并排序（递归形式）
    public static void merge(int[]array,int low,int mid,int high){
        int[] tmpArr = new int[high-low+1];
        int s1 = low;
        int s2 = mid+1;
        int i=0;
        while(s1<=mid && s2<=high){//两个归并段都有数据
            if(array[s1]<=array[s2]){
                tmpArr[i++] = array[s1++];
            }else{
                tmpArr[i++] = array[s2++];
            }
        }
        while(s1<=mid){
            tmpArr[i++]=array[s1++];
        }
        while(s2<=high){
            tmpArr[i++]=array[s2++];
        }
        //tmpArr里存放的是有序数据
        //要将有序数据放到Arr中
        for(int j=0;j<tmpArr.length;j++){
            array[low+j] = tmpArr[j];
        }

    }
    public static void mergeSortInternal(int[] array,int low,int high){
        if(low>=high){
            return;//表示已经分为一个个的数
        }
        int mid = (low+high)/2;
        mergeSortInternal(array,low,mid);
        mergeSortInternal(array,mid+1,high);

        //开始合并
        merge(array,low,mid,high);

    }

    public static void mergeSort(int[] array){
        mergeSortInternal(array,0,array.length-1);
    }


    //归并非递归
    public static void mergeSort2(int[] array){
        for(int i=1;i<array.length;i*=2){//每组归并，2个，4个，8个等
            merge1(array,i);
        }
    }
    //gap代表每个归并段的数据
    public static void merge1(int[] array,int gap){
        int[] tmpArr = new int[array.length];
        int k=0;//下标
        int s1 = 0;
        int e1 = s1 + gap-1;
        int s2 = e1+1;
        int e2 = s2+gap-1<array.length?s2+gap-1:array.length-1;

        while(s2<array.length){
            while(s1<=e1 && s2<=e2){//两个归并段都有数据
                if(array[s1]<=array[s2]){
                    tmpArr[k++] = array[s1++];
                }else{
                    tmpArr[k++] = array[s2++];
                }
            }
            while(s1<=e1){
                tmpArr[k++] = array[s1++];
            }
            while(s2<=e2){
                tmpArr[k++] = array[s2++];
            }
            s1 = e2+1;
            e1 = s1+gap-1;
            s2 = e1+1;
            e2 = s2+gap-1<array.length?s2+gap-1:array.length-1;
        }
        //判断是否还有归并段，且这个段一定是s1,直接<e1可能会越界
        while(s1<array.length){
            tmpArr[k++] = array[s1++];
        }
        for(int i=0;i<array.length;i++){
            array[i] = tmpArr[i];
        }
    }


    public static void main(String[] args) {
        int[] array = {7,99,1,8,6,9,18,5};
        //BubbleSort(arr);
        //QuickSort(arr);
        //mergeSort(arr);
        mergeSort2(array);
        System.out.println(Arrays.toString(array));
    }

}


