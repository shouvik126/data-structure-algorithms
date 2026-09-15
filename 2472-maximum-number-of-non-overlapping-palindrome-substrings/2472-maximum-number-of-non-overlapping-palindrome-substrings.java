//Approach-1 (Simple Recursion Memoization)
//T.C : O(n^3)
//S.C : O(n^2)
// class Solution {
//     int [][]dp;
//     public int maxPalindromes(String s, int k) {
//         int n = s.length();
//         if (k == 1)
//             return n;
//         dp = new int[n + 1][n + 1];
//         for (int []d : dp) {
//             Arrays.fill(d, -1);
//         }
//         return solve(s, k, 0, k - 1);
//     }

//     public int solve(String s, int k, int i, int j) {
//         if (i >= s.length() || j >= s.length()) {
//             return 0;
//         }
//         if (dp[i][j] != -1) {
//             return dp[i][j];
//         }
//         if (isPelindrome(s, i, j)) {
//             int take = 1 + solve(s, k, j + 1, j + k);
//             int grow = solve(s, k, i, j + 1);
//             int shift = solve(s, k, i + 1, j + 1);
//             return dp[i][j] = Math.max(take, Math.max(grow, shift));
//         } else {
//             int grow = solve(s, k, i, j + 1);
//             int shift = solve(s, k, i + 1, j + 1);
//             return dp[i][j] = Math.max(grow, shift);
//         }
//     }
//     public boolean isPelindrome(String s, int i, int j) {
//         while (i <= j) {
//             if (s.charAt(i) != s.charAt(j)) {
//                 return false;
//             }
//             i++;
//             j--;
//         }
//         return true;
//     }
// }

//Approach-2 (Bottom Up of Approach-1 Above)
//T.C : O(n^3)
//S.C : O(n^2)
// class Solution {
//     int [][]dp;
//     public int maxPalindromes(String s, int k) {
//         int n = s.length();
//         if (k == 1)
//             return n;
//         dp = new int[n + 1][n + 1];
//         dp[n][n] = 0; // base case
//         for (int i = n - 1; i >= 0; i--) {
//             for  (int j = n - 1; j >= 0; j--) {
//                 if (isPelindrome(s, i, j)) {
//                     int take = 1 + (j + k <= n ? dp[j + 1][j + k] : 0);
//                     int grow = dp[i][j + 1];
//                     int shift = dp[i + 1][j + 1];
//                     dp[i][j] = Math.max(take, Math.max(grow, shift));
//                 } else {
//                     int grow = dp[i][j + 1];
//                     int shift = dp[i + 1][j + 1];
//                     dp[i][j] = Math.max(grow, shift);
//                 }
//             }
//         }
//         return dp[0][k - 1];
//     }
//     public boolean isPelindrome(String s, int i, int j) {
//         while (i <= j) {
//             if (s.charAt(i) != s.charAt(j)) {
//                 return false;
//             }
//             i++;
//             j--;
//         }
//         return true;
//     }
// }

//Approach-3 (Simple Recursion Memoization)
//T.C : O(n^2)
//S.C : O(n^2)
class Solution {
    int [][]dp;
    boolean[][] palindrome;
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        if (k == 1)
            return n;
        dp = new int[n + 1][n + 1];
        for (int []d : dp) {
            Arrays.fill(d, -1);
        }
        palindrome = new boolean[n + 1][n + 1];
        generateBluePrint(s, n);
        return solve(s, k, 0, k - 1);
    }

    public int solve(String s, int k, int i, int j) {
        if (i >= s.length() || j >= s.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (palindrome[i][j]) {
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
    public void generateBluePrint(String s, int n) {
        for (int L = 1; L <= n; L++) {
            for (int i = 0; i + L - 1 < n; i++) {
                int j = i + L - 1;
                if (i == j) {
                    palindrome[i][j] = true;
                } else if (i + 1 == j) {
                    palindrome[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    palindrome[i][j] = s.charAt(i) == s.charAt(j) && palindrome[i + 1][j - 1];
                }
            }
        }
    }
}