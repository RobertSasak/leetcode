/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        LinkedList<List<Integer>> r = new LinkedList<>();
        if (numRows == 0) {
            return r;
        }
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        r.add(list);
        while (numRows > 1) {
            LinkedList<Integer> newList = new LinkedList<>();
            int prev = 0;
            for (int n : list) {
                newList.add(n + prev);
                prev = n;
            }
            newList.add(1);
            r.add(newList);
            list = newList;
            numRows--;
        }
        return r;
    }
}
// @lc code=end

