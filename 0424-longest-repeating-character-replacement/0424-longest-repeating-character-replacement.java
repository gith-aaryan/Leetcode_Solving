class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];  // arrays for a-z charcter 
        int left = 0;      
        int maxWindow = 0;
        int maxFreq  = 0;

        for(int right = 0; right < s.length(); right++){
            
            char currentChar = s.charAt(right);
            freq[currentChar - 'A']++;   // Update the frquency of current charcter  

        maxFreq = Math.max(maxFreq , freq[currentChar - 'A']);       // Update the max frequency 
            
        int windowLength = right - left + 1;

        if(windowLength - maxFreq > k ){
            freq[s.charAt(left) - 'A']-- ;
            left++;

        }

        windowLength = right - left + 1; 

        maxWindow = Math.max(maxWindow , windowLength);

        }

        return maxWindow;

    }
}