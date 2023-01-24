package main.java.com.apaliakou.homework02.fibanachifactorial;

public class FacktorialWhileLoop implements Facktorial {

	@Override
	public int returnFacktorial(int n) {
		int factorialResult = 1;
		
		if (n == 0) {
			return factorialResult;
		}		
		
		int m = 1;

		while (m <= n) {
			factorialResult = factorialResult * m;
			m++;
		}

		return factorialResult;
	}

}
