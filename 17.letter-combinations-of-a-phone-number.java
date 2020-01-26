/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {

    HashMap<Character, String> h = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
      }};

    List<String> result = new LinkedList<String>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }
        sb.append(digits);
        letterCombinations(digits, 0);
        return result;
    }

    private void letterCombinations(String digits, int index) {
        if (digits.length() == index) {
            result.add(sb.toString());
            return;
        }

        char d = digits.charAt(index);
        for (Character c : h.get(d).toCharArray()) {
            sb.setCharAt(index, c);
            letterCombinations(digits, index + 1);
        }
    }
}
// @lc code=end

