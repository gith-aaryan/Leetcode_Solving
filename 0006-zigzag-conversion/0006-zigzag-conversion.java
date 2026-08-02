class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || numRows > s.length()){
            return s;

        }

        StringBuilder[] rows = new StringBuilder[numRows];

        for(int i=0 ; i < numRows; i++){
            rows[i]  = new StringBuilder() ;

        }

        int currentRow = 0;
        boolean isGoingDown = false;

        for(char c: s.toCharArray()){
            rows[currentRow].append(c);

             if(currentRow == 0 || currentRow == numRows - 1){
                isGoingDown = !isGoingDown; // becomes true

            }

            currentRow += isGoingDown ? 1 : -1 ;

        }

        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows){
            res.append(row);
        }

        return res.toString();

        
        

    
        
    }
}