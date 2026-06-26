class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int curSum = 0;
        map.put(0, 1);

        long validLeftPoints = 0;
        long result = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                validLeftPoints += map.getOrDefault(curSum, 0);
                curSum += 1;
            } else {
                curSum -= 1;
                validLeftPoints -= map.getOrDefault(curSum, 0);
            }
            result += validLeftPoints;
            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        }
        return result;
    }
}