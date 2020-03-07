/*
 * @lc app=leetcode id=1175 lang=java
 *
 * [1175] Prime Arrangements
 */

// @lc code=start
class Solution {
    //[123456789]
    //[100101011]
    public int numPrimeArrangements(int n) {
        boolean[] a = new boolean[n+1];
        a[1] = true;
        for (int i = 2; i * i <= n; i++) {
            int j = i * 2;
            while (j <= n) {
                a[j] = true;
                j += i;
            }
        }
        int primes = 0;
        for (int i = 1; i <= n; i++) {
            if (!a[i]) {
                primes++;
            }
        }        
        return (int)((factorial(primes) * factorial(n - primes)) % 1000000007);
    }

    long factorial(int n) {
        long sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            sum %= 1000000007;
        }
        return sum;
    }
}
// @lc code=end

