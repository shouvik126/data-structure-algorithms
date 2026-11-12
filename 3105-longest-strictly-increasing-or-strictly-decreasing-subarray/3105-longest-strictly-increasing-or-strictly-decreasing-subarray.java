class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc = 1;
        int dec = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dec = 1;
                inc += 1;
                res = Math.max(res, inc);
            } else if (nums[i] < nums[i - 1]) {
                inc = 1;
                dec += 1;
                res = Math.max(res, dec);
            } else {
                inc = 1;
                dec= 1;
            }
        }
        return res;
    }
}