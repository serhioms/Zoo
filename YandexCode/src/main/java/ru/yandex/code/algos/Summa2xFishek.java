package ru.yandex.code.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Summa2xFishek {
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        int[] F = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int S = Integer.parseInt(scanner.nextLine());;

        System.out.println(findSum2(N, F, S));
    }

   private static String findSum2(int n, int[] a, int sum) {
        Integer f1 = null, f2 = null;
        return (f1==null||f2==null)?"None": f1+" "+f2;
    }


    public static void main(String[] args) {
        System.out.println(findSum2(6, Arrays.stream("-1 -1 -9 -7 3 -6".split(" ")).mapToInt(Integer::parseInt).toArray(), 2));
        System.out.println(findSum2(8, Arrays.stream("6 2 8 -3 1 1 6 10".split(" ")).mapToInt(Integer::parseInt).toArray(), 100));
    }

}