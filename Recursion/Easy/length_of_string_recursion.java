package Recursion.Easy;

public class length_of_string_recursion {
    /**
     * Given a string calculate length of the string using recursion. 
        Examples: 
        

        Input : str = "abcd"
        Output :4

        Input : str = "GEEKSFORGEEKS"
        Output :13
     */

    static int helper(String s) {
        if(s.equals("")) return 0;

        else return helper(s.substring(1)) + 1;
    }

    public static void main(String[] args) {
        String s = "Hello";

        System.out.print(helper(s));
    }
}
