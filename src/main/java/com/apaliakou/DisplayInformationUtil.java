package main.java.com.apaliakou;

class DisplayInformationUtil { // создал класс для исходных данных
    public void showMenu() { // создал метод отображения исходного меню
        System.out.println(); // добавил пробел
        System.out.println("МЕНЮ ПРОГРАММЫ, ОТВЕЧАЮЩЕЙ НА ЗАПРОС ПОЛЬЗОВАТЕЛЯ: ");
        System.out.println("1. algorithmld - тип алгоритма;");
        System.out.println("2. loopType - тип циклов, которые нужно использовать;");
        System.out.println("3. n - параметр, передаваемый в алгоритм.\n");
    }

    public void displayFunctionType(int functionType) {
        switch (functionType) { // добавил переключатель вариантов информации пункта 1 исходного меню
            case 1: // вариант 1
                System.out.println("1. вычисление ряда чисел Фибоначчи;");
                break;
            case 2: // вариант 2
                System.out.println("2. вычисление факториала.");
                break;
        }
    }

    public void displayLoopType(int loopType) { // создал метод отображения информации пункта 2 исходного меню
        switch (loopType) { // добавил переключатель вариантов информации пункта 2 исходного меню
            case 1: // вариант 1
                System.out.println("1. цикл while;");
                break;
            case 2: // вариант 2
                System.out.println("2. цикл do-while;");
                break;
            case 3: // вариант 3
                System.out.println("3. цикл for.");
                break;
        }
    }

    public void displayArgs(String[] args) {
        for (int i = 0; i < args.length; i++) { // ввел счетчик для ввода значений аргументов через командную строку
            System.out.println("Аргумент № " + i + ": args [" + i + "] = " + args[i]);
        }
        System.out.println();
    }
}
