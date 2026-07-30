class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int freq = n / 8;
        int rem = 0;
        if (n % 8 != 0) {
            rem = n - (8 * freq);
        }
        int ans = 0;
        int i = 1;
        for (i = 1; i <= freq; i++) {
            ans += (8 * i);
        }
        if (rem > 0) {
            ans += (rem * i);
        }
        return ans;
    }
}