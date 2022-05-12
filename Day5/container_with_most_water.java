package Day5;

public class container_with_most_water {

    /**
     * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

        Find two lines that together with the x-axis form a container, such that the container contains the most water.

        Return the maximum amount of water a container can store.

        Notice that you may not slant the container.

        Example:-

        Input: height = [1,8,6,2,5,4,8,3,7]

        Output: 49
        Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. 
        In this case, the max area of water (blue section) the container can contain is 49.
     */

     /**
      * Method 1
      * Using 2 nested for loops and finding the maximum volume container
      */

    public static int method1(int[] heights) {
        int n = heights.length, maxAmt = 0;

        for(int i=0;i<n-1;i++) {
            for(int j=i+1;j<n;j++) {
                int length = heights[i] <= heights[j] ? heights[i] : heights[j];
                int amt = length*(j - i);
                maxAmt = Math.max(maxAmt, amt);
            }
        }

        return maxAmt;
    }

    /**
     * Method 2
     * Since the amount of water to be contained is the product of the length of the shorter of the 2 pillars and the width between them
     * We start from the widest container, and then gradually decrease the width if required, because a shorter width needs a longer height.
     * Therefore as we find a pillar with a longer height, we can decrease the width
     */

     public static int method2(int[] heights) {
         int n = heights.length;
         int i=0, j = n-1;
         int maxAmt = 0;

         while(i<j) {
             maxAmt = Math.max(maxAmt, (j-i)*Math.min(heights[i], heights[j]));

             if(heights[i] < heights[j]) i++;
             else j--;
         }

         return maxAmt;

     }

    public static void main(String[] args) {
        int[] heights = {1,8,6,2,5,4,8,3,7};

        System.out.println(method2(heights));
    }
}
