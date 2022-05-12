package Day4;

public class best_time_to_buy_sell_stock_2 {
    /**
     * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

        On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

        Find and return the maximum profit you can achieve.

        

        Example 1:

        Input: prices = [7,1,5,3,6,4]
        Output: 7
        Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
        Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
        Total profit is 4 + 3 = 7.

        Example 2:

        Input: prices = [1,2,3,4,5]
        Output: 4
        Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
        Total profit is 4.

        Example 3:

        Input: prices = [7,6,4,3,1]
        Output: 0
        Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.

        

        Constraints:

            1 <= prices.length <= 3 * 104
            0 <= prices[i] <= 104


     */

    /**
     * Solution
     * For each current element in the array, which represents the price for that day
     * We find the local minimum and maximum after that element
     * Finally we add to the profit variable the difference between the minimum and maximum if we do not reach the end of the array
     */

    public static int solution(int[] prices) {
        int profit = 0, i = 0, n = prices.length;

        while(i < n) {
            // Finding the local minima
            while( i<n-1 && prices[i+1] <= prices[i]) i++;

            int min = prices[i++];

            //Finding the local maxima
            while(i<n-1 && prices[i+1] >= prices[i]) i++;

            profit += i < n ? prices[i] - min : 0;
        }

        return profit;
    }
    
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};

        System.out.print("Max Profit = " + solution(prices));
    }
}
