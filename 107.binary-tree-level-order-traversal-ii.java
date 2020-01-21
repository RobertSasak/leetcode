/*
 * @lc app=leetcode id=107 lang=java
 *
 * [107] Binary Tree Level Order Traversal II
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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new LinkedList<List<Integer>>();
        }
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root); 

        while (!q.isEmpty()) {
            int s = q.size();
            List<Integer> level = new LinkedList<Integer>();
            for (int i = 0; i < s; i++) {
                TreeNode n = q.remove();
                level.add(n.val);
                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                }
            }
            list.add(0, level);
        }
        return list;
    }

    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        levelOrderBottom2(root, list, 0);    
        return list;
    }

    private void levelOrderBottom2(TreeNode root, List<List<Integer>> list, int level) {
        if (root == null) {
            return;
        }
        if (level >= list.size()) {
            list.add(0, new LinkedList<Integer>());
        }
        levelOrderBottom2(root.left, list, level + 1);
        levelOrderBottom2(root.right, list, level + 1);
        list.get(list.size() - level - 1).add(root.val);
    }
}
// @lc code=end

