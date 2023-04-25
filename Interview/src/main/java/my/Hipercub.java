package my;

public class Hipercub {

	public static void main(String[] args) {
		double n = 14;
		double m = n-1;
		double GraneyN1, Vershin;

		GraneyN1 = fact(n) / (fact(m) * fact(n - m)) * Math.pow(2, n - m); /* вычисление кол-ва n-1 граней */
		Vershin = Math.pow(2, n);

		m = n-2;
		double GraneyN2 = 0;
		if( m >= 1) {
			GraneyN2 = fact(n) / (fact(m) * fact(n - m)) * Math.pow(2, n - m); /* вычисление кол-ва n-2 граней */
		}
		
		
		System.out.printf("m=%f  GraneyN1=%f  GraneyN2=%f  Vershin=%f\n", m, GraneyN1, GraneyN2, Vershin);
		System.out.printf("n=%f  Sosedey=%f\n", n, GraneyN1+GraneyN2+Vershin);
	}

	static double fact(double N) {
		double output;
		if (N == 0)
			output = 1;
		else
			output = fact(N - 1) * N;
		return output;
	}
}
