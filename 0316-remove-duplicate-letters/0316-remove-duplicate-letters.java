class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        String ans = "";

        boolean[] taken = new boolean[26];
        int[] lastIndex = new int[26];
        Arrays.fill(lastIndex, -1);

        for (int i = 0; i < n; i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';

            if (taken[idx])
                continue;
            while (ans.length() > 0 && ans.charAt(ans.length() - 1) > ch && lastIndex[ans.charAt(ans.length() - 1) - 'a'] > i) {
                taken[ans.charAt(ans.length() - 1) - 'a'] = false;
                ans = ans.substring(0, ans.length() - 1);
            }
            ans = ans + ch;
            taken[idx] = true;
        }
        return ans;
    }
}