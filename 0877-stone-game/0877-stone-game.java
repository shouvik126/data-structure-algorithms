class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        int diff = solve(0, n - 1, piles, dp);
        return diff > 0;
    }

    int solve(int i, int j, int[] piles, int[][] dp) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return piles[i];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int take_i = piles[i] - solve(i + 1, j, piles, dp);
        int take_j = piles[j] = solve(i, j - 1, piles, dp);
        return dp[i][j] = Math.max(take_i, take_j);
    }
}