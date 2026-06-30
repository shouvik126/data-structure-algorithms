class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();

        int i = 0;
        int j = 0;

        int result = 0;
        int[] count = new int[3];
        while (j < n) {
            count[s.charAt(j) - 'a']++;

            while (count[0] > 0 && count[1] > 0 && count[2] > 0){
                result += n - j;
                
                count[s.charAt(i) - 'a']--;
                i++;
            }
            j++;
        }
        return result;
    }
}