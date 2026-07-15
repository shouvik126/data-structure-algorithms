class Solution {
    public int gcdOfOddEvenSums(int n) {
        int odd = 0;
        int even = 0;
        int countOdd = 0;
        int countEven = 0;
        int num = 1;
        while(countOdd < n || countEven < n) {
            if (num % 2 != 0) {
                odd += num;
                countOdd++;
                num++;
            } 
            if (num % 2 == 0) {
                even += num;
                countEven++;
                num++;
            }
        }
        return gcd(odd, even);
    }
    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}