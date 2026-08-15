class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        boolean allZero = true;
        int xor = 0;
        for (int val : nums) {
            xor  = xor ^ val;
            if (allZero && val != 0) {
                allZero = false;
            }
        }
        if (allZero) {
            return 0;
        }
        if (xor == 0) {
            return n - 1;
        } else {
            return n;
        }

    }
}