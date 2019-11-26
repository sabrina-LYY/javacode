
public class TestDemo2 {
    public static void main(String[] args) {
        byte[] bytes = {97,98,99,100};
        String str = new String(bytes);
        System.out.println(str);
    }

    public static void main1(String[] args) {
        String str = "1a23456";
        System.out.println(isNumber(str));
    }
        public static boolean isNumber(String str) {
            // 给定字符串一个字符串, 判断其是否全部由数字所组成.
            int i=0;
            for(i=0;i<str.length();i++){
                if(str.charAt(i)<'0'||str.charAt(i)>'9'){
                        return false;
                    }
            }
            return true;
        }

       /* char[] array = {'a','b','c'};
        String str1 = new String (array);
        System.out.println(str1);
        String str2 = new String (array,2,1);//从2号位置拷贝1个
        System.out.println(str2);
        String str = "Hello";
        char[] array = str.toCharArray();
        System.out.println(Arrays.toString(array));//字符串转换为字符*/
}

