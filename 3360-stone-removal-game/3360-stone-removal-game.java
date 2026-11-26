class Solution {
    public boolean canAliceWin(int n) {
        boolean alice = false;
        int nextTurn = 10;
        if (n >= 10) {
            n -= 10;
            nextTurn -= 1;
            alice = true;
        } else {
            return false;
        }
        while (n > 0) {
            if (n >= nextTurn) {
                n -= nextTurn;
                nextTurn -= 1;
                
                alice = !alice;
            } else {
                return alice;
            }
        }
        return alice;
    }
}