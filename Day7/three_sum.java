package Day7;

import java.util.*;

public class three_sum {
    /**
     * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

        Notice that the solution set must not contain duplicate triplets.

        

        Example 1:

        Input: nums = [-1,0,1,2,-1,-4]
        Output: [[-1,-1,2],[-1,0,1]]

        Example 2:

        Input: nums = []
        Output: []

        Example 3:

        Input: nums = [0]
        Output: []

        

        Constraints:

            0 <= nums.length <= 3000
            -105 <= nums[i] <= 105
     */

     /**
      * Solution
      * Use the first loop to go from index 0 to index n - 3 where n is length of array
      * then do binary search on the rest of the array barring the current element
      */

    public static List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>(); 
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
               }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = {-1,0,1,2,-1,-4};

        List<List<Integer>> res = threeSum(num);

        for(List<Integer> list : res) {
            for(int a : list) {
                System.out.print(a + " ");
            }
            System.out.print("\n");
        }
    }
}
