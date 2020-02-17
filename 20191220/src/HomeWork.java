import java.util.*;

public class HomeWork {

    //棒球比赛
    /*输入: ["5","2","C","D","+"]
    输出: 30
    解释:
    第1轮：你可以得到5分。总和是：5。
    第2轮：你可以得到2分。总和是：7。
    操作1：第2轮的数据无效。总和是：5。
    第3轮：你可以得到10分（第2轮的数据已被删除）。总数是：15。
    第4轮：你可以得到5 + 10 = 15分。总数是：30。*/
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for(String s:ops){
            if(s.equals("C")){
                stack.pop();
            }else if(s.equals("D")){
                stack.push(2*stack.peek());
            }else if(s.equals("+")){
                int pre = stack.pop();
                int num = stack.peek();
                stack.push(pre);
                stack.push(pre+num);
            }else{
                stack.push(Integer.valueOf(s));
            }
        }
        int res=0;
        for(Integer score:stack){
            res += score;
        }
        return res;
    }


    //给定 S 和 T 两个字符串，
    // 当它们分别被输入到空白的文本编辑器后，判断二者是否相等，
    // 并返回结果。 # 代表退格字符。
    public Stack getstack(String str){
        char[] arr = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i] != '#'){
                stack.push(arr[i]);
            }else if(arr[i] =='#'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
        }
        return stack;
    }
    public boolean backspaceCompare(String S, String T) {
        return getstack(S).equals(getstack(T));
    }



    //栈的压入、弹出序列
/*输入两个整数序列，第一个序列表示栈的压入顺序，
请判断第二个序列是否可能为该栈的弹出顺序。
（注意：这两个序列的长度是相等的）*/
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        //思路：入栈1,2,3,4,5，出栈4,5,3,2,1
        //首先1入辅助栈，此时栈顶1≠4，继续入栈2
        //此时栈顶2≠4，继续入栈3
        //此时栈顶3≠4，继续入栈4
        //此时栈顶4＝4，出栈4，弹出序列向后一位，此时为5，,辅助栈里面是1,2,3
        //此时栈顶3≠5，继续入栈5
        //此时栈顶5=5，出栈5,弹出序列向后一位，此时为3，,辅助栈里面是1,2,3
        //….
        //依次执行，最后辅助栈为空。如果不为空说明弹出序列不是该栈的弹出顺序。
        if(pushA == null && popA == null){
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int popIndex = 0;

        for(int i = 0;i<pushA.length;i++){
            stack.push(pushA[i]);
            while(!stack.isEmpty() && stack.peek()==popA[popIndex]){
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }


    //根据逆波兰表示法，求表达式的值。
    //
    //有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
    //说明：
    //整数除法只保留整数部分。
    //给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int num1 = 0;
        int num2 = 0;
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+")){
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2+num1);
            }else if(tokens[i].equals("-")){
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2-num1);
            } else if(tokens[i].equals("*")){
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2*num1);
            } else if(tokens[i].equals("/")){
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2/num1);
            }else{
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }


    //编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
    //今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
    //例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
    class StackElement{
        public int price;
        public int span;
    }
    class StockSpanner {
        public Stack<StackElement> stack = new Stack<>();
        public StockSpanner() {

        }
        public int next(int price) {
            int count = 1;
            while(!stack.isEmpty() && stack.peek().price<=price){
                StackElement top = stack.pop();
                count+=top.span;
            }
            StackElement stackElement = new StackElement();
            stackElement.price = price;
            stackElement.span = count;
            stack.push(stackElement);
            return count;
        }
    }

    //写一个 RecentCounter 类来计算最近的请求。
    //它只有一个方法：ping(int t)，其中 t 代表以毫秒为单位的某个时间。
    //返回从 3000 毫秒前到现在的 ping 数。
    //任何处于 [t - 3000, t] 时间范围之内的 ping 都将会被计算在内，包括当前（指 t 时刻）的 ping。
    //保证每次对 ping 的调用都使用比之前更大的 t 值。
    class RecentCounter {
        public Queue<Integer> queue;

        public RecentCounter() {
            queue = new LinkedList<>();
        }
        public int ping(int t) {
            queue.offer(t);
            while(t-queue.peek()>3000){
                queue.poll();
            }
            return queue.size();
        }
    }


    //约瑟夫问题是一个著名的趣题。
    // 有n个人站成一列。并从头到尾给他们编号，第一个人编号为1。
    // 然后从头开始报数，第一轮依次报1，2，1，2...然后报到2的人出局。
    // 接着第二轮再从上一轮最后一个报数的人开始依次报1，2，3，1，2，3...报到2，3的人出局。
    // 以此类推直到剩下以后一个人。现在需要求的即是这个人的编号。
    //给定一个int n，代表游戏的人数。请返回最后一个人的编号
    public int getResult(int n) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=1;i<=n;i++){
            list.add(i);//将n个数加入到列表中
        }
        while(list.size()>1){
            
        }
    }

}





