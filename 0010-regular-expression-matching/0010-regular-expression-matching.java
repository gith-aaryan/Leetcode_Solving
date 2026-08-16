/*
 key difficulty is understanding how * works.
 Dynamic Programming (DP).

dp[i][j] = whether s.substring(i) matches p.substring(j).

At every (i, j):
1. Check whether the current characters match:
     s[i] == p[j]
     or p[j] == '.'

2. If the next pattern character is *, we have two choices:
    Skip x* completely → dp[i][j + 2]
    Use x* to match one character → dp[i + 1][j]     


*/

class Solution{
    public boolean isMatch(String s , String p){
        int m = s.length();
        int n = p.length();

        Boolean[][] dp = new Boolean[m + 1][n + 1];  
        return solve(0 , 0 , s , p , dp);

    }

    private boolean solve(int i , int j , String s , String p , Boolean[][] dp ){

        // Pattern completely consumed
        if( j == p.length()){
            return i == s.length();

        }

        if(dp[i][j] != null){
            return dp[i][j];

        }

        // checks if current character matches
        boolean firstMatch =  i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        boolean result ; // true

        // Next charcter is '*'
        if( j + 1 < p.length() && p.charAt( j + 1) == '*'){

            // Option 1: Ignore "x*"
            boolean skip = solve(i, j + 2, s, p, dp);
              // Option 2: Use '*' to match current character
            boolean use = firstMatch &&
                    solve(i + 1, j, s, p, dp);
                    
                    result = skip || use;
        }else{
            // Normal character or ' . '
            result = firstMatch && solve(i + 1, j + 1, s, p, dp);
        }

        dp[i][j] = result;
        return result;
        
    }
}