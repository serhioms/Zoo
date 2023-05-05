package leetcode.maxprofit;

public class MaxProfitMy3 implements MaxProfit {

    @Override
    // 15.88% Memory 59.5 MB Beats 20.35%
    public int solution(int[] prices) {
        int a = 0;
        int b = prices.length - 1;
        int mina = prices[a];
        int maxa = prices[a];
        int maxb = prices[b];
        int minb = prices[b];
        int maxProfit = prices[b] - prices[a];
        while (++a <= --b) {
            maxa = Math.max(maxa, prices[a]);
            minb = Math.min(minb, prices[b]);
            if (prices[a] < mina) {
                maxProfit = Math.max(maxProfit, maxa - mina);
                mina = maxa = prices[a];
            }
            if (prices[b] > maxb) {
                maxProfit = Math.max(maxProfit, maxb - minb);
                maxb = minb = prices[b];
            }
            maxProfit = Math.max(maxProfit, maxb - mina);
        }
        maxProfit = Math.max(maxProfit, maxa - mina);
        maxProfit = Math.max(maxProfit, maxb - minb);
        return maxProfit;
    }
}