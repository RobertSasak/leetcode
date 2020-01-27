/*
 * @lc app=leetcode id=676 lang=java
 *
 * [676] Implement Magic Dictionary
 */

// @lc code=start
class MagicDictionary {

    HashMap<String, Integer> h;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        h = new HashMap();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] words) {
        for (String w : words) {
            h.put(w, 0);
			for (String g : generateOneDistance(w)) {
				h.put(g, h.getOrDefault(g, 0) + 1);
			}
		}
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String w) {
        for (String s : generateOneDistance(w)) {
            int o = h.getOrDefault(s, 0);
            if (o >= 2) {
                return true;
            }
            if (o == 1 && !h.containsKey(w)) {
                return true;
            }
        }
        return false;
    }

    List<String> generateOneDistance(String word) {
        List<String> s = new LinkedList<String>();
        StringBuilder sb = new StringBuilder();
        sb.append(word);
        int l = word.length();
        for (int i = 0; i < l; i++) {
            char c = sb.charAt(i);
            sb.setCharAt(i, '*');
            s.add(sb.toString());
            sb.setCharAt(i, c);
        }
        return s;
    }

}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

