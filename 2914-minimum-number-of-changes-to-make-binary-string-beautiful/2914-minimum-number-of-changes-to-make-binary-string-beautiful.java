class Solution {
    public int minChanges(String s) {
        char ch = s.charAt(0);
        int count = 0;
        int changes = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                count++;
                continue;
            }
            if (count % 2 == 0) {
                count = 1;
            } else {
                count = 0;
                changes++;
            }
            ch = s.charAt(i);  
        }
        return changes;
    }
}