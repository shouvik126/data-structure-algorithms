//Approach-1 (Greedy Pick using map)
//T.C : O(N), N = reservedSeats.length
//S.C : O(N), for storing reserved seats in map (in form of HashSet)
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] val : reservedSeats) {
            map.computeIfAbsent(val[0], k -> new HashSet<>()).add(val[1]);
        }
        int ans = 0;
        ans += (n - map.size()) * 2;

        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            Set<Integer> values = entry.getValue();

            boolean groupA = !values.contains(2) && !values.contains(3) && !values.contains(4) && !values.contains(5);
            boolean groupB = !values.contains(4) && !values.contains(5) && !values.contains(6) && !values.contains(7);
            boolean groupC = !values.contains(6) && !values.contains(7) && !values.contains(8) && !values.contains(9);

            if (groupA && groupC) {
                ans += 2;
            } else if (groupA || groupB || groupC) {
                ans += 1;
            }
        }
        return ans;
    }
}