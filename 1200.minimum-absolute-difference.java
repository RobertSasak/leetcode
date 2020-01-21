/*
 * @lc app=leetcode id=1200 lang=java
 *
 * [1200] Minimum Absolute Difference
 */

// @lc code=start
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        Arrays.sort(arr);

        List<List<Integer>> r = new LinkedList<List<Integer>>();
        
        int n = arr.length;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            min = Math.min(arr[i + 1] - arr[i], min);
        }
        for (int i = 0; i < n - 1; i++) {
            int a = arr[i];
            int b = arr[i + 1];
            int d = b - a;
            if (d == min) {
                LinkedList pair = new LinkedList();
                pair.add(a);
                pair.add(b);
                r.add(pair);
            }
        }
        return r;
    }
}
// @lc code=end

