// class Solution {
//     public boolean winnerSquareGame(int n) {
//         int[] dp = new int[n + 1];
//         Arrays.fill(dp, -1);
//         return solve(n, dp);
//     }

//     public boolean solve(int n, int[] dp) {
//         if (n == 0) {
//             return false;
//         }
//         if (dp[n] != -1) {
//             return dp[n] == 1 ? true : false;
//         }
//         for (int k = 1; k * k <= n; k++) {
//             if (!solve(n - (k * k), dp)) {
//                 dp[n] = 1;
//                 return true;
//             }
//         }
//         dp[n] = 0;
//         return false;
//     }
// }

// Bottom Up
class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];
        dp[0] = false; // base case
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k*k <= i; k++) {
                if (!dp[i - (k * k)]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}