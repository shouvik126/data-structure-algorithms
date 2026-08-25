class Solution {
    static int perfectSum(int[] arr, int target) {
        // code here
        int n = arr.length;
        int[][] dp = new int[n + 1][target + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return solve(n, target, arr, dp);
    }
    public static int solve(int n, int target, int[] arr, int[][] dp) {
        if (n == 0) {
            return target == 0 ? 1 : 0;
        }
        if (dp[n][target] != -1) {
            return dp[n][target];
        }
        
        int skip = solve(n - 1, target, arr, dp);
        int take = 0;
        if (arr[n - 1] <= target) {
            take = solve(n - 1, target - arr[n - 1], arr, dp);
        }
        return dp[n][target] = skip + take;
    }
}