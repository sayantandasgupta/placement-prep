package Recursion.Easy;

public class find_power {
    /*
     * Write a recursive function for given n and a to determine x:
        n = a ^ x 
        a = 2, 3, 4
        (2 ^ -31) <= n <= (2 ^ 31) - 1   
     */

     static int helper(int n, int a) {
        if(n == 1) return 0;

        return 1 + helper(n/a, a);
     }

     public static void main(String[] args) {
        System.out.print(helper(729, 9) + "\n");
     }
}
