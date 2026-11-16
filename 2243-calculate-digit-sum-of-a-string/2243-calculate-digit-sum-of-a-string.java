class Solution {
    public String digitSum(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() > k) {
            List<String> group = new ArrayList<>();
            int n = sb.length();
            for (int i = 0; i < n; i += k) {
                int end = Math.min(n, i + k);
                group.add(sb.substring(i, end));
            }
            sb.setLength(0);
            for (String st : group) {
                int sum = st.chars()
                .map(Character::getNumericValue)
                .sum();
                sb.append(sum);
            }
        }
        return sb.toString();
    }
    
}