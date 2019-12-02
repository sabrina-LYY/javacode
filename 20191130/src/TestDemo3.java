import java.util.Arrays;

public class TestDemo3 {




    //3、题目： i am student 逆置 为  student  am i
    public static void reverse(char[] array,int start,int end){
        while(start<end){
            char tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
            start++;
            end--;
        }
    }
    public static String reverseSentence(String str){
        char[] array = str.toCharArray();
        reverse(array,0,array.length-1);
        int i=0;
        int j=0;
        //单词逆置
        while(i<array.length){
            if(array[i]==' '){//如果最前面有空格
                i++;
                j++;
            }else if(j==array.length || array[j]==' '){
                reverse(array,i,j-1);
                i=++j;
            }else{
                j++;
            }
        }
        return String.copyValueOf(array);
    }
    public static void main(String[] args) {
        String ret = reverseSentence("i am student.");
        System.out.println(ret);
    }
    //2、字符串转化（压缩）   “aabbccdaa” -> "2a2b2c1d2a"
    public static String func(String str){
        char ch = str.charAt(0);
        int repCount = 1;//重复的次数
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==ch){
                repCount++;
            }else{
                sb.append(repCount).append(ch);
                ch = str.charAt(i);
                repCount = 1;
            }
        }
        return sb.append(repCount).append(ch).toString();
    }
    public static void main2(String[] args) {
        String str ="aabbccdaa";
        System.out.println(func(str));
    }

    //合并两个有序数组 如
    // int[] array1 = {1,3,6,9}
    // int[] array2 = {2,4,6,8},
    // 结果为1,2,3,4，6,8,9
    public static int[] mergeArray(int[] array1,int[] array2){
        int i=0;
        int j=0;
        int k=0;
        int[] array = new int[array1.length+array2.length];
        while(i<array1.length && j<array2.length && k<array.length){
            if(array1[i]<=array2[j]){
                array[k++] = array1[i++];

            }else{
                array[k++]=array2[j++];
            }
        }
        while(i<array1.length){
            array[k++] = array1[i++];
        }
        while(j<array2.length){
            array[k++] = array2[j++];
        }
        return array;
    }
    public static void main1(String[] args) {
        int[] array1 = {1,3,6,9};
        int[] array2 = {2,4};
        int[] array = mergeArray(array1,array2);
        System.out.println(Arrays.toString(array));
    }
}
