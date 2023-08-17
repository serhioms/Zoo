package codility;

import bns.subset.SubSets;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class AndMaxSubset {

    public int solutionFast(int[] A, boolean isTrace) {
        AtomicInteger[] counter = new AtomicInteger[32];
        for(int i=0; i<32; ++i){
            counter[i] = new AtomicInteger(0);
        }
        Arrays.stream(A)
                .parallel()
                .forEach( a -> {
                    for(int i=0; a > 0; ++i ){
                        if( (a & 1) == 1 ){
                            counter[i].incrementAndGet();
                        }
                        a = a >> 1;
                    }
                });
        int max = 0;
        for(int i=0; i<32; ++i){
            if( max < counter[i].get() ){
                max = counter[i].get();
            }
        }
        return max;
    }

    // perfomance matter
    public int solutionNaive(int[] A, boolean isTrace) {
        int[] max = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] npp = new int[]{0};
        return Arrays.stream(A)
                .filter(d -> d > 0 && (max[0] = (d & max[1])) > 0)
                .filter(d -> {
                    if (isTrace) {
                        String maxs = "0000000000"+Integer.toBinaryString( max[0]);
                        String ds = "0000000000"+Integer.toBinaryString( d);
                        System.out.printf("%s\t%6d\t%s\n", maxs.substring(maxs.length()-10),d, ds.substring(ds.length()-10));
                    }
                    return true;
                })
                .map(d -> (max[1] = max[0]) > 0 ? 1 : 1)
                .sum();
    }

    public int solutionBrutForceStream(int[] A, boolean isInfo, boolean isDebug, boolean isTrace) {
        if (isInfo) {
            System.out.print(A.length + ": ");
        }
        if (isTrace) {
            System.out.println(Arrays.stream(A).boxed().collect(Collectors.toList()));
        }
        SubSets subset = new SubSets(A.length);

        int result = 0;
        int last = 0;

        while (subset.hasNext()) {
            int[] max = new int[]{Integer.MAX_VALUE};
            int[] size = new int[]{0};

            String s = subset.next()
                    .map(i -> A[i])
                    .filter(d -> ++size[0] > 0)
                    .map(d -> (max[0] &= d) > 0 ? d.toString() : d.toString())
                    .collect(Collectors.joining(", "));

            if (max[0] > 0) {
                result = Integer.max(result, size[0]);
                if (isInfo) {
                    if (result != last) {
                        System.out.print(result + " ");
                    }
                    last = result;
                }
            }
            if (isTrace) {
                System.out.printf("%2d <- %15d = %s\n", result, max[0], s);
            }
        }
        if (isInfo) {
            System.out.println("");
        }
        return result;
    }

    public int solutionBrutForceLambda(int[] A, boolean isInfo, boolean isDebug, boolean isTrace) {
        if (isInfo) {
            System.out.print(A.length + ": ");
            System.out.flush();
        }
        if (isTrace) {
            System.out.println(Arrays.stream(A).boxed().collect(Collectors.toList()));
        }

        SubSets subset = new SubSets(A.length);

        int[] result = new int[]{0};
        int[] npp = new int[]{0};
        int last = 0;

        while (subset.hasNext()) {
            int[] max = new int[]{Integer.MAX_VALUE};
            int[] stackSize = new int[]{0};
            int[] size = new int[]{0};
            String[] str = new String[]{""};

            subset.next(stack -> {
                stackSize[0] = size[0] = stack.size();
                if (stack.size() <= result[0]) {
                    return -1;
                }
                for (int i = 0, N = stack.size(); i < N; ++i) {
                    int d = A[stack.get(i)];
                    if (isTrace) {
                        str[0] += Integer.toString(d) + (i == N - 1 ? "" : ",");
                    }
                    if (d == 0) { // excludes ZEROs
                        max[0] = -1;
                        size[0] = i;
                        return i == 0 ? -1 : i;
                    }
                    max[0] &= d;
                    if (max[0] == 0) { // test condition
                        max[0] = -1;
                        size[0] = i;
                        return i;
                    }
                }
                return stack.size() > result[0] ? 0 : -1; // sets less than achieved maximum result ignored
            });

            if (max[0] == Integer.MAX_VALUE) {
                continue; // no results
            } else if (max[0] != 0) {
                result[0] = Integer.max(result[0], size[0]); // next maximum
                if (isInfo) {
                    if (result[0] != last) {
                        System.out.print(result[0] + "/" + stackSize[0] + " ");
                        System.out.flush();
                    }
                    last = result[0];
                }
            }

            ++npp[0];
            if (isTrace) {
                System.out.printf("%7d) %2d /%6d <- %15d = %s\n", npp[0], result[0], stackSize[0], max[0], str[0]);
                if (stackSize[0] <= result[0]) {
                    System.out.println("##########################################" );
                }
            }
        }
        if (isInfo) {
            System.out.println(" (" + npp[0]);
        }
        return result[0];
    }

    @Test
    public void test1BrutForce() {
        assertEquals(3, solutionBrutForceStream(new int[]{13, 7, 2, 8, 3}, false, false, false));
    }

    @Test
    public void test1naive() {
        assertEquals(3, solutionNaive(new int[]{13, 7, 2, 8, 3}, true));
    }

    @Test
    public void test1fast() {
        assertEquals(3, solutionFast(new int[]{13, 7, 2, 8, 3}, true));
    }

    @Test
    public void test2BrutForce() {
        assertEquals(1, solutionBrutForceStream(new int[]{1, 2, 4, 8}, false, false, false));
    }

    @Test
    public void test2naive() {
        assertEquals(1, solutionNaive(new int[]{1, 2, 4, 8}, true));
    }

    @Test
    public void test2fast() {
        assertEquals(1, solutionFast(new int[]{1, 2, 4, 8}, true));
    }


    @Test
    public void test7BrutForce() {
        assertEquals(5, solutionBrutForceStream(generateIntArray(7), false, false, false));
    }

    @Test
    public void test7fast() {
        assertEquals(5, solutionFast(generateIntArray(7), true));
    }

    @Test
    public void test7naive() {
        assertEquals(5, solutionNaive(generateIntArray(7), true));
    }

    @Test
    public void test100BrutForce() {
        assertEquals(55, solutionBrutForceLambda(generateIntArray(100), false, false, false));
    }

    @Test
    public void test100naive() {
        assertEquals(50, solutionNaive(generateIntArray(100), true));
    }

    @Test
    public void test100fast() {
        assertEquals(57, solutionFast(generateIntArray(100), true));
    }

    @Test
    public void test1000BrutForce() {
        assertEquals(526, solutionBrutForceLambda(generateIntArray(1000), false, false, false));
     }

    @Test
    public void test1000naive() {
        assertEquals(526, solutionNaive(generateIntArray(1000), false));
    }

    @Test
    public void test1000fast() {
        assertEquals(526, solutionFast(generateIntArray(1000), false));
    }

    //@Test
    public void test10000BrutForce() {
        assertEquals(5016, solutionBrutForceStream(generateIntArray(10000), false, false, false));
    }

    @Test
    public void test10000naive() {
        assertEquals(5016, solutionNaive(generateIntArray(10000), false));
    }

    @Test
    public void test10000fast() {
        assertEquals(5124, solutionFast(generateIntArray(10000), false));
    }

    //@Test
    public void test100000BrutForce() {
        assertEquals(50024, solutionBrutForceStream(generateIntArray(100000), false, false, false));
    }

    @Test
    public void test100000naive() {
        assertEquals(50024, solutionNaive(generateIntArray(100000), false));
    }

    @Test
    public void test100000fast() {
        assertEquals(50093, solutionFast(generateIntArray(100000), false));
    }

    private int[] generateIntArray(int N) {
        Random rnd = new Random(1234567890);
        int[] result = new int[N];
        for (int i = 0; i < N; ++i) {
            result[i] = rnd.nextInt(10000);
        }
        return result;
    }

}
