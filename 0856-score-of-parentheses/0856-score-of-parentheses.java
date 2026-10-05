class Solution {
    public int scoreOfParentheses(String s) {
        int n = s.length();
        return solve(s, 0, n - 1);
    }
    public int solve(String s, int left, int right) {
        if (right - left == 1) {
            return 1;
        }
        int balance = 0;
        for (int i = left; i <= right; i++) {
            if (s.charAt(i) == '(') {
                balance++;
            } else {
                balance--;;
            }

            if (balance == 0) {
                if (i == right) {
                    return 2 * solve(s, left + 1, right - 1);
                }

                return solve (s, left, i) + solve(s, i + 1, right);
            }
        }
        return 0;
    }
}