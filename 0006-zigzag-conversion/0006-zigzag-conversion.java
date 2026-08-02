class Solution {
    public String convert(String s, int numRows) {
        
        // single row check 
        if(numRows == 1 || numRows > s.length()){
            return s;

        }

        StringBuilder[] rows = new StringBuilder[numRows];

        // iterate each row
        for(int i=0 ; i < numRows; i++){
            rows[i]  = new StringBuilder() ;

        }

        int currentRow = 0;  // let's take variable to check 
        boolean isGoingDown = false;  // is goingDown 

        // iterate each Character of Array
        for(char c: s.toCharArray()){
            rows[currentRow].append(c);  // append each elements to last of array

             // going down depends on condition - last numRows - 
             if(currentRow == 0 || currentRow == numRows - 1){
                isGoingDown = !isGoingDown; // becomes true

            }

            // increment & decrement
            currentRow += isGoingDown ? 1 : -1 ;

        }

        // to store into StringBuilder.
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows){
            res.append(row);
        }

        return res.toString();
        
    }
}