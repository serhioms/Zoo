package ru.yandex.code.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Zipper {
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        int[] A = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] B = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(zip(N, A, B));
    }

   private static String zip(int n, int[] a, int[] b) {
        ArrayList<Integer> lst = new ArrayList<>(2*n);
        for (int i=0,na=a.length,nb=b.length; i < n && (i < na || i < nb); i++) {
            if( i < na ) {
                lst.add(a[i]);
            }
            if( i < nb ) {
                lst.add(b[i]);
            }
        }
        return lst.stream().map(Object::toString).collect(Collectors.joining(" "));
    }


    public static void main(String[] args) {
        System.out.println(zip(3, Arrays.stream("1 2 3".split(" ")).mapToInt(Integer::parseInt).toArray(), Arrays.stream("4 5 6".split(" ")).mapToInt(Integer::parseInt).toArray()));
        System.out.println(zip(1, Arrays.stream("1".split(" ")).mapToInt(Integer::parseInt).toArray(), Arrays.stream("2".split(" ")).mapToInt(Integer::parseInt).toArray()));
        System.out.println(zip(3, Arrays.stream("1 8 9".split(" ")).mapToInt(Integer::parseInt).toArray(), Arrays.stream("2 3 1".split(" ")).mapToInt(Integer::parseInt).toArray()));
    }

}