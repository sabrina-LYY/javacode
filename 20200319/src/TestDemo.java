import java.util.*;
public class TestDemo {
    //洗牌
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int T = in.nextInt();
            int n = in.nextInt();
            int k = in.nextInt();
            int[] pai = new int[2*n];
            for(int i=0;i<2*n;i++){
                pai[i] = in.nextInt();
            }
            Stack<Integer> stack = new Stack<>();
            while(k>0){
                func(pai,pai.length,n);
                k--;
            }
            while(!stack.isEmpty()){
                if(stack.size()>=1){
                    System.out.print(stack.peek()+" ");
                }else{
                    System.out.print(stack.peek());
                }
                stack.pop();
            }
        }
    }
    public static void func(int[]pai,int length,int n){
        Stack<Integer> stack = new Stack<>();
        int len = length;
        for(int i=0;i<pai.length;i++){
            if(n>=0 && len-1>n-1){
                stack.push(pai[len-1]);
                stack.push(pai[n-1]);
                len--;
                n--;
            }

        }
    }

    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int N = in.nextInt();
            int[] score = new int[N];
            for(int i=0;i<N;i++){
                score[i] = in.nextInt();
            }
            int sco = in.nextInt();
            HashMap<Integer,Integer> map = new HashMap<>();
            while(N!=0){
                for(int i=0;i<N;i++){
                    if(score[i]==sco){
                        if(map.containsKey(sco)){
                            map.put(sco,map.get(sco)+1);
                        }else{
                            map.put(sco,1);
                        }
                    }
                }
                Set<Map.Entry<Integer, Integer>> entry = map.entrySet();

                for(Map.Entry<Integer, Integer> e : entry) {
                    System.out.println(e.getValue());
                }
            }
        }
    }
}
