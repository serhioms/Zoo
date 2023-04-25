package my;

public class TestStringBuilderPerfomance {

	public static void main(String[] args) {
        int MAX = 10_000;

        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder(MAX);
        for (int i = 0; i < MAX; i++) {
            sb.append(i);
        }

        String test = sb.toString();
        long endTime = System.nanoTime();
        test = null;

        System.out.printf("StringBuilder: %09d nano sec\n", (endTime - startTime));

        startTime = System.nanoTime();

        String test2 = "";
        for (int i = 0; i < MAX; i++) {
            test2 += i;
        }
        endTime = System.nanoTime();
        test2 = null;
        
        System.out.printf("String+String: %09d nano sec\n", (endTime - startTime));
  }

}
