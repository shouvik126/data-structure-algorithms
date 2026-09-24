class Solution {
    public int smallestIndex(int[] nums) {
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            int sum = 0;
            while (val > 0) {
                sum += (val % 10);
                val = val / 10;
            }
            if (sum == i){
                res = i;
                break;
            }
        }
        return res;
    }
}