package Day1;

import java.util.*;

public class find_duplicate_number {

    /**
     * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

     * There is only one repeated number in nums, return this repeated number.

     * You must solve the problem without modifying the array nums and uses only constant extra space.

 

        Example 1:

        Input: nums = [1,3,4,2,2]
        Output: 2

        Example 2:

        Input: nums = [3,1,3,4,2]
        Output: 3

        

        Constraints:

            1 <= n <= 105
            nums.length == n + 1
            1 <= nums[i] <= n
            All the integers in nums appear only once except for precisely one integer which appears two or more times.

     */

    /**
     * Method 1: Use a HashMap to count the frequencies of each element. 
     * Return the key of the map which has more than 1 frequency
     * 
     * Params: int[] nums
     *
     */

    public static int method1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1) return entry.getKey();
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,3,4,2};

        System.out.println(method1(nums));
    }
}