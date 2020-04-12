import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Character,Integer> map = new HashMap<>();
        while (in.hasNext()) {
            String str = in.next();
            for(int i=0;i<str.length();i++){
                char c = str.charAt(i);
                if(c>='A' && c<='Z'){
                    if(map.containsKey(c)){
                        map.put(c,map.get(c)+1);
                    }else{
                        map.put(c,1);
                    }
                }
            }


            for(char j='A';j<='Z';j++) {
                System.out.print(j+":");
                if (map.containsKey(j)) {
                    System.out.println(map.get(j).intValue());
                } else {
                    System.out.println(0);
                }

                }

        }
    }
}