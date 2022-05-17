package Day8;

public class max_points_from_cards {
    /**
     * There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.

        In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.

        Your score is the sum of the points of the cards you have taken.

        Given the integer array cardPoints and the integer k, return the maximum score you can obtain.

        

        Example 1:

        Input: cardPoints = [1,2,3,4,5,6,1], k = 3
        Output: 12
        Explanation: After the first step, your score will always be 1. However, choosing the rightmost card first will maximize your total score. The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.

        Example 2:

        Input: cardPoints = [2,2,2], k = 2
        Output: 4
        Explanation: Regardless of which two cards you take, your score will always be 4.

        Example 3:

        Input: cardPoints = [9,7,7,9,7,7,9], k = 7
        Output: 55
        Explanation: You have to take all the cards. Your score is the sum of points of all cards.

        

        Constraints:

            1 <= cardPoints.length <= 105
            1 <= cardPoints[i] <= 104
            1 <= k <= cardPoints.length


     */

     /**
      * Method 1
      * Using an array for storing the total points obtained from getting K cards
      */

    public static int method1(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] dp = new int[k+1]; // Since dp store the total number of points obtained from getting K cards, its size is k+1

        for(int i=n-1;i>=n-k;i--) {
            dp[0] += cardPoints[i];     // Taking the sum of the first K elements from the right
        }

        int max = dp[0];

        for(int i=1;i<k+1;i++) {
            dp[i] = dp[i-1] + cardPoints[i-1] - cardPoints[n + i - k - 1];
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] cardPoints = {9,7,7,9,7,7,9};
        int k = 7;

        System.out.println(method1(cardPoints, k));
    }
}
