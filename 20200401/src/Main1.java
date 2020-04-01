import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int num = in.nextInt();
            String[] name = new String[num];
            HashMap<String,Integer>map = new HashMap<>();

            for(int i=0;i<name.length;i++){
                name[i] = in.next();
                map.put(name[i],0);
            }
            int voteNum = in.nextInt();
            String[] vote = new String[voteNum];
            map.put("Invalid",0);
            for(int i=0;i<vote.length;i++){
                vote[i] = in.next();
                if(map.containsKey(vote[i])){
                    map.put(vote[i],map.get(vote[i])+1);
                }else{
                    map.put("Invalid",map.get("Invalid")+1);
                }
            }

            for(Map.Entry<String,Integer> entry:map.entrySet()){
                System.out.println(entry.getKey()+":"+entry.getValue());
            }
        }


    }
}