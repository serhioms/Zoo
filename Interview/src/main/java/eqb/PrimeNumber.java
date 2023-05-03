package eqb;

import org.junit.Test;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class PrimeNumber {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter number:");
        String str = in.next();

        String[]  arr = str.split("\\.");

        int max = Integer.parseInt(arr[0]) + ((arr.length>1 && Integer.parseInt(arr[1])>0 )? 0: -1);

        System.out.println(new PrimeNumber().getPrimeNumbersN(max).toString());

    }

    List<Integer> getPrimeNumbersN(int max){
        return IntStream.rangeClosed(2, max)
                .filter(N -> isPrime(N, N/2))
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());
    }

    List<Integer> getPrimeNumbersSqrt(int max){
        return IntStream.rangeClosed(2, max)
                .filter(N -> isPrime(N, (int) Math.floor(Math.sqrt((double) N))))
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());
    }

    boolean isPrime(int n, int max) {
        if( n <= 2 ) {
            return true;
        } else if( (n & 1) == 0 ){
            return false;
        }
        for (int i=3; i <= max; i+=2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testPrimeNumber22() {
        assertEquals("[2, 3, 5, 7, 11, 13, 17, 19]", getPrimeNumbersN(22).toString());
        assertEquals("[2, 3, 5, 7, 11, 13, 17, 19]", getPrimeNumbersSqrt(22).toString());
    }

    @Test
    public void testPrimeNumber100() {
        assertEquals("[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97]", getPrimeNumbersN(100).toString());
        assertEquals("[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97]", getPrimeNumbersSqrt(100).toString());
    }

}
