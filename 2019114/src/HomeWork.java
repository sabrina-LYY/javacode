public class HomeWork {
    public static void main(String[] args) {
        /*String str = toLowerCase("Hello");
        System.out.println(str);
*/
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums,1);
    }


    public static String toLowerCase(String str) {
        char[] arr = str.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i]>='A' && arr[i] <='Z'){
                arr[i]+=32;
            }
        }
        return new String(arr);
    }

    public static void rotate(int[] nums, int k) {
        for(int i=1;i<=k;i++){
            int j=0;
            while(j<nums.length){
                int l = nums[nums.length-1];
                nums[j+1] = nums[j];
                nums[0] = l;
            }
        }
    }


}
