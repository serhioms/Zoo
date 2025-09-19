package ru.yandex.code.algos;

import java.math.BigDecimal;
import java.util.Scanner;

public class BigDecimalInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigDecimal A = new BigDecimal(scanner.nextLine());
        BigDecimal B = new BigDecimal(scanner.nextLine());
        BigDecimal C = A.add(B);

        System.out.println(C.toPlainString());
    }
}