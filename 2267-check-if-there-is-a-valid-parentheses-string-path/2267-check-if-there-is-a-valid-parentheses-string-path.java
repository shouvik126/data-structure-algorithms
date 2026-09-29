class Solution {
    int m, n;
    int dp[][][];
    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(')
            return false;

        if ((m + n - 1) % 2 != 0) {
            return false;
        }
        dp = new int[101][101][201];
        for (int[][] dd : dp) {
            for (int[] d : dd) {
                Arrays.fill(d, -1);
            }
        }
        return solve(0, 0, 0, grid);
    }
    public boolean solve(int i, int j, int openCount, char[][] grid) {
        openCount += (grid[i][j] == '(') ? 1 : -1;
        if (openCount < 0) {
            return false;
        }
        if (dp[i][j][openCount] != -1) {
            return dp[i][j][openCount] == 1;
        }
        if (i == m-1 && j == n-1) {
            dp[i][j][openCount] = openCount == 0 ? 1 : 0;
            return dp[i][j][openCount] == 1;
        }
        
        if (i + 1 < m && solve(i + 1, j, openCount, grid) == true) {
            dp[i][j][openCount] = 1;
            return true;
        }
        if (j + 1 < n && solve(i, j + 1, openCount, grid) == true) {
            dp[i][j][openCount] = 1;
            return true;
        }
        dp[i][j][openCount] = 0;
        return false;
    }
}