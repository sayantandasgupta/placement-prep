package Day10;

import java.util.Arrays;

public class jump_game {

    /**
     * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

        Return true if you can reach the last index, or false otherwise.

        

        Example 1:

        Input: nums = [2,3,1,1,4]
        Output: true
        Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

        Example 2:

        Input: nums = [3,2,1,0,4]
        Output: false
        Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

        

        Constraints:

            1 <= nums.length <= 10^4
            0 <= nums[i] <= 10^5


     */

     /**
      * Method 1: Recursion
      * We can see that for each nums[i], we have the choices of going either steps from [1, nums[i]] both included
      * And we are checking whether the next step can be completed or not.
      * 
      */

    public static boolean method1(int[] nums) {
        return recursion_helper(nums, 0);
    }

    public static boolean recursion_helper(int[] nums, int idx) {
        if(idx == nums.length) return true;

        boolean res = false;

        for(int i=1;i<=nums[idx];i++) {
            res = res || recursion_helper(nums, idx + i);
        }

        return res;
    }

    /**
     * Method 2 : Memoization
     */
    public static boolean method2(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        Arrays.fill(dp, false);
        return recursion_helper(nums, 0);
    }

    public static boolean dp_helper(int[] nums, boolean[] dp, int idx) {
        if(idx == nums.length) return true;
        if(dp[idx] == true) return true;

        boolean res = false;

        for(int i=1;i<=nums[idx];i++) {
            res = res || dp_helper(nums, dp, idx + i);
        }

        return dp[idx] = res;
    }

    /**
     * Optimum solution
     */

     public static boolean optimum_solution(int[] nums) {
        int last = nums.length - 1;
        
        for(int i = nums.length-2;i>=0;i--) {
            if(i+nums[i] >= last) last = i;
        }
        
        return last<=0;
     }




    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};

        System.out.print(optimum_solution(nums));
    }
}
