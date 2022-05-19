package Day10;

public class merge_sorted_array {

    /**
     * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

        Merge nums1 and nums2 into a single array sorted in non-decreasing order.

        The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

        

        Example 1:

        Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        Output: [1,2,2,3,5,6]
        Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
        The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

        Example 2:

        Input: nums1 = [1], m = 1, nums2 = [], n = 0
        Output: [1]
        Explanation: The arrays we are merging are [1] and [].
        The result of the merge is [1].

        Example 3:

        Input: nums1 = [0], m = 0, nums2 = [1], n = 1
        Output: [1]
        Explanation: The arrays we are merging are [] and [1].
        The result of the merge is [1].
        Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.

        

        Constraints:

            nums1.length == m + n
            nums2.length == n
            0 <= m, n <= 200
            1 <= m + n <= 200
            -109 <= nums1[i], nums2[j] <= 109

     */
    
    /**
     * Solution 
     * Considering 2 pointers starting from the ends of the 2 sorted arrays. If nums1[i] > nums2[j], nums1[i] will be inserted to the result else nums2[j]
     * This is becuase we are comparing from the end and adding to the end of the resultant, the result should be in decreasing order from the end of the sorted array
     * 
     * */
    
     public static void solution(int[] nums1, int m, int[] nums2, int n) {
         int i=m-1,j=n-1, k = n+m-1;    // Declaring the 3 pointers, i for nums1, j for nums2, and k for the result

         while(i>= 0 && j>=0) {
             nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
         }

         // Since we are inserting into nums1 only, therefore we only need to check for any extra elements left in nums2

         while(j>=0) {
             nums1[k--] = nums2[j--];
         }

         return;
         
     }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0}, nums2 = {2,5,6};
        int m = 3, n = 3;

        solution(nums1, m, nums2, n);

        for(int i : nums1) {
            System.out.print(i + " ");
        }
    }
}
