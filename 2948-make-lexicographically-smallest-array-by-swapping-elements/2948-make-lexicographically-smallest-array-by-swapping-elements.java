// Brute Force Approach
// class Solution {
//     public int[] lexicographicallySmallestArray(int[] nums, int limit) {
//         for (int i = 0; i < nums.length; i++) {
//             while (true) {
//                 int idx = -1;
//                 int small = nums[i];
//                 for (int j = i + 1; j < nums.length; j++) {
//                     if (nums[j] < small && Math.abs(nums[j] - small) <= limit) {
//                         small = nums[j];
//                         idx = j;
//                         break;
//                     }
//                 }
//                 if (idx != -1) {
//                     int temp = nums[i];
//                     nums[i] = small;
//                     nums[idx] = temp;
//                 } else {
//                     break;
//                 }

//             }
//         }
//         return nums;
//     }
// }


class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] sortNums = nums.clone();
        Arrays.sort(sortNums);
        Map<Integer, Integer> valToGroup = new HashMap<>();
        Map<Integer, Deque<Integer>> groupToList= new HashMap<>();
        int group = 0;
        valToGroup.put(sortNums[0], 0);
        LinkedList<Integer> l = new LinkedList<>();
        l.offerLast(sortNums[0]);
        groupToList.put(0, l);
        for (int i = 1; i < sortNums.length; i++) {
            if (Math.abs(sortNums[i] - sortNums[i - 1]) > limit) {
                group++;
            }
            valToGroup.put(sortNums[i], group);
            int val = sortNums[i];
            groupToList.compute(group, (k, v) -> {
                if (v == null) {
                    v = new LinkedList<Integer>();
                }
                v.offerLast(val);
                return v;
            });
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int g = valToGroup.get(num);
            res[i] = groupToList.get(g).pollFirst();
        }
        return res;
    }
}