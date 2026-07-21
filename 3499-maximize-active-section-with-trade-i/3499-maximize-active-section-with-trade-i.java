class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        List<Integer> list = new ArrayList<>();
        int count = 0;
        int noOfOne = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) - '0' == 1) {
                noOfOne++;
                if (count > 0) {
                    list.add(count);
                    count = 0;
                }
            } else {
                count++;
            }
        }
        if (count > 0) {
            list.add(count);
        }
        int max = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if(list.get(i) + list.get(i + 1) > max)
                max = list.get(i) + list.get(i + 1);
        }
        return max + noOfOne;
    }
}