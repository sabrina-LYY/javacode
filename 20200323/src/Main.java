
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    //给定一个正整数N代表火车数量，0<N<10，接下来输入火车入站的序列，
    // 一共N辆火车，每辆火车以数字1-9编号。要求以字典序排序输出火车出站的序列号。
    // 输入
    // 3
    // 1 2 3
    // 输出：
    // 1 2 3
    // 1 3 2
    // 2 1 3
    // 2 3 1
    // 3 2 1
 public static void main(String[] args) {
     Scanner in = new Scanner(System.in);
     while (in.hasNext()) {
         //输入火车数量
         int n = in.nextInt();
         // 输入火车编号
         int[] A = new int[n];
         for(int i=0;i<n;i++){
             A[i] = in.nextInt();
         }
         int start = 0;
         //计算n个火车的出站的编号的排列组合
         ArrayList<int[]> result = new ArrayList<int[]>();
         Permutation(A,start,n,result);
         //出栈的结果，一个元素一个记录，例如：1 2 3 ； 1 3 2
         Set<String> sortResult = new TreeSet<String>();
         //循环排列组合
         for(int[] out : result){
             //判断是否满足出栈要求（后进先出）
             if(isLegal(A,out,n)){
                 //满足的组合，输入结果，每一个编号用空格分隔
                 StringBuilder sb = new StringBuilder();
                 for(int i=0;i<n-1;i++){
                     sb.append(out[i]+" ");
                 }
                 sb.append(out[n-1]);
                 sortResult.add(sb.toString());
             }
         }
         //最后输出所有的符合出栈要求的组合
         for(String list:sortResult){
             System.out.println(list);
         }
     }in.close();
 }
 /*in : 火车编号数组 out : 火车出站顺序 n : 火车数量 */
 private static boolean isLegal(int[] in,int[] out,int n){
     //栈：存储进站的火车编号
     LinkedList<Integer> stack = new LinkedList<Integer>();
     int i=0; int j=0;
     while(i<n){
         // in 还有元素的时候都需要判断
         if(in[i] == out[j]){
             //相等时候就不用入栈，直接后移
             i++; j++;
         }else {
             if (stack.isEmpty()) {
                 //空stack 就只有入栈了
                 stack.push(in[i]);
                 i++;
             } else {
                 int top = stack.peek();
                 // 栈顶元素相等，进行出栈
                 if (top == out[j]) {
                     j++;
                     stack.pop();
                 } else if (i < n) {
                     stack.push(in[i]);
                     i++;
                 }
             }
         }
     }
     while(!stack.isEmpty() && j<n){
         // in 的结束后，栈中元素进程出栈序列应该和out剩余的元素相同
         int top = stack.pop();
         if(top == out[j]){
             j++;
         }else{
             return false;
         }
     }
     return true;
 }
 /*** 求出所有排列* @param A* @param start* @param n* @param result*/
 private static void Permutation(int[] A,int start,int n,ArrayList<int[]>result){
     if(start == n){
         return;
     }if(start == n-1){
         int[] B = A.clone();
         result.add(B);
         return;
     }for(int i=start;i<n;i++){
         swap(A,start,i);
         Permutation(A,start+1,n,result);
         swap(A,start,i);
     }
 }
 private static void swap(int[] A,int i,int j){
     int t = A[i];
     A[i] = A[j];
     A[j] = t;
 }
}
