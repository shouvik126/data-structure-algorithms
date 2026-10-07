class Solution {
    Set<String> res;
    int maxLen = 0;
    public List<String> removeInvalidParentheses(String s) {
        int n = s.length();
        res = new HashSet<>();
        String curr = "";
        solve(0, 0, n, curr, s);
        return new ArrayList<>(res);
    }
    public void solve(int i, int count, int n, String curr, String s) {
        if (count < 0) {
            return;
        }
        if (i == n) {
            if (count == 0) {
                if (curr.length() > maxLen) {
                    maxLen = curr.length();
                    res.clear();
                }
                if (curr.length() >= maxLen) {
                    res.add(curr);
                }
            }
            return;
        }
        if (s.charAt(i) != '(' && s.charAt(i) != ')') {
            curr += s.charAt(i);
            solve(i + 1, count, n, curr, s);
            curr = curr.substring(0, curr.length() - 1);
            return;
        }
        curr += s.charAt(i);
        char c = s.charAt(i);
        solve(i + 1, count + (c == '(' ? 1 : -1), n, curr, s);
        curr = curr.substring(0, curr.length() - 1);
        solve(i + 1, count, n, curr, s);
        return;
    }
}