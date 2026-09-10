/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int result = 0;
    int count = 0;
    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return result;
    }

    public void solve(TreeNode root) {
        if (root == null) {
            return;
        }
        count = 0;
        int sum = findSum(root);
        if ((sum / count) == root.val) {
            result++;
        }
        solve(root.left);
        solve(root.right);
    }
    public int findSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        count++;
        int leftSum = findSum(root.left);
        int rightSum = findSum(root.right);
        return leftSum + rightSum + root.val;
    }
}