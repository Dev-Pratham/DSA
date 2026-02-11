
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GreedyAlgo {

    // for this approach to work input should be sorted
    public static int activitySelection(int arr1[], int arr2[]) {

        if (arr2.length == 0 && arr1.length == 0) {
            return 0;
        }
        String activityArray[] = new String[arr1.length];
        int lastActivity = arr2[0];
        int activity = 1;
        activityArray[0] = "A1";
        int j = 1;
        for (int i = 1; i < arr1.length; i++) {

            if (arr1[i] >= lastActivity) {
                lastActivity = arr2[i];
                activityArray[j] = "A" + (i + 1);
                activity++;
                j++;
            }

        }

        for (int i = 0; i < j; i++) {
            System.out.println(activityArray[i] + " ");
        }
        return activity;

    }

    // when the output is not sorted
    public static int activitySelection2(int arr1[], int arr2[]) {

        if (arr2.length == 0 && arr1.length == 0) {
            return 0;
        }

        // sorting
        int arr[][] = new int[arr1.length][2];
        for (int i = 0; i < arr1.length; i++) {
            arr[i][0] = arr1[i];
            arr[i][1] = arr2[i];
        }
        // lambda function
        // this sorts the array based on 2nd parameter which is endtime
        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));

        String activityArray[] = new String[arr1.length];
        int lastActivity = arr[0][1];
        int activity = 1;
        activityArray[0] = "A1";
        int j = 1;
        for (int i = 1; i < arr1.length; i++) {

            if (arr[i][0] >= lastActivity) {
                lastActivity = arr[i][1];
                activityArray[j] = "A" + (i + 1);
                activity++;
                j++;
            }

        }

        for (int i = 0; i < j; i++) {
            System.out.println(activityArray[i] + " ");
        }
        return activity;

    }

    // fractional knapsack problem wrong approch
    public static int fractionalKnapsack(int value[], int weights[], int capacity) {

        int maxValue = 0;
        // initialize 2d array for storing value weights and ratio
        double arr[][] = new double[value.length][3];

        for (int i = 0; i < value.length; i++) {
            arr[i][0] = value[i];
            arr[i][1] = weights[i];
            // ratio
            arr[i][2] = value[i] / weights[i];
        }

        // sorted in descending order
        Arrays.sort(arr, Comparator.comparingDouble((double[] a) -> a[2]).reversed());

        // remember we need all items in the bag is item cannot be fully contained
        // its fractional part should be contained

        int initialCapacity = 0;
        int lasIndex = 0;

        for (int i = 0; i < arr.length; i++) {

            if ((initialCapacity + arr[i][1] <= capacity)) {
                initialCapacity += arr[i][1];
                maxValue += arr[i][0];
                lasIndex = i;

            }

        }

        // this approch works but is incorrect because it says that
        // first item which will not fit will always be lastIndex+1
        // which is wrong and doesnot follow greedy approach all decide locally and
        // immeditely

        // some space still be remaining so filling that space with fractal element
        if (initialCapacity != capacity && lasIndex < arr.length - 1) {
            lasIndex++;
            int remainingSpace = capacity - initialCapacity;
            maxValue += remainingSpace * arr[lasIndex][2];
        }

        return maxValue;
    }

    // fractional knapsack problem
    public static int fractionalKnapsack2(int value[], int weights[], int capacity) {

        int maxValue = 0;
        // initialize 2d array for storing value weights and ratio
        double arr[][] = new double[value.length][3];

        for (int i = 0; i < value.length; i++) {
            arr[i][0] = value[i];
            arr[i][1] = weights[i];
            // ratio
            arr[i][2] = value[i] / weights[i];
        }

        // sorted in descending order
        Arrays.sort(arr, Comparator.comparingDouble((double[] a) -> a[2]).reversed());

        // remember we need all items in the bag is item cannot be fully contained
        // its fractional part should be contained

        for (int i = 0; i < arr.length; i++) {
            double cvalue = arr[i][0];
            double cweight = arr[i][1];
            double cratio = arr[i][2];

            if (cweight < capacity) {
                maxValue += cvalue;
                capacity -= cweight;
            } else {
                maxValue += capacity * cratio;
                // knapsack stops after first fraction since now capacity becomes zero
                break;
            }

        }

        return maxValue;
    }

    public static int actiSelectLongestChain(int pairs[][]) {

        if (pairs.length == 0) {
            System.out.println("pairs are empty");
            return -1;
        }

        // array lits is used to store the pairs which can be used in future
        ArrayList<int[]> arr = new ArrayList<>();
        // sorting the pair array based on 2nd parameter
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));
        int lastEnd = pairs[0][1];
        // add the link in arraylist
        arr.add(pairs[0]);
        int link = 1;

        for (int i = 1; i < pairs.length; i++) {
            int start = pairs[i][0];
            int end = pairs[i][1]; // this end defines

            if (lastEnd < start) {
                lastEnd = end;
                // add link in arraylist
                arr.add(pairs[i]);
                link++;
            }
        }

        return link;

    }

    public static void main(String args[]) {

        // activity selection problem
        // int start[] = { 10, 12, 30 };
        // int end[] = { 20, 25, 40 };
        // int activity = activitySelection2(start, end);
        // System.out.println("Total activity: " + activity);

        // fractional knapsack problem
        // int value[] = { 60, 100, 120 };
        // int weights[] = { 10, 20, 30 };
        // int capacity = 50;

        // int fracKnap = fractionalKnapsack2(value, weights, capacity);
        // System.out.println(fracKnap);

        // variation of activity selection
        int pairs[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };
        int lonchain = actiSelectLongestChain(pairs);
        System.out.println(lonchain);

    }
}
