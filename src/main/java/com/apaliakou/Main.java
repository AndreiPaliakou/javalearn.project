package com.apaliakou;

import com.apaliakou.calculator.Facktorial;
import com.apaliakou.calculator.FacktorialDoWhileLoop;
import com.apaliakou.calculator.FacktorialForLoop;
import com.apaliakou.calculator.FacktorialWhileLoop;
import com.apaliakou.calculator.Fibonachi;
import com.apaliakou.calculator.FibonachiDoWhileLoop;
import com.apaliakou.calculator.FibonachiForLoop;
import com.apaliakou.calculator.FibonachiWhileLoop;
import com.apaliakou.view.View;

public class Main {
	public static void main(String[] args) {
		//Разделяем логику в нашем маленьком приложении и пользуемся преимуществами ООП
		//Оделяем логику расчетов от представления. Класс main можно условно считать контроллером.
		//Здесь (в main) происходит принятие решения выборе логики и представления результата.
		
		//Получаем исходные данные. Здесь они не валидируются и это минус!
		int algorithmType = Integer.parseInt(args[0]);
		int loopType = Integer.parseInt(args[1]);
		int n = Integer.parseInt(args[2]);

		//Класс View служит для отображения полученных при расчетах даннных и начального  меню.
		View view = new View();
		view.showMenu();
		view.showAlgorithmType(algorithmType);

		//Для построения различных вариантов рвсчета факториала и чисел Фибоначи используем паттерн проектирования "Простая фабрика"
		//https://refactoring.guru/ru/design-patterns/factory-comparison  см. п. 4
		if (algorithmType == 1) {
			int[] result = null;
			Fibonachi fibonachi = null;
			
			switch (loopType) {
			case 1:
				fibonachi = new FibonachiWhileLoop();
				break;
			case 2:
				fibonachi = new FibonachiDoWhileLoop();
				break;
			case 3:
				fibonachi = new FibonachiForLoop();
				break;
			}

			result = fibonachi.returnFibonachi(n);
			if (result != null) {
				view.showFibonachiResult(n, result);
			}
		}

		if (algorithmType == 2) {
			int result = 0;
			Facktorial facktorial = null;
			switch (loopType) {
			case 1:
				facktorial = new FacktorialWhileLoop();
				break;
			case 2:
				facktorial = new FacktorialDoWhileLoop();
				break;
			case 3:
				facktorial = new FacktorialForLoop();
				break;
			}

			result = facktorial.returnFacktorial(n);
			if (result != 0) {
				view.showFacktorialResult(n, result);
			}
		}
	}
}