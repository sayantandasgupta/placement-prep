package Day4;

public class subarray_sums_divisible_by_k {

    /**
     * Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.

        A subarray is a contiguous part of an array.

        

        Example 1:

        Input: nums = [4,5,0,-2,-3,1], k = 5
        Output: 7
        Explanation: There are 7 subarrays with a sum divisible by k = 5:
        [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]

        Example 2:

        Input: nums = [5], k = 9
        Output: 0

        

        Constraints:

            1 <= nums.length <= 3 * 104
            -104 <= nums[i] <= 104
            2 <= k <= 104


     */


    /**
     * Method 1
     * Using 2 nested loops, one for accessing each current element, and the other for traversing the subarray after the current element
     * for(int i=0;i<n-1;i++)
     *      val = nums[i];
     *      if(nums[i]%k == 0) count++;
     *      else 
     *          for(int j=i+1;j<n;j++)
     *              val += nums[j];
     *              if(nums[j]%k == 0) count++;
     * return count;
     */
    public static int method1(int[] nums, int k) {
        int count = 0, n = nums.length;

        for(int i=0;i<n-1;i++) {
            int val = nums[i];

            if(val%k == 0) count++;
            for(int j=i+1;j<n;j++) {
                val += nums[j];
                if(val%k == 0) count++;
            }
        }

        return count;
    }

    /**
     * Using HashTable
     * In this method, we shall create an array of length K, for storing the frequencies of the remainders found so far.
     * for each element, we shall find add the element to the sum variable, and then find sum+a 's remainder when divided by k
     * If the remainder is less than 0, we shall add K to the remainder to make it positive
     * finally add the count from the value present at the sum index of the array.
     * increase the value at sum index by 1
     */

    public static int method2(int[] nums, int k){
        int[] map = new int[k];
        int count=0, sum = 0;

        map[0] = 1;

        for(int num : nums) {
            sum = (sum + num)%k;
            if(sum < 0) sum += k;
            count += map[sum];
            map[sum]++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {5};
        int k = 9;

        System.out.print(method2(nums, k));
    }
}
