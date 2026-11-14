class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int ans = Integer.MAX_VALUE;
        for (int s = l; s <= r; s++) {
            int i = 0;
            int j = 0;
            int sum = 0;
            while (j < n) {
                while (j - i + 1 > s) {
                    sum -= nums.get(i);
                    i++;
                }
                sum += nums.get(j);

                if (j - i + 1 == s) {
                    if (sum > 0 && sum < ans) {
                        ans = sum;
                    }
                }
                j++;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}