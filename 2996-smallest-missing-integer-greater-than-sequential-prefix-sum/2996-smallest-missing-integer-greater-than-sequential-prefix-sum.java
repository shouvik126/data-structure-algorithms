class Solution {
    /*public int missingInteger(int[] nums) {
        int count = 1;
        int maxCount = 1;
        int[] prefSum = new int[nums.length];
        prefSum[0] = nums[0];
        int ans = prefSum[0];
        Set<Integer> set = new HashSet<>();
        set.add(nums[0]);
        boolean f = false;
        for (int i = 1; i < nums.length; i++) {
            prefSum[i] = prefSum[i - 1] + nums[i];
            set.add(nums[i]);
            if (nums[i] == nums[i - 1] + 1) {
                count++;
            } else {
                f = true;
                if (count > maxCount) {
                    maxCount = count;
                    int temp  = i - 1;
                    ans = prefSum[temp] - (temp - maxCount >= 0 ? prefSum[temp - maxCount] : 0);
                }
                count = 1;
            }
        }
        if(!f) {
            ans = prefSum[nums.length - 1];
        }
        while (set.contains(ans)) {
            ans++;
        }
        return ans;
    }*/

    public int missingInteger(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                break;
            } else {
                ans += nums[i];
            }
        }
        while (set.contains(ans)) {
            ans++;
        }
        return ans;
    }
}