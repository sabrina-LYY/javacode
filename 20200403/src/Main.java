import java.util.Scanner;

/*
给定一个有n个正整数的数组A和一个整数sum,
求选择数组A中部分数字和为sum的方案数。
当两种选取方案有一个数字的下标不一样,我们就认为是不同的组成方案。

输入描述:
输入为两行:
 第一行为两个正整数n(1 ≤ n ≤ 1000)，sum(1 ≤ sum ≤ 1000)
 第二行为n个正整数A[i](32位整数)，以空格隔开。
 输出：方案数*/
public class Main {
    //动态规划问题
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int sum = in.nextInt();
            int[] A = new int[n];
            for(int i=0;i<n;i++){
                A[i] = in.nextInt();
            }
            long[][] dp = new long[n+1][sum+1];//dp[i][j]表示前i个数组成和为j的个数
            for(int i=0;i<=n;i++){
                dp[i][0] = 1;//组成和为0只有一种方法，全不选
            }
            for(int j=1;j<=sum;j++){
                dp[0][j] = 0;//前0个数组成和为j 的个数为0；
            }
            for(int i=1;i<=n;i++){
                for(int j=1;j<=sum;j++){
                    if(A[i-1]<=j){
                        dp[i][j] = dp[i-1][j]+dp[i-1][j-A[i-1]];
                        //前i-1个数凑到j   +     用前i-1个数凑到j-A[i-1]，需要第i个数才能凑到j
                    }else{
                        dp[i][j] = dp[i-1][j];//前i-1个数就能组成j
                    }
                }
            }
            System.out.println(dp[n][sum]);
        }
    }
}
