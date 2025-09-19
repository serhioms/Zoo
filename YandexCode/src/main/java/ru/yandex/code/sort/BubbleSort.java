package ru.yandex.code.sort;

public class BubbleSort {

    public int swapcount;
    public int cmpCount;

    public BubbleSort() {
    }

    public int[] sort(int[] array) {
        return sort(array, false);
    }

    public int[] sort(int[] array, boolean earlyExit) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        swapcount = cmpCount = 0;
        for (int i = 0,mi=array.length - 1; i < mi; i++) {
            boolean noSwap = true;
            for (int j = 0,mj=array.length - i - 1; j < mj; j++) {
                cmpCount++;
                if (array[j] > array[j + 1]) {
                    noSwap = false;
                    swapcount++;
                    swapIJ(array, j, j+1);
                }
            }
            if( earlyExit && noSwap) {
                break;
            }
        }
        return array;
    }

    private void swapIJ(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
