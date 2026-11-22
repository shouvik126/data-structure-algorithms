class Solution {
    public boolean checkString(String s) {
        boolean bAppear = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b') {
                bAppear = true;
            } else {
                if (bAppear) {
                    return false;
                }
            }
        }
        return true;
    }
}