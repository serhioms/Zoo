package ca.java.objects.stringbuilder;

public class TestStringBuilder {

	public static void main(String[] args) {
        int MAX = 10_000;

        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder(MAX);
        for (int i = 0; i < MAX; i++) {
            sb.append(i);
        }
        
        // sb.codePoints();
        // sb.chars()
        // sb.getChars(srcBegin, srcEnd, dst, dstBegin);
        // *** as String!
        
        String test = sb.toString();
        test = null;

        System.out.println("StringBuilder Test ------------------------------------");
        System.out.printf("Time elapsed: %,d nano sec\n", (System.nanoTime() - startTime));

        startTime = System.nanoTime();

        String test2 = "";
        for (int i = 0; i < MAX; i++) {
            test2 += i;
        }

        test2 = null;
        
        System.out.println("StringBuilder Test ------------------------------------");
        System.out.printf("Time elapsed: %,d nano sec\n", (System.nanoTime() - startTime));
  }

}
