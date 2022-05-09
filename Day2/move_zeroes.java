package Day2;

public class move_zeroes {

    /**
     * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

        Note that you must do this in-place without making a copy of the array.

        

        Example 1:

        Input: nums = [0,1,0,3,12]
        Output: [1,3,12,0,0]

        Example 2:

        Input: nums = [0]
        Output: [0]

        

        Constraints:

            1 <= nums.length <= 104
            -231 <= nums[i] <= 231 - 1

     */

     /**
      * Solution
      * The optimal approach is again a subtle extension of above solution. A simple realization is if the current element is non-0, its' correct position can at best be it's current position or a position earlier. If it's the latter one, the current position will be eventually occupied by a non-0 ,or a 0, which lies at a index greater than 'cur' index. We fill the current position by 0 right away,so that unlike the previous solution, we don't need to come back here in next iteration.

        In other words, the code will maintain the following invariant:

                All elements before the slow pointer (lastNonZeroFoundAt) are non-zeroes.

                All elements between the current and slow pointer are zeroes.

        Therefore, when we encounter a non-zero element, we need to swap elements pointed by current and slow pointer, then advance both pointers. If it's zero element, we just advance current pointer.

        With this invariant in-place, it's easy to see that the algorithm will work.
      */

    public static void solution(int[] nums) {
        int n = nums.length;

        for(int nonZeroIdx = 0, current = 0; current < n; current++) {
            if(nums[current] != 0) {
                int temp = nums[current];
                nums[current] = nums[nonZeroIdx];
                nums[nonZeroIdx++] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};

        System.out.println("Initial Array");

        for(int i : nums) {
            System.out.print(i + " ");
        }

        solution(nums);

        System.out.println("\nFinal Array");

        for(int i : nums) {
            System.out.print(i + " ");
        }
    }
}
