class Solution {
    String res = "";
    char oddChar = ' ';
    int halfLen = 0;
    public String lexPalindromicPermutation(String s, String target) {
        StringBuilder curr = new StringBuilder("");
        halfLen = target.length() / 2;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a']++;
        }

        int oddCount = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                oddCount++;
                oddChar = (char)(i + 'a');
            }
        }
        if (oddCount > 1) {
            return "";
        }
        for (int i = 0; i < 26; i++) {
            count[i] /= 2;
        }
        solve(curr, count, target, 0, false);
        return res;
    }
    public boolean solve(StringBuilder curr, int[] count, String target, int i, boolean greater) {
        if (i == halfLen) {
            StringBuilder leftHalf = new StringBuilder(curr);
            StringBuilder rightHalf = new StringBuilder(leftHalf).reverse();
            if (oddChar != ' ' ) {
                leftHalf.append(oddChar);
            }
            leftHalf.append(rightHalf);
            if (leftHalf.toString().compareTo(target) > 0) {
                res = leftHalf.toString();
                return true;
            }
            return false;
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (count[ch - 'a'] == 0)
                continue;
            if (!greater && ch < target.charAt(i))
                continue;
            count[ch - 'a']--;
            curr.append(ch);
            boolean isGreater = greater || ch > target.charAt(i);
            if (solve(curr, count, target, i + 1, isGreater)) {
                return true;
            }
            count[ch - 'a']++;
            curr.deleteCharAt(curr.length() - 1);
        }
        return false;
    }
}