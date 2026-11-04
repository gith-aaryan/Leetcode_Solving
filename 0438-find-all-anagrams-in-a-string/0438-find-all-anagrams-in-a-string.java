/** Sliding Window with integerArray frequency table 

TC: O(n) & SC: O(1)
 */

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        // Step 1: Creating frequency map to store count of each character
        int[] sCount= new int[26];
        int[] pCount = new int[26];

        List<Integer> result = new java.util.ArrayList<>();  // result list , return at the end
        
        // Step 2: Count frequency of character in p  
        for(char c : p.toCharArray()){
            pCount[c - 'a']++;        

        }

        // Step 3: Sliding window to count frequency of character in s
        for(int i = 0; i < s.length(); i++){
            sCount[s.charAt(i) - 'a']++;

           // Step 4: remove the character that is out of window 
            if(i >= p.length()){
                sCount[s.charAt(i - p.length()) - 'a']--;

            }
            
            // Step 5: Compare Count
            if(Arrays.equals(pCount, sCount)){
                result.add(i - p.length() + 1); 

            }

        }

        return result;
    }
}