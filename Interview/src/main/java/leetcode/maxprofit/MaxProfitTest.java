package leetcode.maxprofit;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import util.TestAutomation;
import util.TestUtil;

/*
Report          MyBrut =   2,130,566,604 ns
Report         Profit1 =       3,801,231 ns - the best algo
Report         Profit2 =       2,453,758 ns
Report             My3 =       4,417,876 ns
Report         Profit4 =       2,038,526 ns
Report         Profit5 =       3,683,630 ns
Report         Profit6 =       2,413,562 ns
Report             My7 =       2,196,323 ns -   #1 is mine!!!!!
 */
public class MaxProfitTest extends TestAutomation {

    @BeforeClass
    public static void beforeClass() {
        addImplementation(new MaxProfit4(), "Profit4");
        addImplementation(new MaxProfit4(), "Profit4");
        addImplementation(new MaxProfit6(), "Profit6");
        addImplementation(new MaxProfitMy7(), "My7");
        addImplementation(new MaxProfit5(), "Profit5");
        addImplementation(new MaxProfit1(), "Profit1");
        addImplementation(new MaxProfitMy3(), "My3");
        addImplementation(new MaxProfit2(), "Profit2");
        addImplementation(new MaxProfitMyBrut(), "MyBrut");
    }

    static int[] A = new int[]{7, 1, 5, 3, 6, 4};

    @Test
    public void testMaxProfit1() {
        runAllImplementations(test -> assertEquals(5, ((MaxProfit)test).solution(A)));
    }

    static int[] B = new int[]{3, 2, 6, 5, 0, 3};

    @Test
    public void testMaxProfit2() {
        runAllImplementations(test -> assertEquals(4, ((MaxProfit)test).solution(B)));
    }

    static int[] C = TestUtil.readIntArray("data/maxprofit.txt");

    @Test
    public void testMaxProfit3() {
        runAllImplementations(test -> assertEquals(999, ((MaxProfit)test).solution(C)));
    }
}
