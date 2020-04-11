/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        ArrayList<Integer> r = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        r.add(root.val);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            if (n.left == null) {
                r.add(null);
            } else {
                r.add(n.left.val);
                q.add(n.left);
            }
            if (n.right == null) {
                r.add(null);
            } else {
                r.add(n.right.val);
                q.add(n.right);
            }
        }
        
        
        String[] s = new String[r.size()];
        int i = 0;
        for (Integer n : r) {
            s[i] = n == null ? "null" : n.toString();
            i++;
        }
        
        System.out.println(String.join(",", s));
        return "[" + String.join(",", s) + "]";
    }
  
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.replace("[", "").replace("]", "");
        if (data.isEmpty()) return null;
        String[] tokens = data.split(",");
        if (tokens.length == 0) return null;
        Integer[] nums = new Integer[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("null")) {
                nums[i] = null;
            } else {
                nums[i] = Integer.parseInt(tokens[i]);
            }
        }
        System.out.println();
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode head = new TreeNode(nums[0]);
        q.add(head);
        int i = 1;
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            n.left = null; 
            if (nums[i] != null) {
                n.left = new TreeNode(nums[i]);
                q.add(n.left);
            }
            i++;
            n.right = null;
            if (nums[i] != null) {
                n.right = new TreeNode(nums[i]);
                q.add(n.right);
            }
            i++;
        }
        return head;
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end

