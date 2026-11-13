class Solution {
    public int longestOnes(int[] nums, int k) {

        int zeroCount = 0;  // for counting zero 
        int maxOne = 0;    // counting Maximum One 
        int start = 0;

        for(int end = 0; end < nums.length; end++){

            if( nums[end] == 0){
                zeroCount++;
            }

            // Shrink the window from the left if zeros exceed k
            while(zeroCount > k){
                if( nums[start] == 0){
                zeroCount--;
            }

            start++;

            }
            
            maxOne = Math.max(maxOne , end - start + 1);


        }
        return maxOne;

    }
}