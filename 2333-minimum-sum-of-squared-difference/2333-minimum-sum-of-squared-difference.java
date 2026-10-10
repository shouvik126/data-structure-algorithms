class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int[] diff = new int[100000 + 1];
        for (int i = 0; i < nums1.length; i++) {
            int dif = Math.abs(nums1[i] - nums2[i]);
            diff[dif]++;
        }
        int k = k1 + k2;
        for (int j = 100000; j >= 1 && k > 0; j--) {
            int min = Math.min(k, diff[j]);
            diff[j] -= min;
            diff[j - 1] += min;
            k -= min;
        }
        long res = 0;
        for (long i = 1; i <= 100000; i++) {
            res += (long)diff[(int)i] * (i * i);
        }
        return res;
    }
}