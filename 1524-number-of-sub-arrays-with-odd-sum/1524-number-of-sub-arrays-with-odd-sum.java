class Solution {
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int evenCount = 1;
        int oddCount = 0;
        int M = (int)1e9 + 7;
        int pSum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            pSum += arr[i];
            if (pSum % 2 == 0) { // even
                count = (count + oddCount) % M;
                evenCount++;
            } else { // odd
                count = (count + evenCount ) % M;
                oddCount++;
            }
        }
        return count;
    }
}