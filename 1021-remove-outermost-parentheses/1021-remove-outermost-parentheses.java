class Solution {
    public String removeOuterParentheses(String s) {
        String res = "";
        int n = s.length();
        String st = "";
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                count++;
                st += "(";
            } else {
                count--;
                st += ")";
            }
            if (count == 0) {
                res += st.substring(1, st.length() - 1);
                st = ""; 
            }
        }
        return res;
    }
}