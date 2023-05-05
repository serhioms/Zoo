package leetcode.maxprofit;

public class MaxProfit1 implements MaxProfit {

    @Override
    public int solution(int[] prices) {
        int minsofar = prices[0];
        int maxprofit = 0;
        for (int price : prices) {
            minsofar = Math.min(minsofar, price);
            maxprofit = Math.max(maxprofit, price - minsofar);
        }
        return maxprofit;
    }
}