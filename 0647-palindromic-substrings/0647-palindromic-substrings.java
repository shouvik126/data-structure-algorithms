class Solution {
    int[][] dp;
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        dp = new int[n + 1][n + 1];
        for (int[] d : dp) Arrays.fill(d, -1);
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (check(s, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }
    public boolean check(String s, int i, int j) {
        if (i > j) {
            return true;
        }
        if (dp[i][j] != -1) {
            return dp[i][j] == 1 ? true : false;
        }
        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = check(s, i + 1, j - 1) == true ? 1 : 0;
            return dp[i][j] == 1 ? true : false;
        }
        dp[i][j] = 0;
        return false;
    }
}