//Approach (Factorisation + Cumulative Sum + Binary Search)
//T.C : O(n·sqrt(M) + M·log M + Q·log M), M = maxVal
//S.C : O(M), M = maxVal
class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max_val = Arrays.stream(nums).max().getAsInt();
        int n = nums.length;

        int[] factFreq = new int[max_val + 1];

        for (int num :  nums) {
            for (int j = 1; j*j <= num; j++) {
                if (num % j == 0) {
                    factFreq[j]++;
                    if (num / j != j) {
                        factFreq[num / j]++;
                    }
                }
            }
        }

        long[] factPairCount = new long[max_val + 1];
        for (int i = max_val; i >= 1; i--) {
            factPairCount[i] = factFreq[i] * (factFreq[i] - 1L) / 2L;

            for (int j = 2 * i ; j <= max_val; j += i) {
                factPairCount[i] -= 0L + factPairCount[j];
            }
        }

        long[] prefixPairCount = new long[max_val + 1];
        for (int i = 1; i <= max_val; i++) {
            prefixPairCount[i] = prefixPairCount[i - 1] + factPairCount[i];
        }

        List<Integer> ans = new ArrayList<>();

        for (long idx : queries) {
            int l = 1;
            int r = max_val;
            int temp = 0;
            while (l <= r) {
                int mid = l + (r - l)/2;

                if (prefixPairCount[mid] > idx) {
                    temp = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            ans.add(temp);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}