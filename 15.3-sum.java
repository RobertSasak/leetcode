/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
    //    i     j k
    // [3,0,-2,-1,1,2]
    // list 3,-2,-1 | 0,-2,2 
    // h -6, -4

    private List<Integer> triple(int a, int b, int c) {
        List<Integer> l = new LinkedList();
        l.add(a); 
        l.add(b); 
        l.add(c);
        return l;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int l = nums.length;
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        Arrays.sort(nums);

        for (int i = 0; i < l - 2; i++) {
            // two sum problem
            int l = i + 1;
            int r = l - 1;
            while (l < r) {
                int s = nums[i] + nums[l] + nums[r];
                if (s == 0) {
                    list.add(triple(nums[i], nums[l], nums[r]));
                } else if (s < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return list;
    }


    public List<List<Integer>> threeSum(int[] nums) {
        int l = nums.length;
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        HashSet<Long> h = new HashSet<Long>();
        for (int i = 0; i < l - 2; i++) {
            for (int j = i + 1; j < l - 1; j++) {
                for (int k = j + 1; k < l; k++) {
                    long key = hash(nums[i], nums[j], nums[k]);
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0 && !h.contains(key)) {
                        List<Integer> tripple = new LinkedList<Integer>();
                        tripple.add(nums[i]);
                        tripple.add(nums[j]);
                        tripple.add(nums[k]);
                        list.add(tripple);
                        h.add(key);
                    }
                }
            }
        }
        return list;
    }

    private long hash(long a, long b) {
        if (a > b) {
            return hash(b, a);
        }
        return (a + b)*(a + b + 1) / 2 + b;
    }

    private long hash(int a, int b, int c) {
        long t;
        if (a > b) {
            t = b;
            b = a;
            a = t;
        } 
        if (b > c) {
            t = c;
            c = b;
            b = t;
        }
        if (a > b) {
            t = b;
            b = a;
            a = t;
        }
        return hash(a, hash(b, c));
    }
}
// @lc code=end

