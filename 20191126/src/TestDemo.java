import java.lang.reflect.Field;

public class TestDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String str = "abcd";
        str = "def";
        System.out.println(str);//"abcd"会被垃圾回收器回收掉

        //通过反射修改Hello为hello
        String str1 = "Hello";
        Class cls = String.class;//获取class对象
        Field field = cls.getDeclaredField("value");
        //将这个字段的访问属性设置为true
        field.setAccessible(true);
        //把str中的value属性获取到
        char[] value = (char[]) field.get(str);
        value[0] = 'h';
        System.out.println(str);
    }

    //public native String intern()  是native方法
    public static void main4(String[] args) {
        String str1 = "abcdef";//直接赋值,存放在常量池的字符串
        String str2 = new String("abcdef").intern();
        System.out.println(str1==str2);//true
    }
    public static void main3(String[] args) {
        String str1 = "abcdef";//直接赋值,存放在常量池的字符串
        String str2 = new String("abcdef");
        System.out.println(str1==str2);
        String str3 = "abc"+"def";//abc字符串常量，常量在编译期间已经处理为abcdef，而常量池中已经存在了str1中的abcdef,所以只用了str1这一份
        System.out.println(str1==str3);//true，
        String str4 = "abc"+new String("def");//new的是堆上的value指向常量池的def
        System.out.println(str1==str4);//false
        String str5 = "abc";
        String str6 = "def";
        String str7 = str5+str6;//会在堆上拼接一个新的常量，str7指向。
        System.out.println(str1==str7);//false
        String str8 = str5+new String("def");
        System.out.println(str1==str8);//false
        System.out.println(str4==str8);//false
    }

    public static void main2(String[] args) {
        String str = "abcdef";//直接赋值
        String str2 = new String("abcdef");
        System.out.println(str==str2);//结果为false,比较的是引用的地址

        System.out.println(str.equals(str2));//equals比较的是内容，结果为true

        char[] array = {'a','b','c'};
        String str3 = new String (array);
        System.out.println(str==str3);//结果为false,new的在堆上不在常量池
    }

    public static void main1(String[] args) {
        String str = "abcdef";//直接赋值
        String str2 = new String("abcdef");
        char[] array = {'a','b','c'};
        String str3 = new String (array);
        System.out.println(str);
        System.out.println(str2);
        System.out.println(str3);
    }
}
