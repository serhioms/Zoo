package leetcode.maxprofit;

public class MaxProfitMy7 implements MaxProfit {

    @Override
    public int solution(int[] prices) {
        int a = 0;
        int b = prices.length - 1;
        int mina = prices[a];
        int maxa = prices[a];
        int maxb = prices[b];
        int minb = prices[b];
        int maxProfit = prices[b] - prices[a];
        while (++a <= --b) {
            if( prices[a] > maxa ){
                maxa = prices[a];
            }
            if( prices[b] < minb ){
                minb = prices[b];
            }
            if (prices[a] < mina) {
                if( maxa-mina > maxProfit ){
                    maxProfit = maxa - mina;
                }
                mina = maxa = prices[a];
            }
            if (prices[b] > maxb) {
                if( maxb - minb > maxProfit ){
                    maxProfit = maxb - minb;
                }
                maxb = minb = prices[b];
            }
            if( maxb - mina > maxProfit ){
                maxProfit = maxb - mina;
            }
        }
        if( maxa-mina > maxProfit ){
            maxProfit = maxa - mina;
        }
        if( maxb - minb > maxProfit ){
            maxProfit = maxb - minb;
        }
        return maxProfit;
    }
}