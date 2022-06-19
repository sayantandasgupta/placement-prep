package Recursion.Easy;

public class power_of_x {
    /*
     * Given an integer n, return true if it is a power of x (given) . Otherwise, return false.

        An integer n is a power of two, if there exists an integer x such that n == x^y.

        Example 1:

        Input: n = 1, x = 5
        Output: true
        Explanation: 5^0 = 1
        Example 2:

        Input: n = 16, x = 3
        Output: false
        
        Example 3:

        Input: n = 9, x = 3
        Output: true
     */

     static boolean helper(int n, int x) {
        if(n==0) return false;
        if(n==1) return true;

        return (n%x == 0) && helper(n/x, x);
     }

     public static void main(String[] args) {
        int n = 27, x = 3;

        System.out.print(helper(n,x));
     }
}
