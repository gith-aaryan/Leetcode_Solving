/** Two Pointers Approach
LeetCode wants 1-based indices.

sum < target   it means the array is sorted, increase left++
sum > target   it means the arrray is sorted , decrease right--

 */

class Solution {
    public int[] twoSum(int[] numbers, int target) {

       // Two pointers 
        int left = 0;
        int right = numbers.length - 1;
 
       // Continue until pointers meet
        while( left < right ){

            int sum = numbers[left] + numbers[right];


            if(sum == target){
                return new int[]{left+1 , right+1};

            }
            else if( sum < target ){
                left++;

            }else{
                right--;

            }

        }

        // According to the problem, a solution always exists
        return new int[]{-1 ,-1};

    }
}