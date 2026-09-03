class Solution {
    public boolean uniformArray(int[] nums1) {
        boolean isOdd = true;
        boolean isEven = true;
        int smOdd = Integer.MAX_VALUE;
        int smEven = Integer.MAX_VALUE;
        for (int val : nums1) {
            if (val % 2 == 0) {
                isOdd = false;
                if (val < smEven) {
                    smEven = val;
                }
            }
            if (val % 2 != 0) {
                isEven = false;
                if (val < smOdd) {
                    smOdd = val;
                }
            }
        }
        if (isEven || isOdd) {
            return true;
        } else {
            return smOdd < smEven;
        }
    }
}