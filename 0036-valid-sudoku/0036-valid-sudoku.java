/** 

Sudoku Validation logic : 
It does not appear twice in the same row.
It does not appear twice in the same column.
It does not appear twice in the same 3×3 box.

 */


class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 2D Array
        int[][] rows = new int[9][9];   // 0-8
        int[][] cols = new int[9][9];   
        int[][] boxes = new int[9][9];    

        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                if(board[r][c] == '.' ){    // If this cell is empty, ignore it and move to the next cell. 
                    continue;

                }

                int val = board[r][c] - '1';  // sudoku value 1-9 but array are 0-8

                if(rows[r][val] == 1){
                   return false;
                }

                rows[r][val] = 1; // We have now seen this number in this row.


                if(cols[c][val] == 1 ){
                    return false;

                }

                cols[c][val] = 1;

                int boxIndex = 3 * (r / 3) + (c / 3);  // 3×3 box :  This converts a cell's (row, column) into one of the nine box numbers:

                if(boxes[boxIndex][val] == 1){
                    return false;
                }

                boxes[boxIndex][val] = 1;


            }
        }
        return true;    
     
      
    }
}