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

    // DFS
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        serialize(root, sb);
        System.out.println(sb.toString());
        return sb.toString();
    }
    
    void serialize(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        
        sb.append(root.val + ",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }
    
    public TreeNode deserialize(String data) {
        String[] splitted = data.split(",");
        Queue<Integer> q = new LinkedList<>();
        for (String s : splitted) {
            if (s.equals("null")) {
                q.add(null);
            } else {
                q.add(Integer.parseInt(s));
            }
        }
        return deserialize(q);
    }
    
    public TreeNode deserialize(Queue<Integer> q) {
        Integer n = q.poll();
        if (n == null) {
            return null;
        }
        
        TreeNode node = new TreeNode(n);
        node.left = deserialize(q);
        node.right = deserialize(q);
        return node;
    }
            
    
    // BFS serialization
    public String serializeBFS(TreeNode root) {
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

    public TreeNode deserializeBFS(String data) {
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

