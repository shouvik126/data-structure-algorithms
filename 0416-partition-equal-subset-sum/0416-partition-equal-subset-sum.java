class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int[][] dp = new int[201][20001];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        for (int val : nums) {
            sum += val;
        }
        if (sum % 2 != 0) {
            return false;
        }
        return findSubsetSum(nums.length, sum / 2, nums, dp);
    }

    public boolean findSubsetSum(int i, int sum, int[] nums, int[][] dp) {
        if (i == 0) {
            return false;
        }
        if (sum == 0) {
            return true;
        }
        if (dp[i][sum] != -1) {
            return dp[i][sum] == 1;
        }
        boolean skip = findSubsetSum(i - 1, sum, nums, dp);
        boolean take = false;
        if (nums[i - 1] <= sum) {
            take = findSubsetSum(i - 1, sum - nums[i - 1], nums, dp);
        }
        dp[i][sum] = skip || take ? 1 : 0;
        return skip || take;
    }
}