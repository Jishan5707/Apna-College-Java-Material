import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;

public class Greedy_algo {

    public static class Jobs {
        int deadline;
        int profit;
        int id;

        public Jobs(int i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }
    }

    public static void main(String[] args) {

        // When thw end time is already sorted

        // int start[] = { 1, 3, 0, 5, 8, 5 };
        // int end[] = { 2, 4, 6, 7, 9, 9 };

        // // end time basis sorted array
        // int maxAct = 0;
        // ArrayList<Integer> ans = new ArrayList<>();

        // // 1st activity
        // maxAct = 1; // kitne act hue
        // ans.add(0);// konsi activity hue hai
        // int lastEnd = end[0];
        // for (int i = 1; i < end.length; i++) {
        // if (start[i] >= lastEnd) {
        // // Activity select
        // maxAct++;
        // ans.add(i);
        // lastEnd = end[i];
        // }
        // }
        // System.out.println("Max Activities are = " + maxAct);
        // for (int i = 0; i < ans.size(); i++) {
        // System.out.print("A" + ans.get(i) + " ");
        // }

        // // When unsorted end time is given
        // int start[] = { 1, 3, 0, 5, 8, 5 };
        // int end[] = { 2, 4, 6, 7, 9, 9 };

        // // end time basis sorted array
        // int maxAct = 0;
        // ArrayList<Integer> ans = new ArrayList<>();

        // int activities[][] = new int[start.length][3];
        // for (int i = 0; i < start.length; i++) {
        // activities[i][0] = i;
        // activities[i][1] = start[i];
        // activities[i][2] = end[i];
        // }

        // // lamda function shortform
        // Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        // // 1st activity
        // maxAct = 1; // kitne act hue
        // ans.add(activities[0][0]);// konsi activity hue hai
        // int lastEnd = activities[0][2];
        // for (int i = 1; i < end.length; i++) {
        // if (start[i] >= lastEnd) {
        // // Activity select
        // maxAct++;
        // ans.add(activities[i][0]);
        // lastEnd = activities[i][2];
        // }
        // }
        // System.out.println("Max Activities are = " + maxAct);
        // for (int i = 0; i < ans.size(); i++) {
        // System.out.print("A" + ans.get(i) + " ");
        // }

        // // Fractional Knapsack Question
        // int val[] = { 60, 100, 120 };
        // int weight[] = { 10, 20, 30 };
        // int w = 50;

        // double ratio[][] = new double[val.length][2]; // 2 colms 1 for index 1 for
        // ratio
        // // 0th col idx 1st col ratio
        // for (int i = 0; i < val.length; i++) {
        // ratio[i][0] = i;
        // ratio[i][1] = val[i] / (double) weight[i];
        // }

        // Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        // int capacity = w;
        // int finalVal = 0;
        // for (int i = ratio.length - 1; i >= 0; i--) {
        // int idx = (int) ratio[i][0];
        // if (capacity >= weight[idx]) {
        // finalVal += val[idx];
        // capacity -= weight[idx];
        // } else {
        // // include fractional items
        // finalVal += (ratio[i][1] * capacity);
        // capacity = 0;
        // break;
        // }
        // }
        // System.out.println("Final value = " + finalVal);

        // //Minimum Absolute sum Question
        // int A[] = { 1, 2, 3 };
        // int B[] = { 2, 1, 3 };

        // Arrays.sort(A);
        // Arrays.sort(B);

        // int minDiff = 0;

        // for (int i = 0; i < A.length; i++) {
        // minDiff += Math.abs(A[i] - B[i]);
        // }
        // System.out.println(minDiff);

        // // MAX length chain of pairs
        // int pairs[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };

        // Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        // int chainlength = 1;
        // int lastPairEnd = pairs[0][1]; // last selected pair end
        // for (int i = 1; i < pairs.length; i++) {
        // if (pairs[i][0] > lastPairEnd) {
        // chainlength++;
        // lastPairEnd = pairs[i][1];
        // }
        // }

        // System.out.println("Max length of chain = " + chainlength);

        // // Indian coins Question
        // Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        // Arrays.sort(coins, Comparator.reverseOrder());

        // int amount = 1059;
        // int count = 0;
        // for (int i = 0; i < coins.length; i++) {
        // if (coins[i] <= amount) {
        // while (coins[i] <= amount) {
        // count++;
        // amount -= coins[i];
        // }
        // }
        // }

        // System.out.println(count);

        // // Jobs sequencing problem

        // int jobsInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };

        // ArrayList<Jobs> jobs = new ArrayList<>();

        // for (int i = 0; i < jobsInfo.length; i++) {
        // jobs.add(new Jobs(i, jobsInfo[i][0], jobsInfo[i][1]));
        // }

        // Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);
        // // descending order of profit

        // ArrayList<Integer> seq = new ArrayList<>();
        // int time = 0;
        // for (int i = 0; i < jobs.size(); i++) {
        // Jobs curr = jobs.get(i);
        // if (curr.deadline > time) {
        // seq.add(curr.id);
        // time++;
        // }
        // }
        // System.out.println("max jobs = " + seq.size());
        // for (int i = 0; i < seq.size(); i++) {
        // System.out.println(seq.get(i) + " ");
        // }
        // System.err.println();

        int n = 4;
        int m = 6;
        Integer costver[] = { 2, 1, 3, 1, 4 };
        Integer costhor[] = { 4, 1, 2 };

        Arrays.sort(costver, Collections.reverseOrder());
        Arrays.sort(costhor, Collections.reverseOrder());

        int h = 0;
        int v = 0;
        int hp = 1;
        int vp = 1;
        int cost = 0;
        while (h < costhor.length && v < costver.length) {
            if (costver[v] <= costhor[h]) {
                cost += (costhor[h] * vp);
                hp++;
                h++;
            } else {
                cost += (costver[v] * hp);
                vp++;
                v++;
            }
        }
        while (h < costhor.length) {
            cost += (costhor[h] * vp);
            hp++;
            h++;
        }
        while (v < costver.length) {
            cost += (costver[v] * hp);
            vp++;
            v++;
        }

        System.out.println("Min cost = " + cost);
    }
}
