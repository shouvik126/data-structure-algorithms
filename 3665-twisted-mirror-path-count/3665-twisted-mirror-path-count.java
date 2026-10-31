class Solution {
    int LEFT = 0;
    int UP = 1;
    int m;
    int n;
    int MOD = 1_000_000_007;
    int solve (int[][] grid, int i, int j, int cameFrom, int[][][] dp) {
        if (i >= m || j >= n) {
            return 0;
        }
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (dp[i][j][cameFrom] != -1) {
            return dp[i][j][cameFrom];
        }
        if (grid[i][j] == 1) {
            if (cameFrom == LEFT) {
                return dp[i][j][cameFrom] = solve(grid, i + 1, j, UP, dp);
            } else {
                return dp[i][j][cameFrom] = solve(grid, i, j + 1, LEFT, dp);
            }
        }
        int totalPathCount = 0;
        totalPathCount = (totalPathCount + solve(grid, i, j + 1, LEFT, dp)) % MOD;
        totalPathCount = (totalPathCount + solve(grid, i + 1, j, UP, dp)) % MOD;
        return dp[i][j][cameFrom] = totalPathCount;
    }
    public int uniquePaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int[][][] dp = new int[m + 1][n + 1][2];
        for (int[][] dd : dp) {
            for (int[] d : dd) {
                Arrays.fill(d, -1);
            }
        }
        return solve(grid, 0, 0, LEFT, dp);
    }
}