/** Dutch National Flag Algorithm. */

class Solution {
    public void sortColors(int[] nums) {

        int start = 0;
        int middle = 0;
        int end = nums.length - 1;

        while(middle <= end){

            switch(nums[middle]){

                // swap with start index
                case 0:
                swap(nums , start , middle);
                middle++;
                start++;
                break;

                case 1:
                middle++;
                break;

                // swap with end index
                case 2:
                swap(nums, middle , end);
                end--;
                break;


            }

        }
  
    }

      private void swap(int[] nums , int i , int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j]= temp;

        }
        
}