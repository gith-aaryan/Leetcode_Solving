/** Boyer–Moore Voting Algorithm.  -- If an element appears more than n/2 times, it can never be completely cancelled out by all the other elements.

Complexity
- Time: O(n) — one pass through the array
- Space: O(1) — only candidate and count are used

 */


class Solution {
    public int majorityElement(int[] nums) {        // taking Array to store elements

      int candidate = 0;
      int count = 0;

      for(int num : nums){

        if(count == 0){
            candidate = num;

        }

        if(candidate == num){
            count++;

        }else{
            count--;

        }

      }   
      return candidate;  

    
    }
}