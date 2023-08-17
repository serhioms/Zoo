package codility;

/*
Task 1

Java 8

Task score

100%

Correctness

100%

Performance

―

Example test cases

Passed 1 out of 1

Correctness test cases

Passed 9 out of 9

Submission date

2023-07-13 10:52 EDT
 */
public class MaxInteger {
    public int solution(int[] A) {
        //return java.util.Arrays.stream(A).filter(d->d<10&&d>-10).max().getAsInt();
        int max = Integer.MIN_VALUE;
        for(int a: A){
            if( a == 9 ){
                return a;
            } else if( a > 9 || a < -9 ){
                continue;
            } else if( a > max ){
                max = a;
            }
        }
        return max;
    }
}
