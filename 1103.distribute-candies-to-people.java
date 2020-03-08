/*
 * @lc app=leetcode id=1103 lang=java
 *
 * [1103] Distribute Candies to People
 */

// @lc code=start
class Solution {

    // public int[] distributeCandies(int candies, int num_people) {
    //     // 1 2 3 4 5
    //     // 6 7 8 9 10

    //     // r1 = (1 + num_people) * num_people / 2
    //     // r2 = (r2 + num_people) * num_people / 2

    //     // 1  2  3  4
    //     // 5  6  7  8
    //     // 9 10  5

    //     int counter = 1;
    //     int rounds = 0;
    //     int d = (counter + num_people) * num_people / 2;
    //     while (d < candies) {
    //         counter += num_people * num_people;
    //         candies -= d;
    //         rounds++;
    //     }

    //     int[] a = new int[num_people];
        
    //     for (int i = 0; rounds > 0 && i < num_people; i++) {
    //         a[i] = i + 1 + (rounds - 1)* num_people;
    //     }

    //     int i = 0;
    //     while (candies > 0) {
    //         if (candies >= counter) {
    //             candies -= counter;
    //             a[i] += counter;
    //         } else {
    //             a[i] += candies;
    //             candies = 0;
    //         }
    //         i = (i + 1) % num_people;
    //         counter++;
    //     }
    //     return a;
    // }

    public int[] distributeCandiesSlow(int candies, int num_people) {
        int[] a = new int[num_people];
        int i = 0;
        int counter = 1;
        while (candies > 0) {
            if (candies >= counter) {
                candies -= counter;
                a[i] += counter;
            } else {
                a[i] += candies;
                candies = 0;
            }
            i = (i + 1) % num_people;
            counter++;
        }
        return a;
    }
}
// @lc code=end

