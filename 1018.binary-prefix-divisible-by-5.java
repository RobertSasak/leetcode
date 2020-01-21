/*
 * @lc app=leetcode id=1018 lang=java
 *
 * [1018] Binary Prefix Divisible By 5
 */

// @lc code=start
class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> l = new LinkedList<Boolean>();   
        int n = 0;
        for (int i = 0; i < A.length; i++) {
            n = (n << 1) + A[i];
            l.add(n % 5 == 0);
            n = n % 5;
        }
        return l;
    }
}
// @lc code=end

