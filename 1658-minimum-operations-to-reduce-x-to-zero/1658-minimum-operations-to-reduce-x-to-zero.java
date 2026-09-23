class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            map.put(sum, i);
        }
        int maxSubArrayCount = Integer.MIN_VALUE;
        int target = sum - x;
        if (target < 0) {
            return -1;
        }
        int tempSum = 0;
        for (int i = 0; i < n; i++) {
            tempSum += nums[i];
            int diff = tempSum - target;
            if (map.containsKey(diff)) {
                int j = map.get(diff);
                maxSubArrayCount = Math.max(maxSubArrayCount, i - j);
            }
        }
        if (maxSubArrayCount != Integer.MIN_VALUE) {
            return n - maxSubArrayCount;
        } else {
            return -1;
        }
    }
}