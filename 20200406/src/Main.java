import java.util.*;
public class Main {
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String a = in.nextLine();
            Stack<String> stack = new Stack<>();
            String[] str = a.split(" ");
            for(int i=0;i<str.length;i++){
                stack.push(str[i]);
            }
            while(!stack.isEmpty()){
                System.out.print(stack.peek());
                stack.pop();
                System.out.print(" ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<String,Integer> map = new HashMap<>();
        while (in.hasNext()) {
            String str = in.nextLine();
            int index = str.lastIndexOf("\\");
            //看是不是净文件名
            if(index!=-1){
                //如果有/则表示不是净文件名
                str = str.substring(index+1);//从/往后
            }
            if(map.containsKey(str)){
                map.put(str,map.get(str)+1);
            }else{
                map.put(str,1);
            }

           /* Set<String> set = map.keySet();
            int count = 0;
            for(String tmp:set){
                count++;
                if(count>(set.size()-8)){//从count往后，计算后8条
                    String[] s = tmp.split(" ");
                    int len  = s[0].length();//s[0]是文件名
                    if(len>16){
                        s[0] = s[0].substring(len-16);
                    }
                    //取得行号
                    int Line = Integer.parseInt(s[1]);
                    int number = map.get(tmp);//取得此错误记录的条数
                    System.out.println(s[0]+"　"+Line+" "+number);

                }*/



            List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });
            for (int i = 0; i < 8; i ++) {
                String[] split = list.get(i).getKey().split("\\s");
                if(split[0].length() > 16) {
                    split[0] = split[0].substring(split[0].length() - 16);
                }
                System.out.println(split[0] + " " + split[1] + " " + list.get(i).getValue());
            }

        }
    }
}