// Approach-1 (Simple Recursion)
//T.C : O(2n* (2^(2n)) -> Removing constant -> O(n * (2^n))
//S.C : O(2*n) -> Removing constant -> O(n) -> recursion stack space - Max depth of recusion tree
// class Solution {
//     List<String> res;
//     public List<String> generateParenthesis(int n) {
//         res = new ArrayList<String>();
//         generate("", n);
//         return res;
//     }
//     public void generate(String s, int n) {
//         if (s.length() == 2 * n) {
//             if (isValid(s)) {
//                 res.add(s);
//             }
//             return;
//         }
//         s += '(';
//         generate(s, n);
//         s = s.substring(0, s.length() - 1);
//         s += ')';
//         generate(s, n);
//         s = s.substring(0, s.length() - 1);
//     }
//     public boolean isValid(String s) {
//         int sum = 0;
//         for (char c : s.toCharArray()) {
//             if (c == '(') {
//                 sum++;
//             } else {
//                 sum--;
//             }
//             if (sum < 0) {
//                 return false;
//             }
//         }
//         return sum == 0;
//     }
// }

// Approach-1 (Simple Recursion)
//T.C : O(2n* (2^(2n)) -> Removing constant -> O(n * (2^n))
//S.C : O(2*n) -> Removing constant -> O(n) -> recursion stack space - Max depth of recusion tree
class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<String>();
        generate("", n, 0, 0);
        return res;
    }
    public void generate(String s, int n, int open, int close) {
        if (s.length() == 2 * n) {
            if (isValid(s)) {
                res.add(s);
            }
            return;
        }
        if (open < n) {
            s += '(';
            generate(s, n, open + 1, close);
            s = s.substring(0, s.length() - 1);
        }
        if (close < open) {
            s += ')';
            generate(s, n, open, close + 1);
            s = s.substring(0, s.length() - 1);
        }
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