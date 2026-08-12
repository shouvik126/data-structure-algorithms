class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int result = Integer.MIN_VALUE;
        while(j < n) {
            map.compute(nums[j], (key, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
            while(i < j && map.get(nums[j]) > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                i++;
            }
            result = Math.max(result, j - i + 1);
            j++;
        }  
        return result;
    } 
}