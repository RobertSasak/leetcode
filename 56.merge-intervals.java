/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        List<int[]> list = new LinkedList<int[]>();

        int l = intervals.length;
        int i = 0;
        while (i < l) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            i++;
            while (i < l && intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
                i++;
            }
            int[] pair = {start, end};
            list.add(pair);
        }
        int[][] r = new int[list.size()][2];
        i = 0;
        for (int[] a : list) {
            r[i][0] = a[0];
            r[i][1] = a[1];
            i++;
        }
        return r;
    }
}
// @lc code=end

