class Solution {
    public int minAddToMakeValid(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                dq.push(s.charAt(i));
            } else {
                if (!dq.isEmpty() && dq.peek() == '(') {
                    dq.pop();
                } else {
                    count++;
                }
            }
        }
        return count + dq.size();
    }
}