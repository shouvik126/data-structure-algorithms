class Solution {
    int n = 0;
    public int stoneGameII(int[] piles) {
       n = piles.length;
       int[][][] dp = new int[2][n + 1][n + 1];
       for(int[][] p : dp) {
        for (int[] l : p) {
            Arrays.fill(l, -1);
        }
       }
       return solveForAlice(1, 0, 1, piles, dp); 
    }

    int solveForAlice(int player, int i, int M, int[] piles, int[][][] dp) {
        if (i >= n) {
            return 0;
        }
        if (dp[player][i][M] != -1) {
            return dp[player][i][M];
        }

        int stones = 0;
        int result = (player == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE);

        for (int x = 1; x <= Math.min(2 * M, n - i); x++) {
            stones += piles[i + x - 1];
            if (player == 1) {
                result = Math.max(result, stones + solveForAlice(0, i + x, Math.max(M, x), piles, dp));
            } else {
                result = Math.min(result, solveForAlice(1, i + x, Math.max(M, x), piles, dp));
            }
        }
        return dp[player][i][M] = result;
    }
}