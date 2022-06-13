package Day14;

import java.util.HashSet;
import java.util.Set;

public class maximum_erasure_value {
    /**
     * You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.

        Return the maximum score you can get by erasing exactly one subarray.

        An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).

        

        Example 1:

        Input: nums = [4,2,4,5,6]
        Output: 17
        Explanation: The optimal subarray here is [2,4,5,6].
        Example 2:

        Input: nums = [5,2,1,2,5,2,1,2,5]
        Output: 8
        Explanation: The optimal subarray here is [5,2,1] or [1,2,5].
        

        Constraints:

        1 <= nums.length <= 10^5
        1 <= nums[i] <= 10^4
     */

     /**
      * This is also a sliding window problem
      * though we shall use 2 pointers and HashSet to keep track of the visited elements in the array and then remove their values from the sum
      */

    public static int solution(int[] nums) {
        int max = 0, current = 0;

        Set<Integer> seen = new HashSet<>();

        for(int i=0,j=0;j<nums.length;j++) {
            while(!seen.add(nums[j])) {
                current -= nums[i];
                seen.remove(nums[i++]);
            }
            current += nums[j];
            max = Math.max(max, current);
        }

        return max;
    }

     public static void main(String[] args) {
        int[] nums = {5,2,1,2,5,2,1,2,5};

        System.out.print(solution(nums));
     }
}
