class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int i = 0;
        int j = 0;
        int n = s.length();
        String res = "";
        int countOne = 0;
        while (j < n) {
            if (s.charAt(j) == '1') {
                countOne++;
            }

            while ((countOne > k || s.charAt(i) == '0') && i < j) {
                if (s.charAt(i) == '1') {
                    countOne--;
                }
                i++;
            }

            if (countOne == k) {
                int len = j - i + 1;
                if (res.isEmpty() 
                    || len < res.length() 
                    || (len == res.length() && s.substring(i, j + 1).compareTo(res) < 0)) {
                    res = s.substring(i, j + 1);
                }
            }
            j++;
        }
        return res;
    }
}