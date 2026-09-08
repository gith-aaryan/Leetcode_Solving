/**
  Time: O(n) , Space: O(1)

  Reverse All → Reverse First k → Reverse Remaining

 */

class Solution {
    public void rotate(int[] nums, int k) {

        int n = nums.length;

        // In case k is greater than n ,
        k = k % n;

        reverse(nums , 0 , n-1);
        reverse(nums , 0 , k-1);
        reverse(nums , k , n-1);


    }

    public void reverse(int[] nums , int start , int end){

        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }

    }
}