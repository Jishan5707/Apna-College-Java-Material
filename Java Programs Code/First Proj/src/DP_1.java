import java.util.*;

public class DP_1 {
    public static int fib(int n, int f[]) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (f[n] != 0) {
            return f[n];
        }
        f[n] = fib(n - 1, f) + fib(n - 2, f);
        return f[n];
    }

    public static int fibTab(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // Climbing Stairs Problem

    public static int countWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        return countWays(n - 1) + countWays(n - 2);
    }

    // Climbing Stairs by memoization

    public static int countWaysM(int n, int ways[]) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if ((ways[n] > 0)) {
            return ways[n];
        } else {
            ways[n] = countWaysM(n - 1, ways) + countWaysM(n - 2, ways);
            return ways[n];
        }
    }

    public static int countWaysTab(int n) {
        int dp[] = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        // int n = 10;
        // int f[] = new int[n + 1];
        // System.out.println(fib(n, f));
        // System.out.println(fibTab(n));

        int n = 20;
        // System.out.println(countWays(n));
        int ways[] = new int[n + 1];
        // Arrays.fill(ways, -1);
        System.out.println(countWaysM(n, ways));
        System.out.println(countWaysTab(n));
    }
}
