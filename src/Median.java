import java.util.Arrays;

public class Median {
    public static void main(String[] args) {
        int[] integerValues = {33, 44, 55, 66, 77, 88, 99, 110, 120, 130, 35};
        double[] doubleValues = {33.33, 44.44, 55.55, 66.66, 77.77, 88.88, 99.99, 110.110, 120.120, 130.130, 35.35};
        System.out.println(Arrays.toString(integerValues));
        System.out.println(Arrays.toString(doubleValues));
        int y = integerValues.length / 2;
        int z = doubleValues.length / 2;
        for (int x = 0; x < integerValues.length; x++) {
            if (x <= y) {
                System.out.println("The median integer array value is: " + integerValues[y]);
                break;
            }
        }
        for (int i = 0; i < doubleValues.length; i++) {
            if (i <= z) {
                System.out.println("The median double array value is: " + doubleValues[z]);
                break;
            }
        }
    }
}
