class Solution {
    /* public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        int[][] dp = new int[n][n];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        int p1 = solve(0, n - 1, nums, dp);
        int p2 = sum - p1;
        return p1 >= p2;
    }

    int solve (int i, int j, int[] nums, int[][] dp) {
        
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return nums[i];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int take_i = nums[i] + Math.min(solve(i + 2, j, nums, dp), solve(i + 1, j - 1, nums, dp));
        int take_j = nums[j] + Math.min(solve(i + 1, j - 1, nums, dp), solve(i, j - 2, nums, dp));
        return dp[i][j] = Math.max(take_i, take_j);
    } */


// Approach - 2

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        int[][] dp = new int[n][n];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        int diff = solve(0, n - 1, nums, dp);
        return diff >= 0;
    }

    int solve (int i, int j, int[] nums, int[][] dp) {
        
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return nums[i];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int take_i = nums[i] - solve(i + 1, j, nums, dp);
        int take_j = nums[j] - solve(i, j - 1, nums, dp);
        return dp[i][j] = Math.max(take_i, take_j);
    }
}