package interview.arrayscramb;

import java.util.Random;

public class ArrayScrumbling {

	public static void main(String[] args) {
		long total = -System.currentTimeMillis();
		
		int N=1000000;
		int[] n = null;
	
		Random rand = new Random();
		for(int t=0; t<1000; t++){
	
			// Однопроходный алгоритм перемешивания целых от 1 до N
			n = new int[N];
			for(int i=0,next=0,r; i<N; ){
				r=rand.nextInt(N);
				n[i] = n[r]; 
				n[r] = ++next;
				for(; i<N && n[i]!=0; i++);
			}
			// Конец алгоритма
			
		}
		total += System.currentTimeMillis();
		
		// Total=31.81 mls for N=1'000'000
		System.out.printf("Total=%.2f mls\n", total/1000.0);
		
		// [10, 9, 7, 1, 6, 2, 5, 3, 8, 4] for N=10
		// System.out.println(Arrays.toString(n));
	}
}
