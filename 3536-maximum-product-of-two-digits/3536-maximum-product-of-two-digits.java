class Solution {
    public int maxProduct(int n) {
        int max1 = n % 10;
        n = n / 10;
        int max2 = n % 10;
        n = n / 10;
        int temp = max1;
        if (max2 > max1) {
            max1 = max2;
            max2 = temp;
        }

        while (n > 0) {
            int val = n % 10;
            if (val > max2) {
                max2 = val;
                int t = max1;
                if (max2 > max1) {
                    max1 = max2;
                    max2 = t;
                }
            }
            n = n / 10;
        }
        return max1 * max2;
    }
}