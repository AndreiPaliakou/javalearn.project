package main.java.com.apaliakou.homework02.fibanachifactorial;

public class FibonachiWhileLoop implements Fibonachi {

	@Override
	public int[] returnFibonachi(int n) {
		 int[] arrayResult = new int[n];
		 arrayResult[0] = 0; 
		 arrayResult[1] = 1;
         int r = 2;
         while (r < n) {
        	 arrayResult[r] = arrayResult[r-2] + arrayResult[r-1];
             r++;
         }
         
         return arrayResult;
	}

}
