/*
Kadane’s Algorithm

Always remember the cheapest price we have seen so far, and calculate today's profit using that cheapest price.

Track the minimum value so far and calculate the maximum difference.

Time:  O(n)
Space: O(1)

*/

class Solution {
    public int maxProfit(int[] prices) {

        int buyPrice = prices[0];
        int profit = 0;

        for(int i=0; i < prices.length ; i++){


            if(buyPrice > prices[i]){
              buyPrice = prices[i];

            }else{

                int currentProfit = prices[i] - buyPrice ;
                profit = Math.max(currentProfit, profit);

            }

        } 

        return profit;
        
    }
}