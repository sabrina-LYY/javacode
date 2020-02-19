
import java.util.*;

public class TestDemo1 {

    /*Map:key不能重复*/
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"ad");
        map.put(2,"df");
        map.put(3,"eq");
        String s = map.get(2);

        s = map.getOrDefault(40,"hahah");
        System.out.println(map);
        System.out.println(s);

        String s1 = map.remove(40);
        System.out.println(map);
        System.out.println(s1);

        Set<Integer> set = map.keySet();
        System.out.println(set);//获取键

        Collection<String>collection = map.values();
        System.out.println(collection);//获取值


        //Map.Entry()返回set集合
        for(Map.Entry<Integer,String> entrySet:map.entrySet()){
            System.out.println(entrySet.getKey()+" "+entrySet.getValue());
        }


        //SET（集合）只能存Key 是纯Key模型,key不能重复，可以为null

        Set<Integer> set1 = new HashSet<>();

        set1.add(1);
        set1.add(5);
        set1.add(6);
        System.out.println(set1);

        //迭代器：用来遍历集合中的元素
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
