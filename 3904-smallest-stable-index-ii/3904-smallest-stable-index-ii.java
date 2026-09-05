class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = nums[i] > max[i - 1] ? nums[i] : max[i - 1];
        }
        min[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            min[i] = nums[i] < min[i + 1] ? nums[i] : min[i + 1];
        }
        int small = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = n - 1; i >= 0; i--) {
            int stability = max[i] - min[i];
            if (stability <= k && stability < small) {
                stability = small;
                idx = i;
            }
        }
        return idx;
    }
}