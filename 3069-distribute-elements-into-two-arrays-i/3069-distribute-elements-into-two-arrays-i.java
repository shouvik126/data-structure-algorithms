class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(nums[0]);
        list2.add(nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int last1 = list1.get(list1.size() - 1);
            int last2 = list2.get(list2.size() - 1);
            if (last1 > last2) {
                list1.add(nums[i]);
            } else {
                list2.add(nums[i]);
            }
        }
        int k = 0;
        for (int i = 0; i < list1.size(); i++) {
            nums[k] = list1.get(i);
            k++;
        }

        for (int i = 0; i < list2.size(); i++) {
            nums[k] = list2.get(i);
            k++;
        }
        return nums;
    }
}