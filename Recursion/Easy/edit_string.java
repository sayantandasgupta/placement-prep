package Recursion.Easy;

public class edit_string {
    /*
     * Given a string, return another string with all the a's removed from the original string
     * Input: baccad
     * Output: bccd
     */

     /*
      * Approach 1: Recursive
      */

      static String recursion(StringBuilder sb, String inpuString, int index) {
        if(index == inpuString.length()) return sb.toString();
        if(inpuString.charAt(index) != 'a') sb.append(inpuString.charAt(index));

        return recursion(sb, inpuString, index + 1);
      }

      public static void main(String[] args) {
        
      }
}
