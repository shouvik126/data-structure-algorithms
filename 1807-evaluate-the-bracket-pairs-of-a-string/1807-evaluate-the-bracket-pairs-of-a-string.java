class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }
        int n = s.length();
        int i = 0;
        StringBuilder sb = new StringBuilder("");
        while (i < n) {
            if (s.charAt(i) == '(') {
                int j = s.indexOf(')', i + 1);
                String temp = s.substring(i+1, j);
                sb.append(map.containsKey(temp) ? map.get(temp) : '?');
                i = j;
            }else {
                sb.append(s.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }
}