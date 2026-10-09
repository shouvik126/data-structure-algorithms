class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int count = 0;
        Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                dq.push('(');
            } else {
                if (!dq.isEmpty()) {
                    dq.pop();
                } else {
                    count++;
                }
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    count++;
                }
            }
        }
        return count + (2 * dq.size());
    }
}