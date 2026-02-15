import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GreedyAlgo2 {
    // class to create a job object array
    // since objects are defined using class in java i had to create it
    static class Jobs {
        int id;
        int deadline;
        int profit;

        Jobs(int i, int deadline, int profit) {
            this.id = i;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static int jobSequencing(Jobs jobs[]) {

        // sort the jobs array based on 2nd paramter which is profit
        // for greedy approach to work;
        Arrays.sort(jobs, Comparator.comparingInt((Jobs o) -> o.profit).reversed());

        // another method to sort an obj array in descending order
        // this works only on arraylists
        // Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);

        ArrayList<Integer> ans = new ArrayList<>();
        int maxprofit = 0;
        int time = 0;

        for (int i = 0; i < jobs.length; i++) {
            if (time < jobs[i].deadline) {
                time = jobs[i].deadline;
                maxprofit += jobs[i].profit;
                ans.add(jobs[i].id);
            }
        }

        for (int i = 0; i < ans.size(); i++) {
            System.out.print("Job" + (ans.get(i) + 1) + " ");
        }

        System.out.println();

        return maxprofit;
    }

    public static void sort(int arr[]) {

        Arrays.sort(arr);

        int start = 0;
        int end = arr.length - 1;
        int temp;

        while (start < end) {
            temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }

    }

    public static int chocola(int hCost[], int vCost[]) {

        // sort the array in descending order
        sort(vCost);
        sort(hCost);

        int h = 0;
        int v = 0;
        int hPiece = 1;
        int vPiece = 1;
        int minCost = 0;

        while (h < hCost.length && v < vCost.length) {

            if (hCost[h] >= vCost[v]) {
                // calculate horizontal cost and increment horizontal piece as well as increment
                // that pointer
                minCost += vPiece * hCost[h];
                hPiece++;
                h++;
            } else {
                minCost += hPiece * vCost[v];
                vPiece++;
                v++;
            }
        }

        while (h < hCost.length) {
            minCost += vPiece * hCost[h];
            hPiece++;
            h++;
        }

        while (v < vCost.length) {
            minCost += hPiece * vCost[v];
            vPiece++;
            v++;
        }

        return minCost;
    }

    public static void main(String args[]) {

        // // job sequencing problem
        // int[][] jobs = {
        // { 4, 20 },
        // { 1, 10 },
        // { 1, 40 },
        // { 1, 30 }
        // };

        // Jobs j[] = new Jobs[jobs.length];

        // // initialize the object array
        // // jobs[i][0] this is deadline
        // // jobs[i][1] this is profit
        // // i is simply the id of the job A,B,C

        // for (int i = 0; i < j.length; i++) {
        // j[i] = new Jobs(i, jobs[i][0], jobs[i][1]);
        // }

        // int maxProfit = jobSequencing(j);
        // System.out.println(maxProfit);

        // chocola problem
        int horizontalCost[] = { 4, 1, 2 };
        int verticalCost[] = { 2, 1, 3, 1, 4 };
        int minCost = chocola(horizontalCost, verticalCost);
        System.out.println(minCost);

    }
}
