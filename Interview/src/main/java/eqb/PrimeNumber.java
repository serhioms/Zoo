package eqb;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumber {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter number:");
        String number = in.next();

        int max = Integer.parseInt(number.split("\\.")[0]);


        long start2 = System.currentTimeMillis();
        String primes2 = getPrimeNumbersSqrt(max).stream().map(n-> n.toString()).collect(Collectors.joining(","));
        long finish2 = System.currentTimeMillis();

        long start = System.currentTimeMillis();
        String primes = ""; //getPrimeNumbersN2(max).stream().map(n-> n.toString()).collect(Collectors.joining(","));
        long finish = System.currentTimeMillis();

        /*
        Enter number:    999999  0.16 sec inline method sqrt
                                  27 sec inline method N/2
                                  54 sec inline block N/2
                                 110 sec inline block N
        Enter number:   9999999 3 sec
        Enter number:  99999999 76 sec
        Enter number: 999999999 Java heap space
         */

        System.out.printf("Prime Sqrt = %d mls\n", finish2-start2);
        System.out.printf("Prime  N/2 = %d mls\n", finish - start);

        if( primes.equals(primes2) ){
            System.out.println(primes);
        }

    }

    static List<Integer> getPrimeNumbersN2(int max){
        return IntStream.range(2, max).filter(N->PrimeNumber.isPrime(N, N/2)).mapToObj(Integer::valueOf).collect(Collectors.toList());
    }

    static List<Integer> getPrimeNumbersSqrt(int max){
        return IntStream.range(2, max).filter(N->PrimeNumber.isPrime(N, (int) Math.floor(Math.sqrt((double) N)))).mapToObj(Integer::valueOf).collect(Collectors.toList());
    }

    static boolean isPrime(int n, int max) {
        if( n > 2 ) {
            if( (n & 1) == 0 ){
                return false;
            }
            for (int i=3; i <= max; i+=2) {
                if (n % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
