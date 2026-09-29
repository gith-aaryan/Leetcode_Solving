class Solution {
    public int subarraySum(int[] nums, int k) {         // k defines 'targetsum'

        int n = nums.length;
        int[] prefixSum = new int[n];     // creates an array to hold cumulative sums.



        prefixSum[0] = nums[0];  // Assigning Number to prefixSum array
        for(int i = 1; i < n; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];   // calculates the sum from index 0 through i.

        }

        Map<Integer , Integer > frequency = new HashMap<>(); // creates a map where each key is a prefix sum and each value is how many times it has appeared so far.
        int count = 0;

        for(int j = 0; j < n; j++){
            if(prefixSum[j] == k){           // counts a subarray starting at index 0 when its sum is k.
                count++;

            }

            int needed = prefixSum[j] - k;    // calculates the earlier prefix sum needed to make the current subarray sum to k.
            count += frequency.getOrDefault(needed, 0);

            frequency.put(
                prefixSum[j] , 
                frequency.getOrDefault(prefixSum[j] , 0) + 1);    // records the current prefix sum after checking it, so it can be used for later subarrays.

        }

        return count;         // returns the total number of matching subarrays.

        
    }
}



//TC - O(n) time and SC - O(n) extra space.