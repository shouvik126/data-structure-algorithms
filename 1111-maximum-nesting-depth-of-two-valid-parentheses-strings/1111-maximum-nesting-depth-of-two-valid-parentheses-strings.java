class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int d = 0;
        int n = seq.length();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (seq.charAt(i) == '(') {
                d++;
                if (d % 2 == 0) {
                    res[i] = 0;
                } else {
                    res[i] = 1;
                }
            } else {
                if (d % 2 == 0) {
                    res[i] = 0;
                } else {
                    res[i] = 1;
                }
                d--;
            }
        }
        return res;
    }
}