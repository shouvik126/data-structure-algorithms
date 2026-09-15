class Solution {
    int [][]dp;
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        if (k == 1)
            return n;
        dp = new int[n + 1][n + 1];
        for (int []d : dp) {
            Arrays.fill(d, -1);
        }
        return solve(s, k, 0, k - 1);
    }

    public int solve(String s, int k, int i, int j) {
        if (i >= s.length() || j >= s.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (isPelindrome(s, i, j)) {
            int take = 1 + solve(s, k, j + 1, j + k);
            int grow = solve(s, k, i, j + 1);
            int shift = solve(s, k, i + 1, j + 1);
            return dp[i][j] = Math.max(take, Math.max(grow, shift));
        } else {
            int grow = solve(s, k, i, j + 1);
            int shift = solve(s, k, i + 1, j + 1);
            return dp[i][j] = Math.max(grow, shift);
        }
    }
    public boolean isPelindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}