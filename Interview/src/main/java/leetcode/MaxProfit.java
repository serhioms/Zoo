package leetcode;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class MaxProfit {

    public int maxProfitMyBrut(int[] prices) {
        int maxProfit = 0;
        for (int buy = 0, max = prices.length; buy < max - 1; ++buy) {
            for (int sell = buy + 1; sell < max; ++sell) {
                int profit = prices[sell] - prices[buy];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }

    // 15.88% Memory 59.5 MB Beats 20.35%
    public int maxProfit3My(int[] prices) {
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

    public int maxProfit7My(int[] prices) {
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

    public int maxProfit0(int[] prices) {
        /* // TODO: VOT SUKA!!!
        if (prices.length > 100) {
            if (prices.length == 1000)
                return 9995;
            if (prices.length == 26004)
                return 3;
            if (prices.length == 100000 && prices[0] == 5507)
                return 9972;
            if (prices.length == 100000 && prices[0] != 933)
                return 0;
            if (prices.length > 31000)
                return 999;
        }*/
        int res = Integer.MIN_VALUE;

        for (int i = prices.length - 1; i >= 1; i--)
            for (int j = i - 1; j >= 0; j--)
                if ((prices[i] - prices[j]) >= res)
                    res = prices[i] - prices[j];

        if (res < 0) return 0;
        return res;
    }

    public int maxProfit1(int[] prices) {
        int minsofar = prices[0];
        int maxprofit = 0;
        for (int price : prices) {
            minsofar = Math.min(minsofar, price);
            maxprofit = Math.max(maxprofit, price - minsofar);
        }
        return maxprofit;
    }

    // Save on memory due to no stack operations
    public int maxProfit4(int[] prices) {
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

    public int maxProfit5(int[] prices) {
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

    public int maxProfit6(int[] prices) {
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

    public int maxProfit2(int[] prices) {
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

    @Test
    public void testMaxProfitA() {
        int[] A = new int[]{7, 1, 5, 3, 6, 4};
        assertEquals(5, maxProfitMyBrut(A));
        assertEquals(5, maxProfit0(A));
        assertEquals(5, maxProfit1(A));
        assertEquals(5, maxProfit2(A));
        assertEquals(5, maxProfit3My(A));
        assertEquals(5, maxProfit4(A));
        assertEquals(5, maxProfit5(A));
        assertEquals(5, maxProfit6(A));
        assertEquals(5, maxProfit7My(A));
    }

    @Test
    public void testMaxProfitB() {
        int[] B = new int[]{3, 2, 6, 5, 0, 3};
        assertEquals(4, maxProfitMyBrut(B));
        assertEquals(4, maxProfit0(B));
        assertEquals(4, maxProfit1(B));
        assertEquals(4, maxProfit2(B));
        assertEquals(4, maxProfit3My(B));
        assertEquals(4, maxProfit4(B));
        assertEquals(4, maxProfit5(B));
        assertEquals(4, maxProfit6(B));
        assertEquals(4, maxProfit7My(B));
    }

    @Test
    public void testMaxProfitC() throws Exception {
        int[] C = readIntArray("data/maxprofit.txt");

        long start = System.nanoTime();
        assertEquals(999, maxProfitMyBrut(C));
        long end = System.nanoTime();

        long start3 = System.nanoTime();
        assertEquals(999, maxProfit3My(C));
        long end3 = System.nanoTime();

        long start0 = System.nanoTime();
        assertEquals(999, maxProfit0(C));
        long end0 = System.nanoTime();

        long start1 = System.nanoTime();
        assertEquals(999, maxProfit1(C));
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        assertEquals(999, maxProfit2(C));
        long end2 = System.nanoTime();

        long start4 = System.nanoTime();
        assertEquals(999, maxProfit4(C));
        long end4 = System.nanoTime();

        long start5 = System.nanoTime();
        assertEquals(999, maxProfit5(C));
        long end5 = System.nanoTime();

        long start6 = System.nanoTime();
        assertEquals(999, maxProfit6(C));
        long end6 = System.nanoTime();

        long start7 = System.nanoTime();
        assertEquals(999, maxProfit7My(C));
        long end7 = System.nanoTime();

        System.out.printf("    My brut, nano = %,d\n", end - start);
        System.out.printf("       My 3, nano = %,d\n", end3 - start3);
        System.out.printf("   Genius 2, nano = %,d no Math.min/max !\n", end2 - start2);
        System.out.printf("  Genius 14, nano = %,d\n", end1 - start1);
        System.out.printf(" 'Genius 0', nano = %,d\n", end0 - start0);
        System.out.printf("  Genius 41, nano = %,d no Math.min/max !!!!\n", end4 - start4);
        System.out.printf("   Genius 5, nano = %,d no Math.min/max\n", end5 - start5);
        System.out.printf("   Genius 6, nano = %,d no Math.min/max !!\n", end6 - start6);
        System.out.printf("       My 7, nano = %,d no Math.min/max !!!\n", end7 - start7);
    }

    private int[] readIntArray(String filePath) throws Exception {
        String[] strarr = null;
        InputStream in = new FileInputStream(filePath);
        if (in != null) {
            Scanner scanner = new Scanner(in);
            while (scanner.hasNext()) {
                strarr = scanner.next().split(",");
            }
        }
        int[] arr = Arrays.stream(strarr).mapToInt(Integer::parseInt).toArray();
        return arr;
    }
}
