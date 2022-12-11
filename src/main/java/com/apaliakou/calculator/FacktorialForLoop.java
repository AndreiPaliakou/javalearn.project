package com.apaliakou.calculator;

public class FacktorialForLoop implements Facktorial {

	@Override
	public int returnFacktorial(int n) {
        int factorialResult = 1;
        if (n == 0) {
            return factorialResult;
        }
        
        for (int w = 1; w <= n; w++) {
        	factorialResult *= w;
        }
        
        return factorialResult;
	}
	
}
