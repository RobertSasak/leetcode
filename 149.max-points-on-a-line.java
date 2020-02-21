/*
 * @lc app=leetcode id=149 lang=java
 *
 * [149] Max Points on a Line
 */

// @lc code=start
class Solution {
    public int maxPoints(int[][] points) {
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Long, HashMap<Long, Integer>> h = new HashMap<>();
            int vertical = 1;
            int equal = 0;
            int maxOnLine = 0;
            for (int j = i + 1; j < points.length; j++) {
                int[] a = points[i];
                int[] b = points[j];
                long x = a[0] - b[0];
                long y = a[1] - b[1];
                if (x == 0 && y == 0) {
                    equal++;
                } else if (x == 0) {
                    vertical++;
                } else {
                    if (x < 0) {
                        x = -x;
                        y = -y;
                    }
                    long g = gcd(x, y);
                    x /= g;
                    y /= g;
                    if (!h.containsKey(x)) {
                        h.put(x, new HashMap<>());
                    }
                    int f = h.get(x).getOrDefault(y, 1) + 1;
                    h.get(x).put(y, f);
                    maxOnLine = Math.max(maxOnLine, f);
                }
            }
            max = Math.max(max, equal + maxOnLine);
            max = Math.max(max, equal + vertical);
        }    
        return max;
    }


    long gcd(long a, long b) {
        if (a < 0) {
            return gcd(-a, b);
        }
        if (b < 0) {
            return gcd(a, -b);
        }
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        if (a == b) {
            return a;
        }
        if (a > b) {
            return gcd(a % b, b);
        }
        return gcd(a, b % a);
    }
}
// @lc code=end

