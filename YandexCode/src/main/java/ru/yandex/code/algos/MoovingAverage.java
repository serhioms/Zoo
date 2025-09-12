package ru.yandex.code.algos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MoovingAverage {

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        int[] A = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int K = Integer.parseInt(scanner.nextLine());

        System.out.println(movingAverage(N, A, K));
    }

   private static String movingAverage(int n, int[] a, int k) {
        ArrayList<BigDecimal> result = new ArrayList<>(Integer.max(10, a.length-k));
        BigDecimal K = new BigDecimal(Integer.toString(k)).setScale(10, RoundingMode.HALF_UP);
       if( k <= a.length) {
            LinkedList<Integer> window = new LinkedList<>();
           BigDecimal avg = new BigDecimal("0.0").setScale(10, RoundingMode.HALF_UP);
            for (int i = 0; i < k; i++) {
                window.add(a[i]);
                avg = avg.add(new BigDecimal(Integer.toString(a[i])));
            }
            result.add(avg.divide(K,RoundingMode.HALF_UP));
           for (int i = k; i < n; i++) {
               int substruct = window.removeFirst();
               int add = a[i];
               window.add(add);
               avg = avg.add(new BigDecimal(Integer.toString(add))).subtract(new BigDecimal(Integer.toString(substruct)));
               result.add(avg.divide(K,RoundingMode.HALF_UP));
           }

        }
        return result.stream().map(bd->bd.stripTrailingZeros().toPlainString()).collect(Collectors.joining(" "));
    }


    public static void main(String[] args) {
        System.out.println(movingAverage(7, Arrays.stream("1 2 3 4 5 6 7".split(" ")).mapToInt(Integer::parseInt).toArray(), 4));
        System.out.println(movingAverage(9, Arrays.stream("9 3 2 0 1 5 1 0 0".split(" ")).mapToInt(Integer::parseInt).toArray(), 3));
        System.out.println(movingAverage(5, Arrays.stream("1 2 3 4 5".split(" ")).mapToInt(Integer::parseInt).toArray(), 5));
    }

}