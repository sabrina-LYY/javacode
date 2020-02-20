

//堆就是优先级队列PriorityQueue
import java.util.*;

public class TestDemo {
    //时间复杂度O(n+klogk)
    //空间复杂度O(k)

    //10万个数字中找出前K个最大数
    public static Integer[] findKNum(int [] array,int k){
        //1.建立大小为K的堆（小堆）
        PriorityQueue<Integer> minHeap = new PriorityQueue<>
                (k, new Comparator<Integer>() {
                    //比较器，比较，调整的时候使用
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);//升序进行，即小堆

            }
        });
        for(int i=0;i<array.length;i++){
            if(minHeap.size()<k){//先放K个元素
                minHeap.add(array[i]);
            }else{
                Integer top = minHeap.peek();
                if(top!=null && top <array[i]){
                    minHeap.poll();
                    minHeap.add(array[i]);
                }
            }
        }


        //堆里放的就是最大的k个元素，放进数组返回即可
        Integer[] integers = new Integer[k];
        for(int i=0;i<k;i++){
            Integer top = minHeap.peek();
            integers[i] = top;
            minHeap.poll();
        }
        return integers;
    }



    //找前K个最小的数
    public static Integer[] findKminNum(int [] array,int k){
        //1.建立大小为K的堆（大堆）
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>
                (k, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2.compareTo(o1);//升序进行，即小堆

                    }
                });
        for(int i=0;i<array.length;i++){
            if(maxHeap.size()<k){//先放K个元素
                maxHeap.add(array[i]);
            }else{
                Integer top = maxHeap.peek();
                if(top!=null && top >array[i]){
                    maxHeap.poll();
                    maxHeap.add(array[i]);
                }
            }
        }

        //堆里放的就是最大的k个元素，放进数组返回即可
        Integer[] integers = new Integer[k];
        for(int i=0;i<k;i++){
            Integer top = maxHeap.peek();
            integers[i] = top;
            maxHeap.poll();
        }
        return integers;
    }




    //给一非空的单词列表，返回前 k 个出现次数最多的单词。
    //返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
    public static List<String> topKFrequent(String[] words, int k) {
        //1.遍历words数组，将单词和出现的次数一一对应
        Map<String,Integer>map = new HashMap<>();
        for(String s:words){
            //首先看当前字符串S是否已经在map中有对应关系
            if(map.get(s)==null){
                map.put(s,1);
            }else{
                map.put(s,map.get(s)+1);
            }
        }

        //用小堆
        PriorityQueue<Map.Entry<String,Integer>> minHeap1 = new PriorityQueue<>
                (k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                //如果频率相同，按字母顺序返回
                if(o1.getValue().equals(o2.getValue())){
                    //O2的值>O1的值，就进行调整（交换）
                    return o2.getKey().compareTo(o1.getKey());
                }
                return o1.getValue().compareTo(o2.getValue());//频率升序
            }
        });
        //entrySet返回所有KEY,VALUE组合
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(minHeap1.size()<k){
                minHeap1.add(entry);
            }else {
                Map.Entry<String, Integer> top = minHeap1.peek();
                //频率相同
                if (top != null && top.getValue().equals(entry.getValue())) {
                    if (top.getKey().compareTo(entry.getKey()) > 0) {//(entry.getKey()小
                        minHeap1.poll();
                        minHeap1.add(entry);
                    }
                } else {
                    if (top != null && top.getValue() < entry.getValue()) {//entry频率大
                        minHeap1.poll();
                        minHeap1.add(entry);
                    }
                }
            }
        }
        System.out.println(minHeap1);
        List<String> list = new ArrayList<>();
        for(int i=0;i<k;i++){
            String pop = minHeap1.peek().getKey();//堆顶的字符串
            list.add(0,pop);
            minHeap1.poll();
        }
        return list;
    }

    public static void main(String[] args) {
        int[] array = {15,87,5,7,2,78,45,21};
        Integer[] ret = findKNum(array,4);
        System.out.println(Arrays.toString(ret));
        Integer[] ret2 = findKminNum(array,4);
        System.out.println(Arrays.toString(ret2));
    }
}
