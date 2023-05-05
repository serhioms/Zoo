package leetcode.maxprofit;

public class MaxProfit4 implements MaxProfit {

    @Override
    // Save on memory due to no stack operations
    public int solution(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > profit) {
                profit = prices[i] - min;
            }
        }
        return profit;
    }
}