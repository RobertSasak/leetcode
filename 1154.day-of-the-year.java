/*
 * @lc app=leetcode id=1154 lang=java
 *
 * [1154] Day of the Year
 */

// @lc code=start
class Solution {
    public int dayOfYear(String date) {
        int year = (date.charAt(0)-'0')*1000 + (date.charAt(1)-'0')*100 + (date.charAt(2)-'0')*10 + (date.charAt(3)-'0');
        int month = (date.charAt(5)-'0')*10 + (date.charAt(6)-'0');
        int day = (date.charAt(8)-'0')*10 + (date.charAt(9)-'0');
        int d = day;
        if (month > 1) {
            d += 31;
        }
        if (month > 2) {
            d += 28;
            if (year % 4 == 0 && year % 100 != 0) {
                d++;
            }
        }
        
        if (month > 3) {
            d += 31;
        }
        if (month > 4) {
            d += 30;
        }
        if (month > 5) {
            d += 31;
        }
        if (month > 6) {
            d += 30;
        }
        if (month > 7) {
            d += 31;
        }
        if (month > 8) {
            d += 31;
        }
        if (month > 9) {
            d += 30;
        }
        if (month > 10) {
            d += 31;
        }
        if (month > 11) {
            d += 30;
        }
        return d;
    }
}
// @lc code=end

