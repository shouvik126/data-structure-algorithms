class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            int revIdx = 26 - idx;
            sum += ((i + 1) * revIdx);
        }
        return sum;
    }
}