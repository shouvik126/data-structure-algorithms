class Solution {
    String ss;
    int n;
    public String reverseParentheses(String s) {
        n = s.length();
        int i = 0;
        Deque<Character> dq = new ArrayDeque<>();
        while (i < n) {
            if (s.charAt(i) != ')') {
                dq.push(s.charAt(i));
            } else {
                StringBuilder sb = new StringBuilder("");
                while (dq.peek() != '(') {
                    sb.append(dq.pop());
                }
                dq.pop();
                for (int j = 0; j < sb.length(); j++) {
                    dq.push(sb.charAt(j));
                }
            }
            i++;
        }
        StringBuilder sb = new StringBuilder(dq.size());
        while (dq.size() > 0) {
            char ch = dq.removeLast();
            sb.append(ch);
        }
        return sb.toString();

    }

}