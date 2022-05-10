package Day3;

import java.util.*;

public class two_sum {
    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

        You may assume that each input would have exactly one solution, and you may not use the same element twice.

        You can return the answer in any order.

        

        Example 1:

        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

        Example 2:

        Input: nums = [3,2,4], target = 6
        Output: [1,2]

        Example 3:

        Input: nums = [3,3], target = 6
        Output: [0,1]

        

        Constraints:

            2 <= nums.length <= 104
            -109 <= nums[i] <= 109
            -109 <= target <= 109
            Only one valid answer exists.

     */

     /**
      * 
      * Method 1
      * Using 2 nested loops, find the indices of the 2 numbers which make up the given sum.
      */

    /**
     * 
     * Optimal Solution
     * Using a hashmap to store the each value and their indices.
     * Finally checking if the complement of a value exists as a key, if yes, then we return the indices as an array
     */

    public static int[] solution(int[] nums, int target) {
        int[] ans = new int[2];
        
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++) {
            map.putIfAbsent(nums[i], i);
        }

        for(int i =0;i<nums.length;i++) {
            int val = target - nums[i];
            if(map.containsKey(val) && map.get(val) != i) {
                ans[0] = i;
                ans[1] = map.get(val);
                break;
            }
        }

        return ans;
    }

     public static void main(String[] args) {
         int[] nums = {2,7,11,15};
         int target = 9;

         int[] res = solution(nums,target);

         for(int i : res) {
             System.out.println(i);
         }
     }
}
