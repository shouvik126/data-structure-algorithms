class Solution {
    public int maximumLengthSubstring(String s) {
        int ans = Integer.MIN_VALUE;
        int n = s.length();
        int i = 0;
        int j = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (j < n) {
            map.compute(s.charAt(j), (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return v + 1;
            });
            while(i < j && map.get(s.charAt(j)) > 2) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                i++;
            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
}