class Solution {
    public long sumAndMultiply(int n) {
        String num = "" + n;
        long x = 0;
        for (int i = 0; i < num.length(); i++) {
            int temp = num.charAt(i) - '0';
            if (temp != 0) {
                x = (x * 10l) + (long)temp;
            }
        }
        long sum = 0;
        long z = x;
        while (z > 0l) {
            sum = sum + (z % 10);
            z = z / 10l;
        }
        return x * sum;

    }

}