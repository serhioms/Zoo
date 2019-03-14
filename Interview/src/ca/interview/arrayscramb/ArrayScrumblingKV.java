package ca.interview.arrayscramb;

import java.util.Arrays;
import java.util.Random;

public class ArrayScrumblingKV {

	public static void main(String[] args) {
		long total = -System.currentTimeMillis();
		
		long NL=1000000;
		int N=1000000;
		int[] data = null;
	
		Random rand = new Random();
		for(int t=0; t<1000; t++){
	
			// Однопроходный алгоритм перемешивания целых от 1 до N
			data = new int[N];
			for(int i=0,next=0; i<N; i++){
				data[i] = ++next;
			}
			for(long i=0,max=NL; i<max; i++){
				int alfa = rand.nextInt(N)%100;

				int omega = rand.nextInt(N)%100;

				int zap=data[omega];

				data[omega]=data[alfa];

				data[alfa]=zap;
			}
			// Конец алгоритма
			
		}
		total += System.currentTimeMillis();
		
		// Total=31.81 mls for N=1'000'000
		System.out.printf("Total=%.2f mls\n", total/1000.0);
		
		// [10, 9, 7, 1, 6, 2, 5, 3, 8, 4] for N=10
		//System.out.println(Arrays.toString(data));
	}
}
