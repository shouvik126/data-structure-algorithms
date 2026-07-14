//Approach-1 (Recursion + Memoization)
//T.C : O(n * M * M), M = max element 
//S.C : O(n * M * M), M = max element
/* class Solution {
    int MOD = 1_000_000_007;
    int[][][] t;

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int solve(int[] nums, int i, int first, int second) {
        if (i == nums.length) {
            boolean bothNonEmpty = (first != 0 && second != 0);
            boolean gcdsMatch    = (first == second);
            return (bothNonEmpty && gcdsMatch) ? 1 : 0;
        }

        if (t[i][first][second] != -1)
            return t[i][first][second];

        // Skip this index entirely
        int skip = solve(nums, i + 1, first, second);

        // Include this index in seq1
        int take1 = solve(nums, i + 1, gcd(first, nums[i]), second);

        // Include this index in seq2
        int take2 = solve(nums, i + 1, first, gcd(second, nums[i]));

        // Summing up all the possibilites
        return t[i][first][second] = (int)((0L + skip + take1 + take2) % MOD);
    }

    public int subsequencePairCount(int[] nums) {
        t = new int[201][201][201];
        for (int[][] row : t)
            for (int[] col : row)
                Arrays.fill(col, -1);
        return solve(nums, 0, 0, 0);
    }
} */

//Approach-2 (Bottom Up)
//T.C : O(n * M * M), M = max element 
//S.C : O(n * M * M), M = max element
class Solution {
    int MOD = 1_000_000_007;

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int subsequencePairCount(int[] nums) {
        int n = nums.length;

        int maxEl = -1;
        for (int x : nums)
            maxEl = Math.max(maxEl, x);

        int[][][] dp = new int[n + 1][maxEl + 1][maxEl + 1];

        // Base case
        for (int first = 0; first <= maxEl; first++) {
            for (int second = 0; second <= maxEl; second++) {
                boolean bothNonEmpty = (first != 0 && second != 0);
                boolean gcdsMatch    = (first == second);
                dp[n][first][second] = (bothNonEmpty && gcdsMatch) ? 1 : 0;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int first = maxEl; first >= 0; first--) {
                for (int second = maxEl; second >= 0; second--) {

                    // Skip this index entirely
                    int skip  = dp[i + 1][first][second]; //solve(i+1, first, second);

                    // Include this index in seq1
                    int take1 = dp[i + 1][gcd(first, nums[i])][second];

                    // Include this index in seq2
                    int take2 = dp[i + 1][first][gcd(second, nums[i])];

                    dp[i][first][second] = (int)((0L + skip + take1 + take2) % MOD);
                }
            }
        }

        return dp[0][0][0]; //return solve(nums, 0, 0, 0);
    }
}
