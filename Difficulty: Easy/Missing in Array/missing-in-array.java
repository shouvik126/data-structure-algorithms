class Solution {
    int missingNum(int arr[]) {
        // code here
        Set<Integer> s = new HashSet<>();
        int n = arr.length;
        for (int val : arr) {
            s.add(val);
        }
        
        for (int i = 1; i <= n + 1; i++) {
            if (!s.contains(i)) {
                return i;
            }
        }
        return 0;
    }
}