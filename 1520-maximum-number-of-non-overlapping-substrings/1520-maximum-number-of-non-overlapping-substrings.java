//Approach (Greedy + two pointers)
//T.C : O(n)
//S.C : O(26)
class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] start = new int[26];
        Arrays.fill(start, -1);
        int[] end = new int[26];
        boolean[] isInvalid = new boolean[26];

        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            if (start[idx] == -1) {
                start[idx] = i;
            }
            end[idx] = i;
        }

        for (int c = 0; c < 26; c++) {
            if (start[c] == -1) continue;
            for (int i = start[c]; i <= end[c]; i++) {
                if (start[s.charAt(i) - 'a'] < start[c]) {
                    isInvalid[c] = true;
                    break;
                }
                if (end[s.charAt(i) - 'a'] > end[c]) {
                    end[c] = end[s.charAt(i) - 'a'];
                }
            }
        }

        List<String> res = new ArrayList<>();
        int lastTakenStart = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (i == start[s.charAt(i) - 'a'] && !isInvalid[s.charAt(i) - 'a'] && end[s.charAt(i) - 'a'] < lastTakenStart) {
                res.add(s.substring(start[s.charAt(i) - 'a'], end[s.charAt(i) - 'a'] + 1));
                lastTakenStart = start[s.charAt(i) - 'a'];
            }
        }
        return res;
    }
}