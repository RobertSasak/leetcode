/*
 * @lc app=leetcode id=975 lang=java
 *
 * [975] Odd Even Jump
 */

// @lc code=start
class Solution {
    public int oddEvenJumps(int[] A) {
        int l = A.length;
        boolean[] odd = new boolean[l];
        boolean[] even = new boolean[l];
        
        odd[A.length - 1] = true;
        even[A.length - 1] = true;
        
        TreeMap<Integer, Integer> m = new TreeMap<>();
        m.put(A[l - 1], l - 1);
        for (int i = l - 2; i >= 0; i--) {
            Integer up = m.ceilingKey(A[i]);
            Integer down = m.floorKey(A[i]);
            
            if (up != null) odd[i] = even[m.get(up)];
            if (down != null) even[i] = odd[m.get(down)];
            m.put(A[i], i);
        }
        
        int sum = 0;
        for (int i = 0; i < l; i++) {
            if (odd[i]) sum++;
        }
        return sum;
    }



    // Slow solution
    int[] A;
    Boolean[] oddMemo;
    Boolean[] evenMemo;
    int sum = 0;
    public int oddEvenJumpsSlow(int[] A) {
        this.A = A;
        oddMemo = new Boolean[A.length];
        evenMemo = new Boolean[A.length];
        
        for (int i = 0; i < A.length; i++) {
            odd(i);
        }
        return sum;
    }
    
    boolean odd(int s) {
        if (s == A.length - 1) {
            sum++;
            return true;
        }
        if (oddMemo[s] != null) {
            if (oddMemo[s]) sum++;
            return oddMemo[s];
        }
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = s + 1; i < A.length; i++) {
            if (A[i] >= A[s] && A[i] < min) {
                index = i;
                min = A[i];
            }
        }
        if (index == -1) return false;
        oddMemo[s] = even(index);
        return oddMemo[s];
    }
    
    boolean even(int s) {
        if (s == A.length - 1) {
            sum++;
            return true;
        }
        if (evenMemo[s] != null) {
            if (evenMemo[s]) sum++;
            return evenMemo[s];
        }
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = s + 1; i < A.length; i++) {
            if (A[i] <= A[s] && A[i] > max) {
                index = i;
                max = A[i];
            }
        }
        if (index == -1) return false;
        evenMemo[s] = odd(index);
        return evenMemo[s];
    }
}
// @lc code=end

