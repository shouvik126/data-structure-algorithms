//Approach-1 (Recursion + MEmoization)
//T.C : O(m*n)
//S.C : O(m*n)
// class Solution {
//     public int numDistinct(String s, String t) {
//         int m = s.length();
//         int n = t.length();
//         int[][] dp = new int[1001][1001];
//         for (int[] d : dp) {
//             Arrays.fill(d, -1);
//         }
//         return solve(s, t, m, n, dp);
//     }
//     public int solve(String s, String t, int m, int n, int[][] dp) {
//         if (n == 0) {
//             return 1;
//         }
//         if (m == 0) {
//             return 0;
//         }
//         if (dp[m][n] != -1) {
//             return dp[m][n];
//         }

//         if (s.charAt(m - 1) == t.charAt(n - 1)) {
//             return dp[m][n] = solve(s, t, m - 1, n - 1, dp) + solve(s, t, m - 1, n, dp);
//         } else {
//             return dp[m][n] = solve(s, t, m - 1, n, dp);
//         }
//     }
// }



//Approach-2 (Bottom UP DP)
//T.C : O(m*n)
//S.C : O(m*n)
// class Solution {
//     public int numDistinct(String s, String t) {
//         int m = s.length();
//         int n = t.length();
//         int[][] dp = new int[1001][1001];
//         for (int i = 0; i <= m; i++) {
//             dp[i][0] = 1;
//         }
//         for (int j = 1; j <= n; j++) {
//             dp[0][j] = 0;
//         }
//         for (int i = 1; i <= m; i++) {
//             for (int j = 1; j <= n; j++) {
//                 if (s.charAt(i - 1) == t.charAt(j - 1)) {
//                     dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
//                 } else {
//                     dp[i][j] = dp[i - 1][j];
//                 }
//             }
//         }
//         return dp[m][n];
//     }
    
// }

class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] prev = new int[1001];
        int[] curr = new int[1001];
        prev[0] = 1;
        curr[0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + prev[j];
                } else {
                    curr[j] = prev[j];
                }
            }
            prev = curr.clone();
        }
        return prev[n];
    }
    
}