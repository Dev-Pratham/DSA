import java.util.ArrayList;
import java.util.Arrays;

public class test {

    public static int min(int a, int b) {

        return a < b ? a : b;
    }

    public static int mostWater(ArrayList<Integer> height) {

        int leftPointer = 0;
        int rightPointer = height.size() - 1;
        int largestVolume = Integer.MIN_VALUE;
        while (leftPointer < rightPointer) {
            int width = rightPointer - leftPointer;
            int containerHeight = min(height.get(rightPointer), height.get(leftPointer));
            int water = width * containerHeight;

            if (largestVolume < water) {
                largestVolume = water;
            }

            if (height.get(leftPointer) < height.get(rightPointer)) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }

        return largestVolume;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>(Arrays.asList(1, 8, 6, 2, 5, 4, 8, 3, 7));
        int resultMaxWater2 = mostWater(height);
        System.out.println(resultMaxWater2);

    }
}
