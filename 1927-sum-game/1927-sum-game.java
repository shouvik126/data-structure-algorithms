class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int leftCharCount = 0;
        int rightCharCount = 0;
        int leftKnownSum = 0;
        int rightKnownSum = 0;

        for (int i = 0; i < n; i++) {
            if (num.charAt(i) == '?') {
                if (i < n / 2) {
                    leftCharCount++;
                } else {
                    rightCharCount++;
                }
            } else {
                if (i < n / 2) {
                    leftKnownSum += num.charAt(i) - '0';
                } else {
                    rightKnownSum += num.charAt(i) - '0';
                }
            }
        }
        if ((leftCharCount + rightCharCount) % 2 == 1) {
            return true;
        }

        int LEFT = (2 * leftKnownSum) + (9 * leftCharCount);
        int RIGHT = (2 * rightKnownSum) + (9 * rightCharCount);
        return LEFT != RIGHT;
    }
}