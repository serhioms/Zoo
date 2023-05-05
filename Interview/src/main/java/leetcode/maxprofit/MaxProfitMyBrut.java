package leetcode.maxprofit;

public class MaxProfitMyBrut implements MaxProfit {

    @Override
    public int solution(int[] prices) {
        int maxProfit = 0;
        for (int buy = 0, max = prices.length; buy < max - 1; ++buy) {
            for (int sell = buy + 1; sell < max; ++sell) {
                int profit = prices[sell] - prices[buy];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }
}