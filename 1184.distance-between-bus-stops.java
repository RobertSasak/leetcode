/*
 * @lc app=leetcode id=1184 lang=java
 *
 * [1184] Distance Between Bus Stops
 */

// @lc code=start
class Solution {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        return Math.min(
            helper(distance, start, destination),
            helper(distance, destination, start)
        );
    }

    int helper(int[] distance, int start, int destination) {
        int s = 0;
        while (start != destination) {
            s += distance[start];
            start = (start + 1) % distance.length;
        }
        return s;
    }

    public int distanceBetweenBusStops2(int[] distance, int start, int destination) {
        if (start > destination) {
            return distanceBetweenBusStops(distance, destination, start);
        }
        int sum = 0;
        for (int d : distance) {
            sum += d;
        }
        int dist = 0;
        for (int i = start; i < destination; i++) {
            dist += distance[i];
        }
        return Math.min(dist, sum - dist);
    }

    public int distanceBetweenBusStops3(int[] distance, int start, int destination) {
        int l = distance.length;
        int plus = 0;
        int i = start;
        while (i != destination) {
            plus += distance[i];
            i = (i + 1) % l;
        }
        i = start;
        int minus = 0;
        while (i != destination) {
            i = (i + l - 1) % l;
            minus += distance[i];
        }
        return Math.min(plus, minus);
    }
}
// @lc code=end

