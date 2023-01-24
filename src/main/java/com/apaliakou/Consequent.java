package main.java.com.apaliakou;

class Consequent {
    public static void main(String[] args) {
        DisplayInformationUtil displayInformationUtil = new DisplayInformationUtil();
        displayInformationUtil.showMenu();
        displayInformationUtil.displayArgs(args);

        int functionType = Integer.parseInt(args[0]);
        int loopType = Integer.parseInt(args[1]);
        int functionArgument = Integer.parseInt(args[2]);

        if (functionType == 1) {
            displayInformationUtil.displayFunctionType(1);

            switch (loopType) {
                case 1: {
                    displayInformationUtil.displayLoopType(1);
                    if (functionArgument <= 2) {
                        System.out.println("Error!!! Enter args [2] = 3 or more !!!");
                        break;
                    }
                    displayFibonachiWithWhileLoop(displayInformationUtil, functionArgument);
                    break;
                }
                case 2: {
                    displayInformationUtil.displayLoopType(2);
                    if (functionArgument <= 2) {
                        System.out.println("Error!!! Enter args [2] = 3 or more !!!");
                        break;
                    }
                    displayFibonachiWithDoWhileLoop(displayInformationUtil, functionArgument);
                    break;
                }
                case 3: {
                    displayInformationUtil.displayLoopType(3);
                    if (functionArgument <= 2) {
                        System.out.println("Error!!! Enter args [2] = 3 or more !!!");
                        break;
                    }
                    displayFibonachiWithForLoop(displayInformationUtil, functionArgument);
                    break;
                }
            }
        } else if (functionType == 2) {
            displayInformationUtil.displayFunctionType(2);

            switch (loopType) {
                case 1: {
                    displayInformationUtil.displayLoopType(1);
                    if (functionArgument < 0) {
                        System.out.println("Error!!! This is not a positive integer!!! Enter a positive args [2]!!!");
                        break;
                    } else if (functionArgument == 0) {
                        System.out.println("Факториал нуля равен 1.");
                        break;
                    }
                    displayFactorialWithWhileLoop(displayInformationUtil, functionArgument);
                    break;
                }
                case 2: {
                    displayInformationUtil.displayLoopType(2);
                    if (functionArgument < 0) {
                        System.out.println("Error!!! This is not a positive integer!!! Enter a positive args [2]!!!");
                        break;
                    } else if (functionArgument == 0) {
                        System.out.println("Факториал нуля равен 1.");
                        break;
                    }
                    displayFactorialWithDoWhileLoop(displayInformationUtil, functionArgument);
                    break;
                }

                case 3: {
                    displayInformationUtil.displayLoopType(3);
                    if (functionArgument < 0) {
                        System.out.println("Error!!! This is not a positive integer!!! Enter a positive args [2]!!!");
                        break;
                    } else if (functionArgument == 0) {
                        System.out.println("Факториал нуля равен 1.");
                        break;
                    }
                    displayFactorialWithForLoop(displayInformationUtil, functionArgument);
                    break;
                }
            }
        }
    }

    private static void displayFibonachiWithWhileLoop(DisplayInformationUtil displayInformationUtil, int functionArgument) {
        System.out.println();
        System.out.println("Количество элементов последовательности Фибоначчи: " + functionArgument + ".\n");
        System.out.print("Ряд элементов: 0   1   ");
        int[] array = new int[functionArgument];
        array[0] = 0;
        array[1] = 1;
        int r = 2;
        while (r < functionArgument) {
            array[r] = array[r - 2] + array[r - 1];
            System.out.print(array[r] + "   ");
            r++;
        }
    }

    private static void displayFibonachiWithDoWhileLoop(DisplayInformationUtil displayInformationUtil, int functionArgument) {
        System.out.println();
        System.out.println("Количество элементов последовательности Фибоначчи: " + functionArgument + ".\n");
        System.out.print("Ряд элементов: 0   1   ");
        int[] array = new int[functionArgument];
        array[0] = 0;
        array[1] = 1;
        int s = 2;
        do {
            array[s] = array[s - 2] + array[s - 1];
            System.out.print(array[s] + "   ");
            s++;
        } while (s < functionArgument);
    }

    private static void displayFibonachiWithForLoop(DisplayInformationUtil displayInformationUtil, int functionArgument) {
        System.out.println();
        System.out.println("Количество элементов последовательности Фибоначчи: " + functionArgument + ".\n");
        System.out.print("Ряд элементов: ");
        int[] array = new int[functionArgument];
        array[0] = 0;
        array[1] = 1;
        for (int h = 2; h < functionArgument; h++) {
            array[h] = array[h - 2] + array[h - 1];
        }
        for (int k = 0; k < array.length; k++) {
            System.out.print(array[k] + "   ");
        }
        System.out.println();
    }

    private static void displayFactorialWithWhileLoop(DisplayInformationUtil displayInformationUtil, int functionArgument) {
        System.out.println();
        System.out.println("Колич-во натур. чисел с единицы для расчета факториала: " + functionArgument + ".\n");
        System.out.print("Значение факториала числа " + functionArgument + ": ");
        int factorial = 1;
        int counter = 1;
        while (counter <= functionArgument) {
            factorial = factorial * counter;
            counter++;
        }
        System.out.println(factorial + ".");
    }

    private static void displayFactorialWithDoWhileLoop(DisplayInformationUtil displayInformationUtil, int functionArgument) {
        System.out.println();
        System.out.println("Колич-во натур. чисел с единицы для расчета факториала: " + functionArgument + ".\n");
        System.out.print("Значение факториала числа " + functionArgument + ": ");
        int factorial = 1;
        int counter = 1;
        do {
            factorial = factorial * counter;
            counter++;
        } while (counter <= functionArgument);
        System.out.println(factorial + ".");
    }

    private static void displayFactorialWithForLoop(DisplayInformationUtil displayInformationUtil, int functionArgument) {
        System.out.println();
        System.out.println("Колич-во натур. чисел с единицы для расчета факториала: " + functionArgument + ".\n");
        System.out.print("Значение факториала числа " + functionArgument + ": ");
        int factorial = 1;
        for (int w = 1; w <= functionArgument; w++) {
            factorial *= w;
        }
        System.out.println(factorial + ".");
    }
}