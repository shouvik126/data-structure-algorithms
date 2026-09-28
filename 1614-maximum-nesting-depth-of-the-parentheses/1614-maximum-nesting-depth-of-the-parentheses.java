class Solution {
    public int maxDepth(String s) {
        
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            
            if (s.charAt(i) == '(') {
                sum += 1;
            } else if (s.charAt(i) == ')') {
                sum -= 1;
            }
            if (sum > ans) {
                ans = sum;
            }
        }
        return ans;
    }
}