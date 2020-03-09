/*
 * @lc app=leetcode id=965 lang=java
 *
 * [965] Univalued Binary Tree
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
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return false;
        return isUnivalTree(root.left, root.val) && 
                isUnivalTree(root.right, root.val);
    }
    
    boolean isUnivalTree(TreeNode root, int val) {
        if (root == null) return true;
        if (root.val != val) return false;
        return isUnivalTree(root.left, val) &&
                isUnivalTree(root.right, val);
    }
}
// @lc code=end

