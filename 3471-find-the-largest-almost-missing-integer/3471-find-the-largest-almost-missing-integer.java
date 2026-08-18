class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int val : nums) {
            countMap.compute(val, (key, v) -> {
                if (v == null) {
                    v = 0;
                }
                v++;
                return v;
            });
        }
        if (k == 1) {
            
            int ans = -1;
            for (int key : countMap.keySet()) {
                if (key > ans && countMap.get(key) == 1) {
                    ans = key;
                }
            }
            return ans;
        } else if (k == n) {
            int ans = -1;
            for (int val : nums) {
                if (val > ans) {
                    ans = val;
                }
            }
            return ans;
        } else {
            int a = nums[0];
            int b = nums[n - 1];
            if (countMap.get(a) == 1 && countMap.get(b) == 1) {
                return a > b ? a : b;
            } else {
                if (countMap.get(a) == 1) {
                    return a;
                } else if (countMap.get(b) == 1) {
                    return b;
                } else {
                    return -1;
                }
            }
        }
    }
}