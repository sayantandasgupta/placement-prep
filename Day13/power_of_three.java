package Day13;

public class power_of_three {

    /**
     * Given an integer n, return true if it is a power of three. Otherwise, return false.

        An integer n is a power of three, if there exists an integer x such that n == 3x.

        

        Example 1:

        Input: n = 27
        Output: true

        Example 2:

        Input: n = 0
        Output: false

        Example 3:

        Input: n = 9
        Output: true

        

        Constraints:

            -2^31 <= n <= 2^31 - 1

     */

     /**
      * Method 1 : Iterative
      * If n < 1, then return false;
      * Otherwise, while(n%3==0) do n = n/3
      * Finally return if n == 1
      */

      public static boolean iterative_solution(int n) {
          if(n<1) return false;

          while(n%3 == 0) n /= 3;

          return n == 1;
      }

      /**
       * Change the base of the number to the required base and check if the changes number starts with 1 and the rest of the numbers are 0
       */

       public static boolean basechange_solution(int n) {
           String baseChange = Integer.toString(n,3);

           return baseChange.matches("^10*$");
       }

    public static void main(String[] args) {
        int n = 729;

        System.out.println(basechange_solution(n));
    }
}
