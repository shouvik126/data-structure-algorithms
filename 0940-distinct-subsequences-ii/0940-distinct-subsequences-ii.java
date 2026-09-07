class Solution {
    int M = 1_000_000_007;
    int[] prev = new int[2001]; //prev[n] = last time when we saw this nth character (1-based indexing)
    int[] dp = new int[2001];
    public int distinctSubseqII(String s) {
        int n = s.length();
        
        Arrays.fill(dp, -1);
        
        int[] lastSeen = new int[26];
        for (int i = 1; i <= n; i++) {
            int idx = s.charAt(i - 1) - 'a';
            prev[i] = lastSeen[idx];
            lastSeen[idx] = i;
        }
        return (solve(n) - 1 + M) % M;
    }

    public int solve(int n) {
        if (n == 0) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int total = (solve(n - 1) * 2) % M;
        if (prev[n] != 0) {
            int diff = (solve(prev[n] - 1)) % M;
            total = (total - diff + M) % M;
        }
        return dp[n] = total;
    }
}