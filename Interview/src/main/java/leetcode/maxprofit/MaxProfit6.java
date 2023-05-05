package leetcode.maxprofit;

public class MaxProfit6 implements MaxProfit {

    @Override
    // Save on memory due to no stack operations
    public int solution(int[] prices) {
        int a = 0;
        int b = 1;
        int maxProfit = 0;
        int cProfit = 0;
        while (b < prices.length) {
            if (prices[a] < prices[b]) {
                cProfit = prices[b] - prices[a];
                if (maxProfit < cProfit) {
                    maxProfit = cProfit;
                }
            } else {
                a = b;
            }
            ++b;
        }
        return maxProfit;
    }
}