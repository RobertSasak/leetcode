/*
 * @lc app=leetcode id=166 lang=java
 *
 * [166] Fraction to Recurring Decimal
 */

// @lc code=start
class Solution {
    StringBuilder sb = new StringBuilder();
    boolean hasDot = false;
    HashMap<Long, HashMap<Long, Integer>> h = new HashMap<Long, HashMap<Long, Integer>>();

    public String fractionToDecimal(long numerator, long denominator) {
        if (denominator == 0) {
            // throw error
        }
        if (
            (numerator < 0 && denominator > 0) ||
            (numerator > 0 && denominator < 0)
        ) {
            sb.append('-');
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
        }
        sb.append(numerator / denominator);
        if (numerator % denominator == 0) {
            return sb.toString();
        }
        sb.append('.');
        fraction((numerator % denominator) * 10, denominator);
        return sb.toString();
    }

    public void fraction(long numerator, long denominator) {
        if (numerator % denominator == 0) {
            sb.append(numerator / denominator);
            return;
        }
        if (!h.containsKey(numerator)) {
            h.put(numerator, new HashMap<Long, Integer>());
        }
        HashMap<Long, Integer> a = h.get(numerator);
        if (a.containsKey(denominator)) {
            int index = a.get(denominator);
            sb.insert(index, '(');
            sb.append(')');
            return;
        } else {
            a.put(denominator, sb.length());
        }
        sb.append(numerator / denominator);   
        fraction((numerator % denominator) * 10, denominator);
    }
}
// @lc code=end

