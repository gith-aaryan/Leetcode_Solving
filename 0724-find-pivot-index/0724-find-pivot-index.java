class Solution {
    public int pivotIndex(int[] nums) {

       // Calculate the sum of array
        int rightSum = 0;

        for(int num: nums){
            rightSum += num;       // sum of array is store

        }

        int leftSum = 0; 

        // iterate through array
        for(int i = 0; i < nums.length; i++){

            rightSum -= nums[i];      // update right sum
            
            if(rightSum == leftSum){
                return i;

            }

            leftSum += nums[i];       // update left sum

        }

        return -1;  // if no pivot index is found

    }

        
}
