class Solution {
    public boolean isPalindrome(int x) {
        String original = "" + x;
        String reversed = new StringBuilder(original).reverse().toString();
        return original.equals(reversed);
    }
}