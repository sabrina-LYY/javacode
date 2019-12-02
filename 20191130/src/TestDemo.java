import java.util.Scanner;

public class TestDemo {
    public static String func(String str,int k){
        if(str==null|| k<=0||str.length()==0){
            return null;
        }
        str = reverse(str,0,k-1);//前k个进行逆置
        str = reverse(str,k,str.length()-1);//剩下的进行逆置
        str = reverse(str,0,str.length()-1);//整体逆置
        return str;
    }

    public static String reverse(String str,int start,int end){
        char[] array =str.toCharArray();
        while(start<end){
            char tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
            start++;
            end--;
        }
        return String.copyValueOf(array);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){//hasNext循环读入，判断是否有下一个
            int k = scan.nextInt();//nextInt下一句不能有nextLine
            String str = scan.next();
            String ret = func(str,k);
            System.out.println(ret);
        }
    }

    //将字符串逆置
    public static String reverse(String str){
        char[] array =str.toCharArray();
        int left = 0;
        int right = array.length-1;
        while(left<right){
            char tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
        return String.copyValueOf(array);
    }
    public static void main2(String[] args) {
        String str = "abcdef";
        System.out.println(reverse(str));
    }

    public static String func(String str){
        String[] str1 = str.split(",");
        String ret = "";
        StringBuilder sb = new StringBuilder();
        for(String str2:str1){//foreach在str1中遍历String类型
           sb.append(str2);
        }
        /*for(String str2:str1){//foreach在str1中遍历String类型
            ret+=str2;
        }*/
        return ret;
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String str2 = func(str);
        System.out.println(str2);
    }
}
