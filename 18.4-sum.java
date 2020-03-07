/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 */

// @lc code=start
class Solution {
    class Pair {
        int first;
        int second;
        public int sum;
    }

    // class Comparator<Pair> {
    //     @Override
    //     public int compare(Pair a, Pair b) {
    //         return a.sum - b.sum;
    //     }
    // }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int l = nums.length;
        if (l < 4) {
            return new ArrayList<List<Integer>>();
        } 
        Pair[] pairs = new Pair[(l * (l-1)) / 2];
        int k = 0;
        for (int i = 0; i < l - 1; i++) {
            for (int j = i + 1; j < l; j++) {
                pairs[k] = new Pair();
                pairs[k].first = i;
                pairs[k].second = j;
                pairs[k].sum = nums[i] + nums[j];
                k++;
            }
        }
        LinkedList<List<Integer>> result2 = new LinkedList<>();
        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(pairs, (a, b) -> a.sum - b.sum);
        for (Pair p : pairs) {
            result2.add(new LinkedList<Integer>() {pair.first, pair.second, pair.sum, 0 });
        }        
        return result2;
        // int s = 0;
        // int e = pairs.length - 1;
        // while (s < e) {
        //     int sum = pairs[s].sum + pairs[e].sum;
        //     if (
        //         sum == target && 
        //         pairs[s].first != pairs[e].first && 
        //         pairs[s].first != pairs[e].second && 
        //         pairs[s].second != pairs[e].first && 
        //         pairs[s].second != pairs[e].second
        //     ) {
        //         Integer[] list = new Integer[4];
        //         list[0] = nums[pairs[s].first];
        //         list[1] = nums[pairs[s].second];
        //         list[2] = nums[pairs[e].first];
        //         list[3] = nums[pairs[e].second];
        //         Arrays.sort(list);
        //         result.add(Arrays.asList(list));
        //         result2.add(Arrays.asList(list));
        //     }
        //     if (sum < target) {
        //         s++;
        //     } else {
        //         e--;
        //     }
        // }
        // return new ArrayList<List<Integer>>(result);
        // return result2;
    }
/*

[-3,-2,-1,0,0,1,2,3]\n0
[-3,-2,-1,0,0,1,2]\n0
[-2,-1,0,0,1,2]\n0
*/

}
// @lc code=end

