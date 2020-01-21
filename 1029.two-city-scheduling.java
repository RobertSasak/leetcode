/*
 * @lc app=leetcode id=1029 lang=java
 *
 * [1029] Two City Scheduling
 */

// @lc code=start
class Solution {
    /*[
        [840,118] 722
        [259,770] 511
        [448,54]  394
        [926,667] 259
        [577,469] 108
        [184,139] 45

        118 + 259 + 54 + 667 + 577 + 184
    */
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                int ad = Math.abs(a[0] - a[1]);
                int bd = Math.abs(b[0] - b[1]);
                return bd - ad;
            }
        });

        int sum = 0;
        int a = costs.length / 2;
        int b = costs.length / 2;
        for (int i = 0; i < costs.length; i++) {
            int[] c = costs[i];
            if (a == 0) {
                sum += c[1];
                b--;
            } else if (b == 0) {
                sum += c[0];
                a--;
            } else if (c[0] <= c[1]) {
                sum += c[0];
                a--;
            } else {
                sum += c[1];
                b--;
            }
        }
        return sum;
    }
}
// @lc code=end

