/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {

    private double median(int[] a int s, int e) {
        int l = a.length();
        if (l % 2 == 1) {
            return a[l / 2 + 1]; 
        } else {
            return (a[l / 2] + a[l/2 + 1]) / 2;
        }
    }

    public double findMedianSortedArrays(int[] a, int[] b) {
        int la = a.length();
        int lb = b.length();


        if (la > lb) {
            return findMedianSortedArrays(b, a);
        }
        if (la == 0) {
            return median(b, 0, lb);
        }
        if (a[l - 1] < b[0]) {
            return median(b, 0, lb - la);
        }
        if (b[l - 1] > a[0]) {
            return median(b, la, lb);
        }

        
    }

    private double findMedianSortedArrays(int[] a, int[] bm, int i) {
        int j = 

    }
}
// @lc code=end

