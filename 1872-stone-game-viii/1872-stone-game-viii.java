//Approach-1 - Recursion + Memo
//T.C : O(n)
//S.C : O(n)
// class Solution {
//     int n;
//     int[] dp;
//     int[] prefSum;
//     boolean[] visited;
//     public int stoneGameVIII(int[] stones) {
//         n = stones.length;
//         dp = new int[n + 1];
//         visited = new boolean[n + 1];
//         Arrays.fill(dp, -1);
//         prefSum = new int[n];
//         prefSum[0] = stones[0];
//         for (int i = 1; i < n; i++) {
//             prefSum[i] = prefSum[i - 1] + stones[i];
//         }
//         return solve(1);
//     }
//     public int solve(int i) {
//         if (i == n - 1) {
//             return prefSum[i];
//         }
//         if (visited[i]) {
//             return dp[i];
//         }
//         visited[i] = true;
//         int takei = prefSum[i] - solve(i + 1);
//         int skipi = solve(i + 1);
//         return dp[i] = Math.max(takei, skipi);
//     }
// }

//Approach-2 - Bottom Up
//T.C : O(n)
//S.C : O(n)
class Solution {
    int n;
    int[] dp;
    int[] prefSum;
    boolean[] visited;
    public int stoneGameVIII(int[] stones) {
        n = stones.length;
        dp = new int[n + 1];
        prefSum = new int[n];
        prefSum[0] = stones[0];
        for (int i = 1; i < n; i++) {
            prefSum[i] = prefSum[i - 1] + stones[i];
        }
        dp[n - 1] = prefSum[n - 1];
        for (int i = n - 2; i >= 1; i--) {
            int takei = prefSum[i] - dp[i + 1];
            int skipi = dp[i + 1];
            
            dp[i] = Math.max(takei, skipi);
        }
        return dp[1];
    }
}