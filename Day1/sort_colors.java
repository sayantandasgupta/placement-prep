package Day1;

public class sort_colors {
    /**
     * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

        We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

        You must solve this problem without using the library's sort function.

        

        Example 1:

        Input: nums = [2,0,2,1,1,0]
        Output: [0,0,1,1,2,2]

        Example 2:

        Input: nums = [2,0,1]
        Output: [0,1,2]
     */

     /**
      * Method 1: Using 3 pointers
      * Take 3 pointers i =0, j = 0, k = n-1, where n = length of the array.
      * traverse until j <= k && i<k
      * if(arr[j] == 0) swap(arr[j], arr[i]); j++; i++;
      * if(arr[j] == 2) swap(arr[j], arr[k]); k--;
      * if(arr[j] == 1) j++;

      * Params: int[] arr
      * Output: void
      */

      public static void method1(int[] nums) {
          int n = nums.length;

          int i = 0, j = 0, k = n-1;

          while(j <= k && i<k) {
              if(nums[j] == 0) {
                  int temp = nums[i];
                  nums[i] = nums[j];
                  nums[j] = temp;

                  j++;i++;
              } else if(nums[j] == 2) {
                int temp = nums[k];
                nums[k] = nums[j];
                nums[j] = temp;

                k--;
              } else {
                  j++;
              }
          }
      }

     public static void main(String[] args) {
        int[] nums = {1,2,0};

        method1(nums);

        for(int i : nums) {
            System.out.print(i + " ");
        }

        return;
     }
}
