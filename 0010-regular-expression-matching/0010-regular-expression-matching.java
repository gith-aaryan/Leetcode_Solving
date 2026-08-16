/*
 key difficulty is understanding how * works.
 Dynamic Programming (DP).

 ' . ' is any charcter
 ' * ' Take the character immediately before *  , zero or more times.

 “Can the remaining part of s, starting from i, match the remaining part of p, starting from j?”

dp[i][j] = whether s.substring(i) matches p.substring(j).

At every (i, j):
1. Check whether the current characters match:
     s[i] == p[j]
     or p[j] == '.'

2. If the next pattern character is *, we have two choices:
    Skip x* completely → dp[i][j + 2]
    Use x* to match one character → dp[i + 1][j]     

                a*
               /  \
              /    \
          SKIP      USE
            |        |
            ↓        ↓
         j + 2    i + 1, j


*/

class Solution{
    public boolean isMatch(String s , String p){
        int m = s.length();
        int n = p.length();

        // Boolean - null , true , false 

        Boolean[][] dp = new Boolean[m + 1][n + 1];  // represent the empty remaining string.

        return solve(0 , 0 , s , p , dp);  // 0 → starting position in s (i=0), 0 → starting position in p (j=0), s → actual string, p → pattern, dp → DP memory table

    }

    private boolean solve(int i , int j , String s , String p , Boolean[][] dp ){

        // “Have we finished reading the pattern?”
        if( j == p.length()){
            return i == s.length();  // “Is the string also finished?”

        }

        // Checking our DP table 
        if(dp[i][j] != null){
            return dp[i][j];

        }

        // “Can the current character of s match the current character of p?”
        boolean firstMatch =  i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        boolean result ; // true or false - depending on whether the remaining string and pattern match.

        // Next charcter is '*'
        if( j + 1 < p.length() && p.charAt( j + 1) == '*'){

            // Option 1: Ignore "x*" completely and continue with after it.
            boolean skip = solve(i, j + 2, s, p, dp);

            // Option 2: Use '*' to match current character
            boolean use = firstMatch &&
                    solve(i + 1, j, s, p, dp);  //  Why don’t we move j? Because * can use a again.
                    
                    result = skip || use;
        } else {
            // Normal character or ' . '
            result = firstMatch && solve(i + 1, j + 1, s, p, dp);
        }

        dp[i][j] = result;  // Next time we reach like (1,2), we don’t have to calculate it again.
        return result; // true or false
        
    }
}