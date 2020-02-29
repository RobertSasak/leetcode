/*
 * @lc app=leetcode id=1237 lang=java
 *
 * [1237] Find Positive Integer Solution for a Given Equation
 */

// @lc code=start
/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */
class Solution {
    // public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
    //     int sx = 1;
    //     int ex = 1000;
    //     int sy = 1;
    //     int ey = 1000;
    //     while (sx > se || sy > ey) {
    //         int mx = (sx + ex) / 2;
    //         if (customfunction.f(m))
    //     }
    // }
    
    public List<List<Integer>> findSolutionBruteForce(CustomFunction customfunction, int z) {
        List<List<Integer>> r = new LinkedList<>();
        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j <= 1000; j++) {
                if (customfunction.f(i, j) == z) {
                    List<Integer> l = new LinkedList<>();
                    l.add(i);
                    l.add(j);
                    r.add(l);
                }
            }
        }
        return r;
    }
}
// @lc code=end

