class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num < min)
                min = num;

            if (num > max) {
                max = num;
            }
        }
        return gcd (min, max);
    }

    int gcd (int a, int b) {
        return b == 0 ? a : gcd (b, a % b);
    }
}