class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int minLenWin = Integer.MAX_VALUE;
        int currentSum = 0;

       // Start 2 pointer Sliding Window
        int low = 0;
        int high = 0;

        while(high < nums.length){

           // find the current sum & increase window size
            currentSum += nums[high];
            high++;

            // try to reduce the window size
            while(currentSum >= target){

                int currentWindowSize = high - low;
                
                // Update minimum length window
                minLenWin = Math.min(minLenWin , currentWindowSize);

                currentSum -= nums[low];
                low++;

            }

        }
        return minLenWin == Integer.MAX_VALUE ? 0 : minLenWin;
    }
}