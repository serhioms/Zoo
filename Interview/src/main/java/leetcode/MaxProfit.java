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
        for(int buy=0,max=prices.length; buy<max-1; ++buy){
            for(int sell=buy+1; sell < max; ++sell){
                int profit = prices[sell] - prices[buy];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }

    // 15.88% Memory 59.5 MB Beats 20.35%
    public int maxProfit3My(int[] prices) {
        int a = 0;
        int b = prices.length-1;
        int mina = prices[a];
        int maxa = prices[a];
        int maxb = prices[b];
        int minb = prices[b];
        int maxProfit = prices[b] - prices[a];
        while( ++a <= --b){
            maxa = Math.max(maxa,prices[a]);
            minb = Math.min(minb,prices[b]);
            if( prices[a] < mina ){
                maxProfit = Math.max(maxProfit, maxa - mina);
                mina = maxa = prices[a];
            }
            if( prices[b] > maxb ){
                maxProfit = Math.max(maxProfit, maxb - minb);
                maxb = minb = prices[b];
            }
            maxProfit = Math.max(maxProfit, maxb - mina);
        }
        maxProfit = Math.max(maxProfit, maxa - mina);
        maxProfit = Math.max(maxProfit, maxb - minb);
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

        for(int i = prices.length - 1; i >= 1; i--)
            for(int j = i - 1;j >= 0; j--)
                if((prices[i] - prices[j]) >= res)
                    res = prices[i] - prices[j];

        if(res < 0) return 0;
        return res;
    }

    public int maxProfit1(int[] prices) {
        int minsofar = prices[0];
        int maxprofit = 0;
        for(int price: prices){
            minsofar = Math.min(minsofar, price);
            maxprofit = Math.max(maxprofit, price - minsofar);
        }
        return maxprofit;
    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int [] aux = new int[n];
        int maxi = 0;
        int maxProfit = 0;

        // In this appproach i am creating an array which will contain the maximum price that the stock will attain in fure
        for(int i = n-1; i>=0; --i){
            maxi = Math.max(maxi, prices[i]);
            aux[i] = maxi;
        }

        for(int i = 0; i<n; ++i){
            //we  will sell the stock each day now and store it in profit
            int   profit = aux[i] - prices[i];
            // we will now compare the profit of each day and update the maximum profit in maxProfit
            maxProfit =  Math.max(maxProfit, profit);
        }

        return maxProfit;
    }

    @Test
    public void testMaxProfitA(){
        int[] A = new int[]{7,1,5,3,6,4};
        assertEquals(5, maxProfitMyBrut(A));
        assertEquals(5, maxProfit3My(A));
        assertEquals(5, maxProfit0(A));
        assertEquals(5, maxProfit1(A));
        assertEquals(5, maxProfit2(A));
     }

    @Test
    public void testMaxProfitB(){
        int[] B = new int[]{3,2,6,5,0,3};
        assertEquals(4, maxProfitMyBrut(B));
        assertEquals(4, maxProfit3My(B));
        assertEquals(4, maxProfit0(B));
        assertEquals(4, maxProfit1(B));
        assertEquals(4, maxProfit2(B));
    }

    @Test
    public void testMaxProfitC() throws Exception{
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

        System.out.printf("   My brut, nano = %,d\n", end - start);
        System.out.printf("      My 3, nano = %,d\n", end3 - start3);
        System.out.printf("  Genius 2, nano = %,d\n", end3 - start3);
        System.out.printf("  Genius 1, nano = %,d\n", end1 - start1);
        System.out.printf("'Genius 0', nano = %,d\n", end0 - start0);
     }

    private int[] readIntArray(String filePath) throws Exception {
        String[] strarr = null;
        InputStream in =  new FileInputStream(filePath);
        if( in != null ){
            Scanner scanner = new Scanner(in);
            while(scanner.hasNext()){
                strarr = scanner.next().split(",");
            }
        }
        int[] arr = Arrays.stream(strarr).mapToInt(Integer::parseInt).toArray();
        return arr;
    }
}
