class Solution {
    private int digitSumSwap(int num1, int num2) {
        int a = getDigitSum(num1);
        int b = getDigitSum(num2);

        if (a != b) {
            return Integer.compare(a, b);
        }

        return Integer.compare(num1, num2);
    }
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    public int minSwaps(int[] nums) {
        int n = nums.length;
        Integer[] afterSort = new Integer[n];
        Map<Integer, Integer> valToIdx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            afterSort[i] = nums[i];
            valToIdx.put(nums[i], i);
        }
        Arrays.sort(afterSort, this::digitSumSwap);

        int swap = 0;
        for (int i = 0; i < n; i++) {
            int expected = afterSort[i];
            int curr = nums[i];
            if (expected == curr) continue;
            int expIdx = valToIdx.get(expected);
            nums[i] = nums[expIdx];
            nums[expIdx] = curr;
            valToIdx.put(expected, i);
            valToIdx.put(curr, expIdx);
            swap++;
        }
        return swap;
    }
}