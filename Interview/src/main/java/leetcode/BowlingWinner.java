package leetcode;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class BowlingWinner {

    public int bowlingWinner(int[] player1, int[] player2) {
        int sum1 = 0, sum2 = 0;
        for (int i = 0, max = player1.length; i < max; ++i) {
            sum1 += player1[i] * (i > 2 && Math.max(player1[i - 1], player1[i - 1]) == 10 ? 2 : 1);
            sum2 += player2[i] * (i > 2 && Math.max(player2[i - 1], player2[i - 1]) == 10 ? 2 : 1);
        }
        return sum1 > sum2 ? 1 : sum2 > sum1 ? 2 : 0;
    }

    @Test
    public void testBowlingWinner1() {
        assertEquals(1, bowlingWinner(new int[]{4, 10, 7, 9}, new int[]{6, 5, 2, 3}));
    }

    @Test
    public void testBowlingWinner2() {
        assertEquals(2, bowlingWinner(new int[]{3, 5, 7, 6}, new int[]{8, 10, 10, 2}));
    }

    @Test
    public void testBowlingWinner3() {
        assertEquals(0, bowlingWinner(new int[]{2, 3}, new int[]{4, 1}));
    }

}
