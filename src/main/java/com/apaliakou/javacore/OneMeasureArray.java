/* ОТРАБОТКА МАССИВОВ
 */
import java.util.Arrays;
public class OneMeasureArray {
    public static void main(String[] args) {
        int [] array = {678, 45, 10, 1049, 257}; // создал простой одномерный массив для отработки операций с ним
        // (отображение, сортировка, определение индекса
        System.out.println(array);
        System.out.println(Arrays.toString(array));
        Arrays.sort (array, 0, 5);
        System.out.println(Arrays.toString(array));
        int sequence = Arrays.binarySearch(array, 3);
        System.out.println(array [3]);
        int [][] bigarray = { {356, 75, 12} , {674, 35, 17} }; // создал двумерный массив для отработки его
        // отображения в один ряд через символ
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print((bigarray [i] [j] + " | "));}
    }
        System.out.println("\n");
        String [] array3 = {"СТОЛБЕЦ 1", "СТОЛБЕЦ 2", "СТОЛБЕЦ 3"}; // создал одномерный массив типа String
        System.out.println(Arrays.toString(array3));
        System.out.println();
        int key0 = Arrays.binarySearch(array3, 0);
        System.out.print(key0 + "   ");
        int key1 = Arrays.binarySearch(array3, 1);
        System.out.print(key1 + "   ");
        int key2 = Arrays.binarySearch(array3, 2);
        System.out.print(key2 + "   ");
        int [][] array4 = new int[2][3]; // создал двумерный массив для построения таблицы из двух строк и трех столбцов
        array4 [0][0]= 10;
        array4 [0][1]= 20;
        array4 [0][2]= 30;
        array4 [1][0]= 55;
        array4 [1][1]= 66;
        array4 [1][2]= 77;
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    System.out.print(array4 [i] [j] + "  ");}
                if (j == 1) {
                    System.out.print(array4 [i] [j] + "  ");}
                if (j == 2) {
                    System.out.println(array4 [i] [j] + "  ");}
        }
        }
    }