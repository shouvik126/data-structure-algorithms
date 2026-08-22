class Solution {
    public boolean checkDivisibility(int n) {
        int val = n;
        int sum = 0;
        int prod = 1;
        while (val > 0) {
            sum += val % 10;
            prod *= val % 10;
            val = val / 10;
        }
        return n % (sum + prod) == 0;
    }
}