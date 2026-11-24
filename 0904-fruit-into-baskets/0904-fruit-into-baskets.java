
/* Find the longest continuous subarray that contains at most 2 distinct numbers, and return its length.

[ Sliding Window + Basket Map ] , TC: O(n)|| SC: 0(1)


*/
class Solution {

    public int totalFruit(int[] fruits) {

        Map<Integer, Integer> basket = new HashMap<>();  // Map requires two generic type parameters (key and value)

        int left = 0; 
        int right = 0;
        int maxFruits = 0;     // largest valid window

        for(right = 0 ; right < fruits.length; right++ ){      // fruits is a primitive int[] array, not a String or List. Arrays use the .length field (no parentheses), not .length():

            int currentCount = basket.getOrDefault(fruits[right] , 0);
            basket.put( fruits[right], currentCount + 1);

            while(basket.size() > 2){
                int fruitCount = basket.get(fruits[left]);

                if(fruitCount == 1){
                    basket.remove(fruits[left]);

                }else{
                    basket.put(fruits[left] , fruitCount - 1 );

                }
                
                left++;

            }

          maxFruits = Math.max(maxFruits , right-left+1);

        }

        return maxFruits;

    }
}