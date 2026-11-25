class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if( k <= 1){
            return 0;

        }

        int start = 0;
        int end = 0;
        int count = 0;
        int n = nums.length;
        int product = 1;

        while(end < n){
            product = product * nums[end];  // expansion

           // shrinking
            while(product >= k ){
                product = product / nums[start];
                start++;

            }

            count = count + (end-start+1);
            end++;
        }

        return count;
        
    }
}