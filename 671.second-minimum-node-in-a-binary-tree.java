/*
 * @lc app=leetcode id=671 lang=java
 *
 * [671] Second Minimum Node In a Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int min;
    long answer = Long.MAX_VALUE;

    public int findSecondMinimumValue(TreeNode root) {
        min = root.val;
        dfs(root);
        return answer < Long.MAX_VALUE ? (int)answer : -1;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (min < root.val && root.val < answer) {
            answer = root.val;
        } else if (min == root.val) {
            dfs(root.left);
            dfs(root.right);
        }
    }
}
// @lc code=end

