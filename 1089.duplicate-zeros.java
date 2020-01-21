/*
 * @lc app=leetcode id=1089 lang=java
 *
 * [1089] Duplicate Zeros
 */

// @lc code=start
class Solution {

    /*
        [] => []
        [5] => [5]
        [2,3,4] => [2,3,4]
        [0] => [0] 
        [0,5] => [0,0]
        [0, 0] => [0, 0]
               i
        [0, 1, 0, 5] => [0, 1, 1, 1]
        z: 1
    */
    public void duplicateZeros(int[] arr) {
        int z = 0;
        int l = arr.length;
        for (int i = 0; i < l; i++) {
            if (arr[i] == 0) {
                z++;
            }
        }
        // z: 2
        //           i
        //[1,0,2,3,0,4,5,0]
        for (int i = l - 1; i >= 0 && z > 0; i--) {
            if (arr[i] == 0) {
                if (i + z < l) {
                    arr[i + z] = 0;
                }
                if (i + z - 1 < l) {
                    arr[i + z - 1] = 0;
                }
                z--;
            } else if (i + z < l) {
                arr[i + z] = arr[i];
            }
        }
    }
}
// @lc code=end

