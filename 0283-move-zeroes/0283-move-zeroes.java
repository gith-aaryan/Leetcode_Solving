/** TC - O(n) , SC - O(1)

Logic:  Pehle sare non-zero elements ko array ke front mein order maintain karte hue shift karna, aur uske baad baki bachi hui positions ko 0 se fill kar dena..

 */

class Solution {
    public void moveZeroes(int[] nums) {

        int insertPosition = 0;

        for(int i = 0; i < nums.length; i++ ){

            if(nums[i] != 0){
                nums[insertPosition] = nums[i];
                insertPosition++;

            }

        } 

        while(insertPosition < nums.length){
                nums[insertPosition++] = 0;
    
        }

    }

}