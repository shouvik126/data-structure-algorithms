class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int i = 0;
        int j = 0;
        int bestMin = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        int[] bestMinLenTillIdx = new int[n];
        Arrays.fill(bestMinLenTillIdx, Integer.MAX_VALUE);
        int currSum = 0;
        while (j < n) {
            currSum += arr[j];
            while(i < j && currSum > target) {
                currSum -= arr[i];
                i++;
            }
            int len = j - i + 1;
            if (i > 0 && currSum == target && bestMinLenTillIdx[i - 1] != Integer.MAX_VALUE) {
                res = Math.min(res, bestMinLenTillIdx[i - 1] + len);
            }
            if (currSum == target) {
                bestMin = Math.min(bestMin, len);
            }
            bestMinLenTillIdx[j] = bestMin;
            j++;
        }
        return res != Integer.MAX_VALUE ? res : -1;
    }
}