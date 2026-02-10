
public class GreedyAlgo {

    public static int activitySelection(int arr1[], int arr2[]) {

        if (arr2.length == 0 && arr1.length == 0) {
            return 0;
        }

        int lastActivity = arr2[0];
        int activity = 1;
        for (int i = 1; i < arr1.length; i++) {

            if (arr1[i] >= lastActivity) {
                lastActivity = arr2[i];
                activity++;
            }

        }

        return activity;

    }

    public static void main(String args[]) {

        // activity selection problem
        int start[] = { 10, 12, 30 };
        int end[] = { 20, 25, 40 };
        int activity = activitySelection(start, end);
        System.out.println("Total activity: " + activity);

    }
}
