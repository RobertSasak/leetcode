/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
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

    boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    boolean isValid(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min) {
            return false;
        }
        if (max != null && root.val >= max) {
            return false;
        }
        return 
            isValid(root.left, min, root.val) &&
            isValid(root.right, root.val, max);
    }


    // Complicated solution
    class MinMax {
        Integer min;
        Integer max;
        boolean isValid;
    }

    public boolean isValidBSTComplicated(TreeNode root) {
        return isValid(root).isValid;
    }

    MinMax isValid(TreeNode root) {
        MinMax r = new MinMax();
        r.min = null;
        r.max = null;
        r.isValid = true;
        if (root == null) {
            return r;
        }
        MinMax left = isValid(root.left);
        if (!left.isValid) {
            r.isValid = false;
            return r;
        }
        MinMax right = isValid(root.right);
        if (!right.isValid) {
            r.isValid = false;
            return r;
        }
        if (
            (left.max != null && left.max >= root.val) ||
            (right.min != null && right.min <= root.val)
        ) {
            r.isValid = false;
            return r;
        }
        r.min = root.val;
        r.max = root.val;
        if (left.min != null) {
            r.min = Math.min(left.min, r.min);
        }
        if (right.max != null) {
            r.max = Math.max(right.max, r.max);
        }
        return r;
    }
    
}
// @lc code=end

