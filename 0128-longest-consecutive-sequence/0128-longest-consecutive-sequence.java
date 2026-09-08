class Solution {
    public int longestConsecutive(int[] nums) {

        // Using HashSet
        HashSet<Integer> set = new HashSet<>();

        // Storing all numbers into HashSet
        for(int num: nums){
            set.add(num);

        }

        int longest = 0;

        // check every number
        for(int num : set){

            if(!set.contains(num-1)){

                int currentNum = num;
                int currentLength = 1;

                while(set.contains(currentNum+1)){

                    currentNum++;
                    currentLength++;
                }

                longest = Math.max(longest ,currentLength );

            }

        }
        
        return longest;

    
    }
}