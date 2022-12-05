package main.java.com.apaliakou;

import java.util.SortedMap;

class Data { // создал класс для исходных данных
    void showmenu () { // создал метод отображения исходного меню
        System.out.println(); // добавил пробел
        System.out.println("МЕНЮ ПРОГРАММЫ, ОТВЕЧАЮЩЕЙ НА ЗАПРОС ПОЛЬЗОВАТЕЛЯ: ");
        System.out.println("1. algorithmld - тип алгоритма;");
        System.out.println("2. loopType - тип циклов, которые нужно использовать;");
        System.out.println("3. n - параметр, передаваемый в алгоритм.\n");
    }
    void algorithmld (int firstparagraph) { // создал метод отображения информации пункта 1 исходного меню
         switch (firstparagraph) { // добавил переключатель вариантов информации пункта 1 исходного меню
            case 1: // вариант 1
                System.out.println("1. вычисление ряда чисел Фибоначчи;");
                break;
            case 2: // вариант 2
                System.out.println("2. вычисление факториала.");
                break;
        }
    }
    void loopType (int secondparagraph) { // создал метод отображения информации пункта 2 исходного меню
        switch (secondparagraph) { // добавил переключатель вариантов информации пункта 2 исходного меню
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
}
class Consequent { // создал класс для основных расчетов
public static void main (String[] args) {
    Data object = new Data (); // создал объект для задействования методов при расчетах (ссылок на методы)
    object.showmenu(); // задействовал метод отображения исходного меню (через ссылку на метод)
    for (int i = 0; i < args.length; i++) { // ввел счетчик для ввода значений аргументов через командную строку
        System.out.println("Аргумент № " + i + ": args [" + i + "] = " + args[i]);
    }
    System.out.println();
    int x = Integer.parseInt(args[0]); // создал целочисленные переменные для работы кода (согласно аргументам ввода)
    int y = Integer.parseInt(args[1]);
    int z = Integer.parseInt(args[2]); //
        if (x == 1) { // ввел варианты пункта 2 в соответствии с выбранным пунктом 1 исходного меню (первый аргумент)
            // здесь - расчет последовательности Фибоначчи!!!
            object.algorithmld(1);
            System.out.println();
                switch (y) {
                    case 1: // с использованием цикла while
                    {object.loopType(1);
                        System.out.println();
                        System.out.println("Количество элементов последовательности Фибоначчи: " + z + ".\n");
                        System.out.print("Ряд элементов: 0   1   ");
                        int[] array = new int[z]; // создал массив с количеством элементов z
                        array[0] = 0; // задал фиксированные значения двух первых элементов массива
                        array[1] = 1;
                        int r = 2;
                        while (r <= z) {
                            array[r] = array[r-2] + array[r-1];
                            System.out.print(array [r] + "   ");
                            r++;
                            if (r == z) break;
                        }
                    break;
                    }
                    case 2: // с использованием цикла do-while
                    {object.loopType(2);
                        System.out.println();
                        System.out.println("Количество элементов последовательности Фибоначчи: " + z + ".\n");
                        System.out.print("Ряд элементов: 0   1   ");
                        int[] array = new int[z]; // создал массив с количеством элементов z
                        array[0] = 0; // задал фиксированные значения двух первых элементов массива
                        array[1] = 1;
                        int s = 2;
                        do {
                            array[s] = array[s-2] + array[s-1];
                            System.out.print(array [s] + "   ");
                            s++;
                            if (s == z) break;
                        } while (s <= z);
                        break;
                    }
                    case 3: // с использованием цикла for
                    {object.loopType(3);
                        System.out.println();
                        System.out.println("Количество элементов последовательности Фибоначчи: " + z + ".\n");
                        System.out.print("Ряд элементов: ");
                        int[] array = new int[z]; // создал массив с количеством элементов z
                        array[0] = 0; // задал фиксированные значения двух первых элементов массива
                        array[1] = 1;
                        for (int h = 2; h < z; h++) {
                            array[h] = array[h - 2] + array[h - 1];
                        }
                        for (int k = 0; k < array.length; k++) {
                            System.out.print(array[k] + "   ");
                        }
                        System.out.println();
                    break;
                    }
                }
        }
           else if (x == 2) { // здесь - расчет факториала!!!
               object.algorithmld (2);
               switch (y) {
                   case 1: // с использованием цикла while
                   {object.loopType(1);
                       System.out.println();
                       System.out.println("Колич-во натур. чисел с единицы для расчета факториала: " + z + ".\n");
                       System.out.print("Значение факториала числа " + z + ": ");
                   int factorial1 = 1;
                   int m = 1;
                       if (z < 0) {
                           System.out.println("Error!!! This is not a positive integer!!! Enter a positive number!!!");
                           break;
                       }
                       else if (z == 0) {
                           System.out.println("1.");
                           break;
                       }
                   while (m <= z) {
                       factorial1 = factorial1 * m;
                       m++;
                   }
                       System.out.println(factorial1 + ".");
                   }
                   break;
                   case 2: // с использованием цикла do-while
                   {object.loopType(2);
                   System.out.println();
                   System.out.println("Колич-во натур. чисел с единицы для расчета факториала: " + z + ".\n");
                   System.out.print("Значение факториала числа " + z + ": ");
                   int factorial2 = 1;
                   int n = 1;
                       if (z < 0) {
                           System.out.println("Error!!! This is not a positive integer!!! Enter a positive number!!!");
                           break;
                       }
                       else if (z == 0) {
                           System.out.println("1");
                           break;
                       }
                   do {
                       factorial2 = n * factorial2;
                       n++;
                   } while (n <= z);
                       System.out.println(factorial2 + ".");
                   break;
                   }
                   case 3: // с использованием цикла for
                   {object.loopType(3);
                       System.out.println();
                       System.out.println("Колич-во натур. чисел с единицы для расчета факториала: " + z + ".\n");
                       System.out.print("Значение факториала числа " + z + ": ");
                       int factorial3 = 1;
                       if (z < 0) {
                           System.out.println("Error!!! This is not a positive integer!!! Enter a positive number!!!");
                           break;
                       }
                       else if (z == 0) {
                           System.out.println("1");
                           break;
                       }
                       for (int w = 1; w <= z; w++) {
                           factorial3 *= w;
                       }
                       System.out.println(factorial3 + ".");
                       break;
                   }
               }
           }
}
}
