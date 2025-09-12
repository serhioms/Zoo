package ru.yandex.code.sort.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ru.yandex.code.sort.BubbleSort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class TestNegativeBubbleSort {

    @Test
    public void negativeEmpty() {
        IllegalArgumentException ex =
                assertThrowsExactly(IllegalArgumentException.class,
                        () -> new BubbleSort().sort(new int[] {}));

        assertEquals("Array is empty", ex.getMessage());
    }
    @Test
    public void negativeNull() {
        IllegalArgumentException ex =
                assertThrowsExactly(IllegalArgumentException.class,
                        () -> new BubbleSort().sort(null));

        assertEquals("Array is empty", ex.getMessage());
    }

}
