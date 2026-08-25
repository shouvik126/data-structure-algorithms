//Approach-1 (Recursion + Memoization)
 // T.C : O(n * sum)
 // S.C : O(n * sum)
 class Solution {

     int[][] t;

     boolean solve(int n, int sum, int[] arr) {
         if (sum == 0)
             return true;

         if (n == 0)
             return false;

         if (t[n][sum] != -1)
             return t[n][sum] == 1;

         boolean skip = solve(n - 1, sum, arr);

         boolean take = false;
         if (arr[n - 1] <= sum) {
             take = solve(n - 1, sum - arr[n - 1], arr);
         }

         t[n][sum] = (take || skip) ? 1 : 0;
         return take || skip;
     }

     public boolean isSubsetSum(int[] arr, int sum) {
         int n = arr.length;

         t = new int[n + 1][sum + 1];

         for (int i = 0; i <= n; i++) {
             Arrays.fill(t[i], -1);
         }

         return solve(n, sum, arr);
     }
 }