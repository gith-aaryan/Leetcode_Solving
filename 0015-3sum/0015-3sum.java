/** Two-Pointer Approach 

"I first sort the array. Then I fix one element using i and apply the two-pointer technique on the remaining portion. If the sum is less than zero, I move left forward; if it is greater than zero, I move right backward. I also skip duplicates to avoid duplicate triplets. The overall time complexity is O(n²)."


Sorting:              O(n log n)
Two-pointer search:   O(n²)

Overall:              O(n²)
 */


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

       // Sorting Array into ascending order
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
    
           // Skip duplicate first element
            if(i > 0 && nums[i] == nums[i-1]){
                continue;

            }
           
           // If the smallest number is greater than 0,
            if(nums[i] > 0){
                break;

            }

            int left = i + 1;
            int right = nums.length -1 ;

            while(left < right){

                int sum = nums[i] + nums[left] + nums[right];

                if(sum==0){

                    result.add(Arrays.asList(
                        nums[i],
                        nums[left],
                        nums[right]
                    ));

                    left++;
                    right--;

                    while(left < right && nums[left] == nums[left-1]){
                        left++;
                    }

                    while(left < right && nums[right] == nums[right+1]){
                        right--;

                    }           

                }else if(sum < 0){
                    left++;

                }else{
                    right--;
                }
            }

        
        }

        return result;
  
    }
}