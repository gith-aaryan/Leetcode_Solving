/** Variable Size Sliding Window + frequency array.frequency

" Sliding Window = Expand + Validate + Shrink + Update Answer "

Our strategy:
1. Expand the window by moving right.
2. Check whether the current window contains all characters of t.
3. Once valid, try shrinking it by moving left.
4. Store the smallest valid window.
5. Repeat until the string ends.

TC: O(m+n) -- Both pointers traverse the string; target is counted once
SC: O(1)  -- Fixed-size array of 128 characters

 */

class Solution {
    public String minWindow(String s, String t) {

        // edge case
        if(s.length() < t.length()){
            return "";
        }

        // Frequency array for ASCII character
        int[] count = new int[128];

        for(int i = 0; i < t.length(); i++){
            count[t.charAt(i)]++;

        }

        int left = 0;
        int right = 0;

        // Number of character is needed
        int matched = 0;

        // Minimum window information
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        // Expand sliding window
        while(right < s.length()){

            char current = s.charAt(right);

            // If this character is required
            if(count[current] > 0 ){
                matched++;
            }

            // Decrease its required frequency
            count[current]--;

            // When all characters are matched
            while(matched == t.length()){

                // Calculate current window lenbgth
                int windowLength = right - left + 1;

                if(windowLength < minLength){
                    minLength = windowLength;
                    startIndex = left;

                }
               
                // Remove the leftmost character
                char removed = s.charAt(left);

                count[removed]++;

              // If a required character is missing
                if(count[removed] > 0){
                    matched--;

                }

                // Shrink the window 
                left++;

            }

            right++;

        }

        if(minLength == Integer.MAX_VALUE){
            return "";
        }

        return s.substring(startIndex , startIndex + minLength);

        
    }
}