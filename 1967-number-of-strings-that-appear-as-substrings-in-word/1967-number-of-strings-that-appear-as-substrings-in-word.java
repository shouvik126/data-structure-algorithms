class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int N = word.length();
        int result = 0;
        
        for (String pat : patterns) {
            int i = 0;
            int j = 0;
            int M = pat.length();
            int[] LPS = computeLPS(pat);

            while (i < N) {
                if (word.charAt(i) == pat.charAt(j)) {
                    i++;
                    j++;
                }
                if (j == M) {
                    result++;
                    break;
                } else if (i < N && word.charAt(i) != pat.charAt(j)) {
                    if (j != 0) {
                        j = LPS[j - 1];
                    } else {
                        i++;
                    }
                }
            }
        }
        return result;
    }

    public int[] computeLPS(String pat) {
        int[] LPS = new int[pat.length()];
        LPS[0] = 0;
        int length = 0;
        int i = 1;
        int m = pat.length();

        while (i < m) {
            if (pat.charAt(i) == pat.charAt(length)) {
                length++;
                LPS[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = LPS[length - 1];
                } else {
                    LPS[i] = 0;
                    i++;
                }
            }
        }
        return LPS; 
    }
}