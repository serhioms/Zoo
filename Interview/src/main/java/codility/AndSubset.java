package codility;

import bns.subset.SubSets;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/*
Task 2

Java 8

Task score

74%

Correctness

80%

Performance

60%

Example test cases

Passed 3 out of 3

Correctness test cases

Passed 9 out of 10

Performance test cases

Passed 3 out of 5 - 60% - improoved!

Submission date

2023-07-13 11:52 EDT
 */
public class AndSubset {

    public static void main2(String[] args) {

        AndSubset as = new AndSubset();

        System.out.println("Hi = " + (-5 & -25));

        System.out.println("max = " + (Integer.toBinaryString(Integer.MAX_VALUE)));

        int[] A = new int[]{1, 2, 4, 8};
        List<Integer> list = java.util.Arrays.stream(A).filter(d -> d >= 0).boxed().collect(java.util.stream.Collectors.toList());

        int max = Integer.MAX_VALUE;
        A = new int[]{13, 7, 2, 8, 3}; // 13,7,3
        for (int a : A) {
            String s = ("0000000000" + Integer.toBinaryString(a));
            max = max & a;
            System.out.println(s.substring(s.length() - 5) + "\t" + a + "\t" + max);
        }

        System.out.println("\n\nSolution1 = " + as.solutionNaive(new int[]{13, 7, 2, 8, 3}, true));
        System.out.println("Solution1 = " + as.solutionNaive(new int[]{2, 8, 13, 7, 3}, true));
        System.out.println("Solution1 = " + as.solutionNaive(new int[]{2, 13, 7, 3, 8}, true));
        System.out.println("Solution2 = " + as.solutionNaive(new int[]{1, 2, 4, 8}, true));
        System.out.println("Solution3 = " + as.solutionNaive(new int[]{16, 16}, true));

        String test = "0000000000" + Integer.toBinaryString(Integer.MAX_VALUE & 2);
        System.out.println("\n\n" + test.substring(test.length() - 5));


    }

    // perfomance matter
    public int solutionNaive(int[] A, boolean isTrace) {
        int[] max = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] npp = new int[]{0};
        return java.util.Arrays.stream(A)
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


    public int solutionBrutForceIndex(int[] A, boolean isInfo, boolean isDebug, boolean isTrace) {
        int result = 0;
        for(int i=0, max=A.length-1; i<=max; ++i) {
            if( result >= (max-i) ){
                break;
            }
            result = Math.max(result, rollIndexRecursive(A, i, Integer.MAX_VALUE, 0));
        }
        return result;
    }

    private int rollIndexStack(int[] A, int index, int and1, int result) {
        for(int i=index, max=A.length-1; i<=max; ++i) {
            int d = A[i];
            int and2 = d & and1;
            if (and2 != 0) {
                and1 = and2;
                ++result;
            } else {
                return Math.max(result, rollIndexStack(A, i+1, and1, result));
            }
            if( result == max ){
                break; // no reason to continue cause result reach max value
            }
        }
        return result;
    }

    private int rollIndexRecursive(int[] A, int index, int and1, int result) {
        for(int i=index, max=A.length-1; i<=max; ++i) {
            int d = A[i];
            int and2 = d & and1;
            if (and2 != 0) {
                and1 = and2;
                ++result;
            } else {
                return Math.max(result, rollIndexRecursive(A, i+1, and1, result));
            }
            if( result == max ){
                break; // no reason to continue cause result reach max value
            }
        }
        return result;
    }

    @Test
    public void test1index() {
        assertEquals(3, solutionBrutForceIndex(new int[]{13, 7, 2, 8, 3}, false, false, true));
    }

    @Test
    public void test1() {
        assertEquals(3, solutionBrutForceStream(new int[]{13, 7, 2, 8, 3}, false, false, true));
    }

    @Test
    public void test1naive() {
        assertEquals(3, solutionNaive(new int[]{13, 7, 2, 8, 3}, true));
    }

    @Test
    public void test2() {
        assertEquals(1, solutionBrutForceStream(new int[]{1, 2, 4, 8}, false, false, true));
    }

    @Test
    public void test2index() {
        assertEquals(1, solutionBrutForceIndex(new int[]{1, 2, 4, 8}, false, false, true));
    }

    @Test
    public void test2naive() {
        assertEquals(1, solutionNaive(new int[]{1, 2, 4, 8}, true));
    }

    @Test
    public void test7() {
        assertEquals(5, solutionBrutForceStream(generateIntArray(7), false, false, true));
    }

    @Test
    public void test7index() {
        assertEquals(5, solutionBrutForceIndex(generateIntArray(7), false, false, true));
    }

    @Test
    public void test7BrutForce() {
        assertEquals(5, solutionBrutForceLambda(generateIntArray(7), false, false, true));
    }

    @Test
    public void test7naive() {
        assertEquals(5, solutionNaive(generateIntArray(7), true));
    }

