class Solution {
    int n;
    int idx;
    String s;
    public List<String> braceExpansionII(String expression) {
        n = expression.length();
        idx = 0;
        s = expression;
        Set<String> res = performUnion();
        return new ArrayList<String>(res);
    }
    public Set<String> getUnit() {
        Set<String> res = new TreeSet<>();
        if (s.charAt(idx) == '{') {
            idx++;
            res = performUnion();
        } else {
            res.add(String.valueOf(s.charAt(idx)));
        }
        idx++;
        return res;
    }
    public Set<String> performConcat() {
        Set<String> res = new TreeSet<>();
        res.add("");
        while (idx < n && (s.charAt(idx) == '{' || Character.isLetter(s.charAt(idx)))) {
            Set<String> temp = getUnit();
            Set<String> concatResult = new TreeSet<>();
            for (String left : res) {
                for (String right : temp) {
                    concatResult.add(left + right);
                }
            }
            res = concatResult;
        }
        return res;
    }
    public Set<String> performUnion() {
        Set<String> res = new TreeSet<>();
        while (true) {
            Set<String> temp = performConcat();
            res.addAll(temp);

            if (idx < n && s.charAt(idx) == ',')
                idx++;
            else
                break;
        }
        return res;
    }
}