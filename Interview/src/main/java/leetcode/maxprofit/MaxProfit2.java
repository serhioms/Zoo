package leetcode.maxprofit;

public class MaxProfit2 implements MaxProfit {

    @Override
    public int solution(int[] prices) {
        int n = prices.length;
        int[] aux = new int[n];
        int maxi = 0;
        int maxProfit = 0;
        // In this appproach i am creating an array which will contain the maximum price that the stock will attain in fure
        for (int i = n - 1; i >= 0; --i) {
            if (prices[i] > maxi) {
                maxi = prices[i];
            }
            aux[i] = maxi;
        }
        for (int i = 0; i < n; ++i) {
            //we  will sell the stock each day now and store it in profit
            int profit = aux[i] - prices[i];
            // we will now compare the profit of each day and update the maximum profit in maxProfit
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }

}
