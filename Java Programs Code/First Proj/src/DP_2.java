import java.util.*;

public class DP_2 {

    public static int knapsack(int val[], int wt[], int W, int n) {
        if (W == 0 || n == 0) {
            return 0;
        }

        if (wt[n - 1] <= W) { // valid
            // include
            int ans1 = val[n - 1] + knapsack(val, wt, W - wt[n - 1], n - 1);

            // exclude
            int ans2 = knapsack(val, wt, W, n - 1);

            return Math.max(ans1, ans2);
        } else {

            return knapsack(val, wt, W, n - 1);
        }
    }

    public static int knapsackM(int val[], int wt[], int W, int n, int dp[][]) {
        if (W == 0 || n == 0) {
            return 0;
        }

        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        if (wt[n - 1] <= W) { // valid
            // include
            int ans1 = val[n - 1] + knapsackM(val, wt, W - wt[n - 1], n - 1, dp);

            // exclude
            int ans2 = knapsackM(val, wt, W, n - 1, dp);

            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        } else {

            dp[n][W] = knapsackM(val, wt, W, n - 1, dp);
            return dp[n][W];
        }
    }

    public static int knapsackTab(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                int v = val[i - 1]; // value of ith item
                int w = wt[i - 1]; // weight of ith item
                if (w <= j) {
                    int incPro = v + dp[i - 1][j - w];
                    int excPro = dp[i - 1][w];
                    dp[i][j] = Math.max(incPro, excPro);
                } else {
                    int excPro = dp[i - 1][w];
                    dp[i][j] = excPro;
                }
            }
        }
        return dp[n][W]; // right bottom cell final profit
    }

    public static boolean targetSumSubset(int arr[], int sum) {
        int n = arr.length;
        boolean dp[][] = new boolean[n + 1][sum + 1];
        // complete array already false
        // initilizing true for column one

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                int v = arr[i - 1];
                // include
                if (v <= j && dp[i - 1][j - v] == true) {
                    dp[i][j] = true;
                }
                // exclude
                else if (dp[i - 1][j] == true) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[n][sum];
    }

    public static int unBoundedKnapsack(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j < W + 1; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;

        // System.out.println(knapsack(val, wt, W, wt.length));

        // int dp[][] = new int[val.length + 1][W + 1];
        // for (int i = 0; i < dp.length; i++) {
        // for (int j = 0; j < dp[0].length; j++) {
        // dp[i][j] = -1;
        // }
        // }

        // System.out.println(knapsackM(val, wt, W, wt.length, dp));

        System.out.println(knapsackTab(val, wt, W));

        // int arr[] = { 4, 2, 7, 1, 3 };
        // int sum = 20;

        // System.out.println(targetSumSubset(arr, sum));

        System.out.println(unBoundedKnapsack(val, wt, W));
    }
}
