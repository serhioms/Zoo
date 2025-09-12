package ru.yandex.code.sort.test;

import org.junit.Test;
import ru.yandex.code.sort.BubbleSort;

import static org.junit.Assert.assertArrayEquals;

public class TestPositiveBubbleSort {

    @Test
    public void positiveWorstCase() {
        BubbleSort bubble = new BubbleSort();
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, bubble.sort(new int[] { 9,8,7,6,5,4,3,2,1 }));
        System.out .printf("WorstCase: cmp=%d, swap=%d \n", bubble.cmpCount, bubble.swapcount);
        bubble = new BubbleSort();
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, bubble.sort(new int[] { 9,8,7,6,5,4,3,2,1 }, true));
        System.out .printf("WorstCase early exit: cmp=%d, swap=%d \n", bubble.cmpCount, bubble.swapcount);
     }
    @Test
    public void positiveMidCase() {
        BubbleSort bubble = new BubbleSort();
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, bubble.sort(new int[] { 9,1,8,2,7,3,6,4,5 }));
        System.out .printf("MidCase: cmp=%d, swap=%d \n", bubble.cmpCount, bubble.swapcount);
        bubble = new BubbleSort();
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, bubble.sort(new int[] { 9,1,8,2,7,3,6,4,5 }, true));
        System.out .printf("MidCase early exit: cmp=%d, swap=%d \n", bubble.cmpCount, bubble.swapcount);
    }
    @Test
    public void positiveRepetitionCase() {
        BubbleSort bubble = new BubbleSort();
        assertArrayEquals(new int[] { 1,5,5,5,6,6,6,6,6,8 }, bubble.sort(new int[] { 6,5,6,5,6,6,5,6,8,1 }));
        System.out .printf("PepetitionCase: cmp=%d, swap=%d \n", bubble.cmpCount, bubble.swapcount);
        bubble = new BubbleSort();
        assertArrayEquals(new int[] { 1,5,5,5,6,6,6,6,6,8 }, bubble.sort(new int[] { 6,5,6,5,6,6,5,6,8,1 }, true));
        System.out .printf("PepetitionCase early exit: cmp=%d, swap=%d \n", bubble.cmpCount, bubble.swapcount);
    }
}
