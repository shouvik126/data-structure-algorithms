class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[1001][1001];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return solve(s, t, m, n, dp);
    }
    public int solve(String s, String t, int m, int n, int[][] dp) {
        if (n == 0) {
            return 1;
        }
        if (m == 0) {
            return 0;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        if (s.charAt(m - 1) == t.charAt(n - 1)) {
            return dp[m][n] = solve(s, t, m - 1, n - 1, dp) + solve(s, t, m - 1, n, dp);
        } else {
            return dp[m][n] = solve(s, t, m - 1, n, dp);
        }
    }
}