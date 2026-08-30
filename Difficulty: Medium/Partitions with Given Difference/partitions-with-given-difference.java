class Solution {
    public int countPartitions(int[] arr, int diff) {
        // code here
        int sum = 0;
        for (int val : arr) {
            sum += val;
        }
        int target = (sum + diff) / 2;
        if ((sum + diff) % 2 != 0) {
            return 0;
        }
        int[][] dp = new int[1001][1001];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return solve (arr.length, arr, target, dp);
    }
    public int solve (int n, int[] arr, int target, int[][] dp) {
        if (n == 0) {
            return target == 0 ? 1 : 0;
        }
        if (dp[n][target] != -1) {
            return dp[n][target];
        }
        
        int skip = solve(n - 1, arr, target, dp);
        int take = 0;
        if (arr[n - 1] <= target) {
            take = solve(n - 1, arr, target - arr[n - 1], dp);
        }
        return dp[n][target] = (skip + take);
    }
}
