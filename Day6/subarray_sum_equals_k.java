package Day6;
import java.util.*;

public class subarray_sum_equals_k {

    /**
     * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

 

        Example 1:

        Input: nums = [1,1,1], k = 2
        Output: 2

        Example 2:

        Input: nums = [1,2,3], k = 3
        Output: 2

        

        Constraints:

            1 <= nums.length <= 2 * 104
            -1000 <= nums[i] <= 1000
            -107 <= k <= 107
     */

    /**
     * Method 2: Using a HashMap to store the sum values
     */

    public static int method2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();    // Map to store the sums and their corresponding frequency
        map.put(0, 1);  //zero sum of 1 frequency

        int sum = 0, count = 0;

        for(int i=0;i<nums.length;i++) {
            sum += nums[i]; // Calculating prefix sum

            if(map.containsKey(sum - k)) {
                count += map.get(sum - k);      // Finding if the sum exists in the map, and adding the frequency to the count
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1); // Storing corresponding sums and their frequencies
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;

        System.out.println(method2(nums, k));
    }
}
