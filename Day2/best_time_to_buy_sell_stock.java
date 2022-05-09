package Day2;

public class best_time_to_buy_sell_stock {
    /** 
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.

        You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

        Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

        

        Example 1:

        Input: prices = [7,1,5,3,6,4]
        Output: 5
        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
        Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

        Example 2:

        Input: prices = [7,6,4,3,1]
        Output: 0
        Explanation: In this case, no transactions are done and the max profit = 0.

        

        Constraints:

            1 <= prices.length <= 105
            0 <= prices[i] <= 104


    */

    /**
     * Solution
        int lsf = Integer.MAX_VALUE; // least so far
        int op = 0; // overall profit
        int pist = 0; // profit if sold today
        
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < lsf){ // if we found new buy value which is more smaller then previous one
                lsf = prices[i]; // update our least so far
            }
            pist = prices[i] - lsf; // calculating profit if sold today by, Buy - sell
            if(op < pist){ // if pist is more then our previous overall profit
                op = pist; // update overall profit
            }
        }
        return op; // return op 
     * 
     * 
     */

     public static int solution(int[] prices) {
         int lsf = Integer.MAX_VALUE;

         int op = 0, pist = 0;

         for(int i=0;i<prices.length;i++) {
             if(prices[i] < lsf) lsf = prices[i];

             pist = prices[i] - lsf;

             op = Math.max(op, pist);
         }

         return op;
     }

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};

        System.out.print(solution(prices));
    }
}
