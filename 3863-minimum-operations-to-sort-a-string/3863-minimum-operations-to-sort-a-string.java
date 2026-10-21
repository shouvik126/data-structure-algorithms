class Solution {
    public int minOperations(String s) {
        boolean isSorted = true;
        char[] str = s.toCharArray();
        for (int i = 1; i < s.length(); i++) {
            if (str[i] < str[i - 1]) {
                isSorted = false;
                break;
            }
        }
        if (isSorted) {
            return 0;
        }
        if (str.length == 2) {
            return -1;
        }
        char max = str[0];
        char min = str[0];
        for (int i = 1; i < str.length; i++) {
            if (str[i] > max) {
                max = str[i];
            }
            if (str[i] < min) {
                min = str[i];
            }
        }
        if (str[0] == min || str[str.length - 1] == max) {
            return 1;
        }
        char mid_max = str[1];
        char mid_min = str[1];
        for (int i = 2; i < str.length - 1; i++) {
            if (str[i] > mid_max) {
                mid_max = str[i];
            }
            if (str[i] < mid_min) {
                mid_min = str[i];
            }
        }
        if (str[0] > mid_max && str[str.length - 1] < mid_min) {
            return 3;
        }
        return 2;
    }
}