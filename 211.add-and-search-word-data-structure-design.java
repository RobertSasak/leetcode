/*
 * @lc app=leetcode id=211 lang=java
 *
 * [211] Add and Search Word - Data structure design
 */

// @lc code=start
class WordDictionary {

    class Node {
        Node[] children;
        boolean endHere;
        Node() {
            children = new Node[26];
        }
    }
    
    Node root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node n = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (n.children[c - 'a'] == null) {
                n.children[c - 'a'] = new Node();
            }
            n = n.children[c - 'a'];
        }
        n.endHere = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, 0, root);
    }
    
    public boolean search(String word, int index, Node root) {
        if (root == null) return false;
        if (index == word.length())
            return root.endHere;
        
        char c = word.charAt(index);
        if (c == '.') {
            for (Node n : root.children) {
                if (search(word, index + 1, n)) {
                    return true;
                }
            }
            return false;
        } else {
            return search(word, index + 1, root.children[c - 'a']);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

