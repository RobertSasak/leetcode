/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
    // O(N logN) average
    public int largestRectangleArea(int [] heights) {
        int l = heights.length;
        if (l == 0) {
            return 0;
        }
        int max = 0;
        int[] left = new int[l];
        int[] right = new int[l];

        left[0] = -1;
        for (int i = 1; i < l; i++) {
            int j = i - 1; 
            while (j >= 0 && heights[j] >= heights[i]) {
                j = left[j];
            }
            left[i] = j;
        }

        right[l - 1] = l;
        for (int i = l - 2; i >= 0; i--) {
            int j = i + 1;
            while (j < l && heights[j] >= heights[i]) {
                j = right[j];
            }
            right[i] = j;
        }

        for (int i = 0; i < l; i++) {
            int area = heights[i] * (right[i] - left[i] - 1);
            max = Math.max(max, area);
        }

        return max;
    }

    // O(N^2)
    public int largestRectangleAreaScanning(int[] heights) {
        int l = heights.length;
        int[] left = new int[l];
        int[] right = new int[l];
        int max = 0;
        for (int i = 0; i < l; i++) {
            int j = i - 1;
            while (j >= 0 && heights[j] >= heights[i]) {
                j--;
            }
            left[i] = j;

            j = i + 1;
            while (j < l && heights[j] >= heights[i]) {
                j++;
            }
            right[i] = j;

            int area = heights[i] * (right[i] - left[i] - 1);
            max = Math.max(max, area);
        }
        return max;
    }

    // average O(N logN), in worst case N^2
    public int largestRectangleAreaDivideAndConquer(int[] heights) {
        return largestRectangleArea(heights, 0, heights.length - 1);
    }

    public int largestRectangleArea(int[] heights, int s, int e) {
        if (e < s) {
            return 0;
        }
        // find minimum
        int minIndex = -1;
        int min = Integer.MAX_VALUE;
        for (int i = s; i <= e; i++) {
            if (min >= heights[i]) {
                minIndex = i;
                min = heights[i];
            }
        }

        return Math.max(
            min * (e - s + 1),
            Math.max(
                largestRectangleArea(heights, s, minIndex - 1),
                largestRectangleArea(heights, minIndex + 1, e)
            )
        );
    }

    // O(N) with Stack
    public int largestRectangleAreaStack(int[] heights) {
        int l = heights.length;
        Stack<Integer> s = new Stack<>();
        int max = 0;
        s.push(-1);
        for (int i = 0; i < l; i++) {
            while (s.peek() != -1 && heights[s.peek()] >= heights[i]) {
                max = Math.max(max, heights[s.pop()] * (i - s.peek() - 1));
            }
            s.push(i);
        }
        while (s.peek() != -1) {
            max = Math.max(max, heights[s.pop()] * (l - s.peek() - 1));
        }
        return max;
    }

    // N^2 
    public int largestRectangleAreaFine(int[] heights) {
        int l = heights.length;
        int max = 0;
        for (int i = 0; i < l; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < l; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                max = Math.max(max, minHeight * (j - i + 1));
            }
        }
        return max;
    }

    // N^3 bruteforce
    public int largestRectangleAreaSlow(int[] heights) {
        int l = heights.length;
        int max = 0;
        for (int i = 0; i < l; i++) {
            for (int j = i; j < l; j++) {
                int minHeight = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    minHeight = Math.min(minHeight, heights[k]);
                }
                max = Math.max(max, minHeight * (j - i + 1));
            }
        }
        return max;
    }
}
// @lc code=end

