/* sliding window of size k , sum the first k elements, then add the incoming element and subtract the outgoing one.

*/

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        int sum = 0;

        for(int i = 0; i < k; i++){
            sum += nums[i];

        }

            int maxSum = sum;
            int startIndex = 0;
            int endIndex = k;

            while(endIndex < nums.length){

                sum -= nums[startIndex];
                startIndex++;

                sum += nums[endIndex];
                endIndex++;

                maxSum = Math.max( maxSum , sum);
            }
           
        

        return (double) maxSum/k;
        
    }
}