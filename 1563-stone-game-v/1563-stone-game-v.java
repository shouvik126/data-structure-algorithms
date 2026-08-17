//Approach-1 - Recursion + Memo
//T.C : O(n^3)
//S.C : O(n^2)
class Solution {
    int[][] dp;
    int n;
    public int stoneGameV(int[] stoneValue) {
        n = stoneValue.length;
        dp = new int[n + 1][n + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        int[] prefSum = new int[n];
        prefSum[0] = stoneValue[0];
        for (int i = 1; i < n; i++) {
            prefSum[i] = prefSum[i - 1] + stoneValue[i];
        }       
        return solve(0, n - 1, prefSum);
    }

    public int solve(int l, int r, int[] prefSum) {
        if (l >= r) {
            return 0;
        }
        int score = 0;
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        for (int mid = l; mid <= r - 1; mid++) {
            int leftSum = prefSum[mid] - (l > 0 ? prefSum[l - 1] : 0);
            int rightSum = prefSum[r] - prefSum[mid];

            if (leftSum < rightSum) {
                score = Math.max(score, leftSum + solve(l, mid, prefSum));
            } else if (rightSum < leftSum) {
                score = Math.max(score, rightSum + solve(mid + 1, r, prefSum));
            } else {
                score = Math.max(score, Math.max(leftSum + solve(l, mid, prefSum),  rightSum + solve(mid + 1, r, prefSum)));
            }
        }
        return dp[l][r] = score;
    }
}