//Approach-1 (Greedy Pick using map)
//T.C : O(N), N = reservedSeats.length
//S.C : O(N), for storing reserved seats in map (in form of HashSet)
/*class Solution {
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
}*/

//Approach-2 (Greedy Pick using bit mask)
//T.C : O(N), N = reservedSeats.length
//S.C : O(N), for storing reserved seats in the form of mask
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] val : reservedSeats) {
            map.merge(val[0], 1 << val[1], (a, b) -> a | b);
        }
        int ans = 0;
        ans += (n - map.size()) * 2;

        int maskA = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
        int maskB = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);
        int maskC = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();

            boolean groupA = (value & maskA) == 0;
            boolean groupB = (value & maskB) == 0;
            boolean groupC = (value & maskC) == 0;
            

            if (groupA && groupC) {
                ans += 2;
            } else if (groupA || groupB || groupC) {
                ans += 1;
            }
        }
        return ans;
    }
}