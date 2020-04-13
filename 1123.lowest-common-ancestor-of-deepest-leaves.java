/*
 * @lc app=leetcode id=1123 lang=java
 *
 * [1123] Lowest Common Ancestor of Deepest Leaves
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
    int max = -1;
    TreeNode lowest;
    
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        lowest = root;
        depth(root, 0);
        return lowest;
    }
    
    int depth(TreeNode root, int d) {
        if (root == null) return d;
        
        int l = depth(root.left, d + 1);
        int r = depth(root.right, d + 1);
        if (l == r && l >= max) {
            max = l;
            lowest = root;
        }
        return Math.max(l, r);
    }
}
// @lc code=end

