class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<String>();
        generate("", n);
        return res;
    }
    public void generate(String s, int n) {
        if (s.length() == 2 * n) {
            if (isValid(s)) {
                res.add(s);
            }
            return;
        }
        s += '(';
        generate(s, n);
        s = s.substring(0, s.length() - 1);
        s += ')';
        generate(s, n);
        s = s.substring(0, s.length() - 1);
    }
    public boolean isValid(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                sum++;
            } else {
                sum--;
            }
            if (sum < 0) {
                return false;
            }
        }
        return sum == 0;
    }
}