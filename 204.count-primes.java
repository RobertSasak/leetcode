/*
 * @lc app=leetcode id=204 lang=java
 *
 * [204] Count Primes
 */

// @lc code=start
class Solution {
    
    public int countPrimes(int n) {
        return countPrimesForLoop(n);
        // return countPrimesSeive(n);
    }

    // 1 => true
    // 2 => true
    // 3 => true
    // 4 => false
    // 5 => true
    // 6 => false
    private boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int countPrimesForLoop(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    // i = 2
    // m = 10
    //  f f f f t f t f f f
    // [0,1,2,3,4,5,6,7,8,9]
    public int countPrimesSeive(int n) {
        boolean[] a = new boolean[n];
        int primes = 0;
    
        int i = 2;
        while (i < n) {
            if (!a[i]) {
                primes++;
                int m = i;
                while (m < n) {
                    a[m] = true;
                    m += i;
                }
            }
            i++;
        }
        return primes;
    }
}
// @lc code=end

