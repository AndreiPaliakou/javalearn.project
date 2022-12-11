package com.apaliakou.view;

public class View {

	public void showMenu() {
		System.out.println();
		System.out.println("МЕНЮ ПРОГРАММЫ, ОТВЕЧАЮЩЕЙ НА ЗАПРОС ПОЛЬЗОВАТЕЛЯ: ");
		System.out.println("1. algorithmld - тип алгоритма;");
		System.out.println("2. loopType - тип циклов, которые нужно использовать;");
		System.out.println("3. n - параметр, передаваемый в алгоритм." + System.lineSeparator());
	}

	public void showAlgorithmType(int algorithmType) {
		switch (algorithmType) {
		case 1:
			System.out.println("1. вычисление ряда чисел Фибоначчи;");
			break;
		case 2:
			System.out.println("2. вычисление факториала.");
			break;
		}
	}

	public void showFibonachiResult(int count, int[] result) {
		System.out.println();
		System.out.println("Количество элементов последовательности Фибоначчи: " + count + ".\n");
		System.out.print("Ряд элементов: 0   1   ");
		
		for (int i = 0; i < result.length; i++) {
			if (i == 0) {
				System.out.print("Ряд элементов: 0   ");
			} else if (i == 1) {
				System.out.print("1   ");
			} else {
				System.out.print(result[i] + "   ");
			}
		}
	}
	
	public void showFacktorialResult(int value, int factorialResult) {
		 System.out.println();
         System.out.println("Колич-во натур. чисел с единицы для расчета факториала: " + value + ".\n");
         System.out.print("Значение факториала числа " + value + ": ");
         System.out.println(factorialResult + ".");
	}
	
}
