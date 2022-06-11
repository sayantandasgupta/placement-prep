package Recursion.Easy;

public class recursive_binary_search {

    /**
     * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

        You must write an algorithm with O(log n) runtime complexity.

        

        Example 1:

        Input: nums = [-1,0,3,5,9,12], target = 9
        Output: 4
        Explanation: 9 exists in nums and its index is 4

        Example 2:

        Input: nums = [-1,0,3,5,9,12], target = 2
        Output: -1
        Explanation: 2 does not exist in nums so return -1

        

        Constraints:

            1 <= nums.length <= 104
            -104 < nums[i], target < 104
            All the integers in nums are unique.
            nums is sorted in ascending order.
     */

     static int helper(int[] nums, int target, int lo, int hi) {
         if(lo > hi) return -1;

         int mid = lo + (hi - lo)/2;

         if(nums[mid] == target) return mid;

         else if(nums[mid] > target) return helper(nums, target, lo, mid - 1);

         return helper(nums, target, mid + 1, hi);
     }

     static int search(int[] nums, int target) {
         return helper(nums, target, 0, nums.length - 1);
     }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;

        System.out.print(search(nums, target));
    }
}
