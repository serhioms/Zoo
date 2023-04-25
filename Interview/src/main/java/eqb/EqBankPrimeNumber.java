package eqb;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EqBankPrimeNumber {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter number:");
        String str = in.next();

        String[]  arr = str.split("\\.");

        int max = Integer.parseInt(arr[0]) + ((arr.length>1 && Integer.parseInt(arr[1])>0 )? 0: -1);


        String primes = getPrimeNumbers(max).stream().map(n-> n.toString()).collect(Collectors.joining(","));
        System.out.println(primes);

    }

    static List<Integer> getPrimeNumbers(int max){
        return IntStream.rangeClosed(2, max).filter(N-> EqBankPrimeNumber.isPrime(N)).mapToObj(Integer::valueOf).collect(Collectors.toList());
    }

    static boolean isPrime(int n) {
        if( n < 2 || (n & 1) == 0 ){
            return false;
        }
        for (int i=3,max=n/2; i <= max; i+=2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
