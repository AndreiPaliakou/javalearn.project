package main.java.com.apaliakou.homework02.fibanachifactorial;

public class FibonachiForLoop implements Fibonachi {

	@Override
	public int[] returnFibonachi(int n) {
		int[] array = new int[n];
		array[0] = 0;
		array[1] = 1;
		
		for (int h = 2; h < n; h++) {
			array[h] = array[h - 2] + array[h - 1];
		}
		
		return array;
	}

}
