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

 //Approach-1 (Brute Force)
//T.C : O(n^2) For every root, you visit it's subtree to find average
//S.C : O(1) (excluding recursion stack space)
// class Solution {
//     int result = 0;
//     int count = 0;
//     public int averageOfSubtree(TreeNode root) {
//         solve(root);
//         return result;
//     }

//     public void solve(TreeNode root) {
//         if (root == null) {
//             return;
//         }
//         count = 0;
//         int sum = findSum(root);
//         if ((sum / count) == root.val) {
//             result++;
//         }
//         solve(root.left);
//         solve(root.right);
//     }
//     public int findSum(TreeNode root) {
//         if (root == null) {
//             return 0;
//         }
//         count++;
//         int leftSum = findSum(root.left);
//         int rightSum = findSum(root.right);
//         return leftSum + rightSum + root.val;
//     }
// }

class Solution {
    int result = 0;
    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return result;
    }

    public Pair<Integer, Integer> solve(TreeNode root) {
        if (root == null) {
            return new Pair<>(0, 0);
        }
        Pair<Integer, Integer> p1 = solve(root.left);
        Pair<Integer, Integer> p2 = solve(root.right);
        int totalCount = p1.getKey() + p2.getKey() + 1;
        int totalSum = p1.getValue() + p2.getValue() + root.val;
        int avg = totalSum / totalCount;
        if (avg == root.val) {
            result++;
        }
        return new Pair<>(totalCount, totalSum);
    }
}