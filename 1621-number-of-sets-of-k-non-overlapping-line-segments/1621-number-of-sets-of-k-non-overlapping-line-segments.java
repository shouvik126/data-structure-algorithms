//Approach-1 (Recursion Memo) - TLE
//T.C : O(n^2 * k)
//S.C : O(n*K)
// class Solution {
//     int[][] dp;
//     int MOD = 1000_000_007;
//     public int numberOfSets(int n, int k) {
//         dp = new int[1001][1001];
//         for (int[]d : dp) {
//             Arrays.fill(d, -1);
//         }
//         return solve(n, k, 0) % MOD;
//     }

//     public int solve(int n, int k, int i) {
//         if (k == 0) {
//             return 1;
//         }
//         if (i >= n) {
//             return 0;
//         }
//         if (dp[k][i] != -1) {
//             return dp[k][i];
//         }
//         long skip = solve(n, k, i + 1) % MOD;
//         long take = 0;
//         for (int j = i + 1; j < n; j++) {
//             take = (take + solve(n, k - 1, j)) % MOD;
//         }
//         return dp[k][i] = (int)((skip + take) % MOD);
//     }
// }

//Approach-2 (Buttom up of Approach-1) - TLE
//T.C : O(n^2 * k)
//S.C : O(n*K)
// class Solution {
//     int MOD = 1_000_000_007;
//     int[][] dp = new int[1001][1001];

//     public int numberOfSets(int n, int K) {

//         for (int i = 0; i <= n; i++) {
//             dp[0][i] = (i < n) ? 1 : 0;
//         }

//         for (int k = 1; k <= K; k++) {

//             for (int i = n - 1; i >= 0; i--) {

//                 int skip = dp[k][i + 1];

//                 int take = 0;
//                 for (int j = i + 1; j < n; j++) {
//                     take = (int) ((take + dp[k - 1][j]) % MOD);
//                 }

//                 dp[k][i] = (take + skip) % MOD;
//             }
//         }

//         return dp[K][0];
//     }
// }

//Approach-3 (Buttom up of Approach-1) - TLE
//T.C : O(n^2 * k)
//S.C : O(n*K)
class Solution {
    int MOD = 1_000_000_007;
    int[][] dp = new int[1001][1001];

    public int numberOfSets(int n, int K) {

        for (int i = 0; i <= n; i++) {
            dp[0][i] = (i < n) ? 1 : 0;
        }

        for (int k = 1; k <= K; k++) {
            int[] prevRowSum = new int[n + 1];
            for (int m = n - 1; m >= 1; m--) {
                prevRowSum[m] = (prevRowSum[m + 1] + dp[k - 1][m]) % MOD;
            }

            for (int i = n - 1; i >= 0; i--) {

                int skip = dp[k][i + 1];

                int take = prevRowSum[i+1];

                dp[k][i] = (take + skip) % MOD;
            }
        }

        return dp[K][0];
    }
}

