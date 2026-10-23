/* sliding window of size k , sum the first k elements, then add the incoming element and subtract the outgoing one.

TC : 0(n)     ,    SC : O(1)

*/

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        int sum = 0;  // initialize as 0 sum

        // iterate over k first value
        for(int i = 0; i < k; i++){
            sum += nums[i];   // adds i of 'k' in sum

        }

            int maxSum = sum;   // first maxSum is equal first sum
            int startIndex = 0;   // 
            int endIndex = k;

            while(endIndex < nums.length){   // endIndex is always less than nums.length and k is always less int nums[]

                sum -= nums[startIndex];  // substract startIndex from sum then update startIndex 
                startIndex++;         

                sum += nums[endIndex]; // add endIndex from sum then update endIndex++ 
                endIndex++;

                maxSum = Math.max( maxSum , sum);  //take maxSum
            }
           
        return (double) maxSum/k;   // explicit type casting to obtain average
        
    }
}