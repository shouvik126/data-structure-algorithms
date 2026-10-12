class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int MOD = 1_000_000_007;
        int bits = 30; //nums[i] <= 10^9 < 2^30
        int[] count = new int[bits];
        for (int num : nums) {
            for (int b = 0; b < bits; b++) {
                if ((num & (1<<b)) != 0) {
                    count[b]++;
                }
            }
        }
        long res = 0;
        while (k-- > 0) {
            long curr = 0L;
            for (int b = 0; b < bits; b++) {
                if (count[b] > 0) {
                    count[b]--;
                    curr = curr | (1L << b);
                }
            }
            res = (res + (curr * curr)) % MOD;
            curr = 0L;
        }
        return (int)res;
    }
}