import java.util.Arrays;

public class MainForMedian {
    public static void main(String[] args) {
        int[] integerValues = {44, 55, 66, 77, 88, 99, 110, 120, 130, 35};
        double[] doubleValues = {33.33, 44.44, 55.55, 66.66, 77.77, 88.88, 99.99, 110.110, 120.120, 130.130, 35.35};
        System.out.println(Arrays.toString(integerValues));
        System.out.println(Arrays.toString(doubleValues));

        int medianResult = Median.median(integerValues);

        System.out.println(medianResult);

    }
}