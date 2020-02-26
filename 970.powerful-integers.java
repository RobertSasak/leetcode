/*
 * @lc app=leetcode id=970 lang=java
 *
 * [970] Powerful Integers
 */

// @lc code=start
class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        HashSet<Integer> h = new HashSet();
        List<Integer> l = new LinkedList<Integer>();
        int bx = 1;
        while (bx <= bound) {
            int by = 1;
            while (bx + by <= bound) {
                if (!h.contains(bx + by)) {
                    l.add(bx + by);
                    h.add(bx + by);
                }
                if (y == 1) {
                    break;
                }
                by *= y;
            }
            if (x == 1) {
                break;
            }
            bx *= x;
        }
        return l;
    }
}
// @lc code=end