    @Test
    public void test100index() {
        assertEquals(55, solutionBrutForceIndex(generateIntArray(100), false, false, true));
    }

    @Test
    public void test100() {
        assertEquals(55, solutionBrutForceLambda(generateIntArray(100), false, false, true));
        // 166750) 10 <-             740 = 740,
        // 130006) 10 <-             740 = 740,
        /*
              1)  0 <-               0 = 677,4242,4821,
              2)  0 <-               0 = 677,4242,4821,
              3)  0 <-               0 = 677,4242,4821,
              ***
              130006) 10 <-             740 = 740,
         */
        // 257) 10 <-             740 = 740,
        // 194) 10 <-      2147483647 =
        // 94) 10 <-              -1 = 7477,1840,1767,7809,7802,7038,
        // 1056) 55 /    56 <-              -1 = 3434,5877,4441,696,
    }

    @Test
    public void test100naive() {
        assertEquals(50, solutionNaive(generateIntArray(100), true));
    }

    @Test
    public void test1000index_0ms() {
        assertEquals(526, solutionBrutForceIndex(generateIntArray(1000), false, false, true));
    }

    @Test
    public void test1000_2sec() {
        assertEquals(526, solutionBrutForceLambda(generateIntArray(1000), true, false, false));
        // 1000: 3/1000 5/998 6/997 8/990 9/989 14/984 17/983 23/982 25/981 26/980 27/979 29/978 31/977 33/975 35/973 36/972 39/971 41/969 42/966 44/964 46/963 48/955 51/950 60/949 61/946 69/945 72/944 73/942 75/937 76/936 77/935 78/933 79/930 80/927 81/925 82/924 85/923 87/921 89/919 94/917 95/915 96/914 99/913 103/910 105/909 106/908 107/903 112/902 113/901 118/896 123/895 125/893 126/892 128/891 129/890 131/888 132/887 133/886 134/885 138/881 140/879 145/877 146/875 147/874 149/868 150/866 151/865 159/864 161/861 162/855 164/853 165/852 169/851 173/850 177/849 178/848 180/847 181/846 183/845 187/844 190/841 191/839 192/838 194/837 196/836 197/834 200/831 201/830 203/827 204/824 205/823 206/822 207/821 208/820 211/819 212/818 213/816 216/815 217/810 218/809 219/804 221/803 222/799 223/798 224/797 225/796 227/795 229/794 230/792 232/791 234/790 235/789 239/785 241/782 242/780 245/778 247/777 248/775 249/773 252/772 253/769 257/768 258/767 259/766 260/765 261/763 265/761 268/760 270/759 272/757 273/756 274/753 276/752 277/749 280/748 282/747 283/741 288/740 290/738 291/734 294/733 296/730 297/729 298/725 300/724 303/723 304/722 305/721 308/720 313/718 314/717 315/711 318/710 324/709 326/708 331/707 333/706 335/703 336/702 337/699 338/696 339/695 342/691 343/689 344/687 350/686 353/684 355/681 356/680 359/679 362/678 363/677 364/676 367/675 368/671 372/670 373/669 375/668 376/667 377/666 378/663 381/662 382/661 384/660 386/657 387/656 388/655 389/653 391/652 392/648 393/647 395/646 396/643 399/641 402/639 403/637 410/632 411/630 412/629 413/628 416/627 417/626 418/625 420/624 421/619 422/617 423/616 426/611 429/610 433/609 434/605 436/604 437/602 439/601 441/600 443/599 444/598 447/596 452/594 455/593 458/592 461/591 462/590 463/589 465/588 468/586 469/585 470/579 471/577 472/576 473/575 475/574 476/573 477/571 478/569 480/568 485/564 486/562 487/561 488/560 491/558 492/557 495/556 496/554 501/552 503/551 505/550 507/548 508/546 511/544 512/543 513/540 516/539 517/537 519/535 521/533 522/530 523/528 526/526
        // (112576
    }

    @Test
    public void test1000naive_0ms() {
        assertEquals(526, solutionNaive(generateIntArray(1000), false));
    }

    @Test
    public void test10000index_200ms() {
        assertEquals(5114, solutionBrutForceIndex(generateIntArray(10000), false, false, true));
    }

    //@Test
    public void test10000_tooLong() {
        assertEquals(5114, solutionBrutForceLambda(generateIntArray(10000), true, false, false));
    }

    @Test
    public void test10000naive_wrong_15ms() {
        assertEquals(5016, solutionNaive(generateIntArray(10000), false));
    }

    //@Test
    public void test100000_tooLong() {
        assertEquals(50037, solutionBrutForceLambda(generateIntArray(100000), true, false, false));
    }

    @Test
    public void test100000naive_13ms_wrong() {
        assertEquals(50024, solutionNaive(generateIntArray(100000), false));
    }

    @Test
    public void test100000index_22s() {
        assertEquals(50037, solutionBrutForceIndex(generateIntArray(100000), false, false, true));
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
