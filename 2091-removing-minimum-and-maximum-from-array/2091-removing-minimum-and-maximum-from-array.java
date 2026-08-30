class Solution {
    public int minimumDeletions(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int n = nums.length;
        int minIdx = 0;
        int maxIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nums[minIdx]) {
                minIdx = i;
            }
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i; 
            }
        }
        int leftIdx = Math.min(minIdx, maxIdx);
        int rightIdx = Math.max(minIdx, maxIdx);

        int option1 = (leftIdx + 1) + (n - rightIdx);
        int option2 = rightIdx + 1;
        int option3 = n - leftIdx;
        return Math.min(option1, Math.min(option2, option3));
    }
}