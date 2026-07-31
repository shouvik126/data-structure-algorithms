class Solution {
    public int minimumPushes(String word) {
        Integer[] charCount = new Integer[26];
        Arrays.fill(charCount, 0);
        for (char ch : word.toCharArray()) {
            charCount[ch - 'a']++;
        }
        int n = word.length();
        Arrays.sort(charCount, Collections.reverseOrder());
        int mult = 1;
        int eit = 0;
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (charCount[i] == 0) {
                break;
            }
            ans += charCount[i] * mult;
            eit++;
            if (eit % 8 == 0) {
                mult++;
            }
        }
        return ans;
    }
}