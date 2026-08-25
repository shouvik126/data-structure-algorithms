class Solution {
    public int missingMultiple(int[] nums, int k) {
       Set<Integer> set = new HashSet<>();
       for (int val : nums) {
        set.add(val);
       }
       int mul = 1;
       while (set.contains(k * mul)) {
        mul++;
       }
       return k *  mul;
    }
}