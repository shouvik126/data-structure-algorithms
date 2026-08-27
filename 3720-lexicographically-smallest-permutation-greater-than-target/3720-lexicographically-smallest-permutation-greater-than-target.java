class Solution {
    String res = "";
    public String lexGreaterPermutation(String s, String target) {
        StringBuilder curr = new StringBuilder("");
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        solve(curr, count, target, 0, false);
        return res;
    }

    public boolean solve(StringBuilder curr, int[] count, String target, int i, boolean greater) {
        if (i == target.length()) {
            if (greater) {
                res = curr.toString();
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