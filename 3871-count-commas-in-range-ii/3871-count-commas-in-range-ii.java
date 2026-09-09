class Solution {
    public long countCommas(long n) {
        long result = 0;
        long lower = 1000;
        long comm = 1;
        while (lower <= n) {
            long upper = (lower * 1000) - 1;
            if (upper  > n)
                upper = n;
            long total = (upper - lower) + 1;
            result += total * comm;
            comm++;
            lower *= 1000;
        }
        return result;
    }
}