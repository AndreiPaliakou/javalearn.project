package com.apaliakou.calculator;

public class FacktorialDoWhileLoop implements Facktorial {

	@Override
	public int returnFacktorial(int n) {
		int factorialResult = 1;

		if (n == 0) {
			return factorialResult;
		}

		int z = 1;

		do {
			factorialResult = z * factorialResult;
			z++;
		} while (z <= n);
		
		return factorialResult;
	}

}
