class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if (n == 1 || n == 2){
            return n;
        }
        int i = 1;
        while (i <= n) {
            i *= 2;
        }
        return i;
    }
}