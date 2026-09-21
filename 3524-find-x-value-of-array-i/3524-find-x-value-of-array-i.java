class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] res = new long[k];
        long[] prev = new long[k];
        for (int i = 0; i < nums.length; i++) {
            long[] curr = new long[k];
            int currElementRemainder = nums[i] % k;
            curr[currElementRemainder]++;
            for (int oldRem = 0; oldRem < k; oldRem++) {
                int newRem = (oldRem * (nums[i] % k)) % k;
                curr[newRem] += prev[oldRem];
            }
            prev = curr;
            for (int l = 0; l < k; l++) {
                res[l] += prev[l];
            }
        }
        return res;
    }
}