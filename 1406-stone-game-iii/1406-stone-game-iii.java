/* class Solution {
    int n = 0;
    public String stoneGameIII(int[] stoneValue) {
        n = stoneValue.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int diff = solve(stoneValue, 0, dp);
        if (diff > 0) {
            return "Alice";
        } else if (diff < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }

    public int solve(int[] stoneValue, int i, int[] dp) {
        if (i >= n) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }

        int result = stoneValue[i] - solve(stoneValue, i + 1, dp);
        if (i + 1 < n)
            result = Math.max(result, (stoneValue[i] + stoneValue[i + 1] - solve(stoneValue, i + 2, dp)));
        if (i + 2 < n)
            result = Math.max(result, (stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - solve(stoneValue, i + 3, dp)));
        return dp[i] = result;
    }
} */

class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = stoneValue[i] - dp[i + 1];
            if (i + 2 <= n)
                dp[i] = Math.max(dp[i], stoneValue[i] + stoneValue[i + 1] - dp[i + 2]);

            if (i + 3 <= n)
                dp[i] = Math.max(dp[i], (stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - dp[i + 3]));
        }
        int diff = dp[0];
        if (diff > 0) {
            return "Alice";
        } else if (diff < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
}