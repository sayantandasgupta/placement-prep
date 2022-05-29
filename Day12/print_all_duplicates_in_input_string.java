package Day12;

import java.util.HashMap;
import java.util.Map;

public class print_all_duplicates_in_input_string {

    /**
     * Write an efficient program to print all the duplicates and their counts in the input string 
     */

    /**
     * Method 1: Using Hashing
     */

    public static void method1(String s) {
        int n = s.length();
        int[] count = new int[256];
        
        for(int i=0;i<n;i++) {
            count[s.charAt(i)]++;
        }

        for(int i=0;i<count.length;i++) {
            if(count[i] > 1) System.out.println((char)(i) + ", count = " + count[i]);
        }
    }

    /**
     * Method 2: Using a Map
     */

     public static void method2(String s) {
         int n = s.length();

         Map<Character, Integer> map = new HashMap<>();

         for(int i=0;i<n;i++) {
             char c = s.charAt(i);

             map.put(c, map.getOrDefault(c, 0) + 1);
         }

         for(Map.Entry<Character, Integer> entry : map.entrySet()) {
             if(entry.getValue() > 1) System.out.println(entry.getKey() + ", count = " + entry.getValue());
         }
         
     }

    public static void main(String[] args) {
        String s = "abbcccddddeeeee";

        method2(s);
    }    
}
