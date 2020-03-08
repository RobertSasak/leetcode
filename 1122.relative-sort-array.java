/*
 * @lc app=leetcode id=1122 lang=java
 *
 * [1122] Relative Sort Array
 */

// @lc code=start
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> h = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            h.put(arr2[i], i);
        }

        Integer[] arr1Integer = new Integer[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr1Integer[i] = arr1[i];
        }
        Arrays.sort(arr1Integer, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                Integer ai = h.getOrDefault(a, null);
                Integer bi = h.getOrDefault(b, null);
                if (ai == null && bi == null) {
                    return a - b;
                }
                if (ai == null) {
                    return 1;
                }
                if (bi == null) {
                    return -1;
                }
                return ai - bi;
            }
        });
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr1Integer[i];
        }
        return arr1;
    }
}
// @lc code=end

