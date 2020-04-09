import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int rich = 0;
        int poor = 0;
        for(int i=0;i<30;i++){
            poor+=1;
            rich+=10;
        }
        System.out.println(rich+" "+poor);
    }

//风口的猪-中国牛市   牛客
    public class Solution {
        /**
         * 计算你能获得的最大收益
         *
         * @param prices Prices[i]即第i天的股价
         * @return 整型
         */
        public int calculateMax(int[] prices) {
            int firstBuy =Integer.MIN_VALUE;//第一次买的价格
            //以下都是收益
            int ProfirstSell = 0;
            int ProSecondBuy = Integer.MAX_VALUE;
            int ProSecondSell = 0;

            for(int cur:prices){
                //第一次买入的价格越小越好
                firstBuy = Math.min(firstBuy,-cur);
                //第一次卖出的收益越多越好，当前价格和买入价格的和
                ProfirstSell = Math.max(ProfirstSell,cur-firstBuy);
                //第二次买入的收益，第一次卖出的收益和当前价格的差
                ProSecondBuy = Math.max(ProSecondBuy,ProfirstSell-cur);
                //第二次卖出，第二次买入的收益和当前价格的和
                ProSecondSell = Math.max(ProSecondSell,ProSecondBuy+cur);

            }
            return ProSecondSell;
        }
    }
}
