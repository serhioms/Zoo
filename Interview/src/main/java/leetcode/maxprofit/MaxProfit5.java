package leetcode.maxprofit;

public class MaxProfit5 implements MaxProfit {

    @Override
    // Save on memory due to no stack operations
    public int solution(int[] prices) {
        int a = 0, b = 1;
        int max = Integer.MIN_VALUE;
        while (b < prices.length) {
            int profit = prices[b] - prices[a];
            if (prices[b] > prices[a]) {
                if (profit > max) {
                    max = profit;
                }
                ++b;
            } else {
                a = b;
                ++b;
            }
        }
        if (max < 0) {
            return 0;
        }
        return max;
    }
}