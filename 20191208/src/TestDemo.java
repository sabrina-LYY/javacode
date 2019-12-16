import java.util.*;


public class TestDemo {
    public static void main4(String[] args) {

        MyArrayList<String> myArrayList = new MyArrayList<>();

        myArrayList.add("java");
        myArrayList.add("2019");

        String ret = myArrayList.get();
        System.out.println(ret);

        MyArrayList<Integer> myArrayList1 = new MyArrayList<>();
        myArrayList1.add(1);
        myArrayList1.add(2);
    }


    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("java");
        myArrayList.add(2);
        myArrayList.add(0.3);

        double ret = (double)myArrayList.get();
        System.out.println(ret);
    }




    public static void main2(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("及时雨","宋江");
        map.put("黑旋风","李逵");
        System.out.println(map);

        String str = map.get("及时雨");
        System.out.println(str);

        //找到打印，找不到打印默认值
        String str2 = map.getOrDefault("及时雨2","abc");
        System.out.println(str2);

        System.out.println(map.containsKey("黑旋风"));
        System.out.println(map.isEmpty());
        System.out.println(map.size());

        //for each打印元素
        for(Map.Entry<String,String> entry : map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }



    public static void main1(String[] args) {
        //ArraysList中只能放字符串
        Collection<String> collection = new ArrayList<>();
        collection.add("java");
        collection.add("hello");
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());
        System.out.println(collection);
        collection.remove("java");
        System.out.println(collection);

        collection.add("2019");
        collection.add("1208");
        Object[] strings = collection.toArray();
        System.out.println(Arrays.toString(strings));

        //一个类只有实现了Interable接口，才能使用for each
        for(String s:collection){
            System.out.print(s+" ");
        }
        System.out.println();
    }
}
