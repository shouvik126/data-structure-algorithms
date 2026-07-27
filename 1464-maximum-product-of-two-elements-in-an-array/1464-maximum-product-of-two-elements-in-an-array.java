class Solution {
    public int maxProduct(int[] nums) {
       int max1 = nums[0];
       int max2 = nums[1];
       if (nums[1] > max1)  {
        max1 = nums[1];
        max2 = nums[0];
       }
       for (int i = 2; i < nums.length; i++) {
        if (nums[i] > max2) {
            max2 = nums[i];
            if (max2 > max1) {
                int temp = max1;
                max1 = max2;
                max2 = temp;
            }
        }
       }
       return (max1 - 1) * (max2 - 1);
    }
}