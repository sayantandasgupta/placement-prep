package Day11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class majority_element {

    /**
     * Given an array nums of size n, return the majority element.

        The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

        

        Example 1:

        Input: nums = [3,2,3]
        Output: 3

        Example 2:

        Input: nums = [2,2,1,1,1,2,2]
        Output: 2

        

        Constraints:

            n == nums.length
            1 <= n <= 5 * 10^4
            -10^9 <= nums[i] <= 10^9

     */

    /**
     * Solution 1: Using a HashMap to store the frequencies of the elements.
     */

     public static int solution1(int[] nums) {
         Map<Integer, Integer> count = new HashMap<>();
         
         for(int i : nums) {
             count.put(i, count.getOrDefault(i, 0) + 1);
         }

         for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
             if(entry.getValue() > nums.length / 2) return entry.getKey();
         }

         return -1;
     }

     /**
      * Solution 2: Sort the array and return nums[nums.length/2]. Since majority element must be greater than nums.length/2, therefore it must be present at index nums.length/2
      */

      public static int solution2(int[] nums) {
          Arrays.sort(nums);
          return nums[nums.length/2];
      }

    public static void main(String[] args) {
        
    }
}
