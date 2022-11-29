package main.java.com.apaliakou;

public class Consequent {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("Аргумент № " + i + ": args [" + i + "] = " + args[i] + "    \n\n");
        }
        int x = Integer.parseInt(args[0]); // the first number (input)
        int y = Integer.parseInt(args[1]); // the second number (input)
        int z = Integer.parseInt(args[2]); // the third number (input)
        int[] array = new int[z];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < z; i++) {
            array[i] = array[i - 2] + array[i - 1];
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
    }
}
