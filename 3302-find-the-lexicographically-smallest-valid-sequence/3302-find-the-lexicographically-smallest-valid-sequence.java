class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (m > n)
            return new int[0];
        int[] suff = new int[n + 1];
        for (int k = n - 1; k >= 0; k--) {
            suff[k] = suff[k + 1];
            if (suff[k] < m && word1.charAt(k) == word2.charAt(m - 1 - suff[k])) {
                suff[k]++;
            } 
        }

        int i = 0;
        int j = 0;
        boolean skipped = false;
        int[] ans = new int[m];
        while(j < m) {
            if (i >= n){
                return new int[0];
            }
            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j] = i;
                i++;
                j++;
            } else if (!skipped && suff[i + 1] >= m - j - 1){
                skipped = true;
                ans[j] = i;
                i++;
                j++;
            } else {
                i++;
            }
        }
        return ans;
    }
}