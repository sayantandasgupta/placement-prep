package Recursion.Easy;

public class power_of_four {
    /*
     * Given an integer n, return true if it is a power of four. Otherwise, return false.

        An integer n is a power of four, if there exists an integer x such that n == 4x.

        

        Example 1:

        Input: n = 16
        Output: true
        Example 2:

        Input: n = 5
        Output: false
        Example 3:

        Input: n = 1
        Output: true
        

        Constraints:

        -2^31 <= n <= 2^31 - 1
     */

     static boolean helper(int n) {
        if(n == 0) return false;
        if(n == 1) return true;

        return (n%4 == 0) && helper(n/4);
     }
}
