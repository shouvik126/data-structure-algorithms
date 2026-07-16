class Solution {
    public long gcdSum(int[] nums) {
        int[] mx = new int[nums.length];
        int[] prefixGcd = new int[nums.length];
        mx[0] = nums[0];
        prefixGcd[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            mx[i] = Math.max(nums[i], mx[i - 1]);
            prefixGcd[i] = gcd(mx[i], nums[i]);
        }
        int m = 0;
        int n = nums.length - 1;
        Arrays.sort(prefixGcd);
        long sum = 0L;
        while (m < n) {
            sum += (0L + gcd(prefixGcd[m], prefixGcd[n]));
            m++;
            n--;
        }
        return sum;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}