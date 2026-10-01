class Solution {
    public boolean isValid(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        char c = s.charAt(0);
        if (c == ')' || c == '}' || c == ']')
            return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                dq.push(s.charAt(i));
            } else {
                if (dq.isEmpty()) {
                    return false;
                }
                char top = dq.peek();
                if ((top == '(' && s.charAt(i) == ')')
                    || (top == '{' && s.charAt(i) == '}')
                    || (top == '[' && s.charAt(i) == ']')) {
                        dq.pop();
                    } else {
                        return false;
                    }
            }
        }
        return dq.isEmpty();
    }
}