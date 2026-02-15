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
            System.out.print("Job" + (ans.get(i) + 1));
        }

        System.out.println();

        return maxprofit;
    }

    public static void main(String args[]) {

        // job sequencing problem
        int[][] jobs = {
                { 2, 100 },
                { 2, 90 },
                { 1, 80 }
        };

        Jobs j[] = new Jobs[jobs.length];

        // initialize the object array
        // jobs[i][0] this is deadline
        // jobs[i][1] this is profit
        // i is simply the id of the job A,B,C

        for (int i = 0; i < j.length; i++) {
            j[i] = new Jobs(i, jobs[i][0], jobs[i][1]);
        }

        int maxProfit = jobSequencing(j);
        System.out.println(maxProfit);

    }
}
