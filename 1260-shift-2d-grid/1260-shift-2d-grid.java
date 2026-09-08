/** 1D reversal approach,

 */

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int row = grid.length;
        int col = grid[0].length; 

        int n = row * col;

        k = k % n;

        if(k == 0){
            return convertToList(grid);

        }

        // Reverse entire array
        reverse(grid , 0 , n-1 , col);

        // Reverse first k elements
        reverse(grid , 0 , k-1 , col);

        // Reverse remaining elements
        reverse(grid , k , n-1 , col);

        return convertToList(grid);

        
    }

    private void reverse(int[][] grid , int i , int j , int col ){

        while(i < j){

        int row1 = i / col;
        int col1 = i % col;

        int row2 = j / col;
        int col2 = j % col;

        int temp = grid[row1][col1];
        grid[row1][col1] = grid[row2][col2];
        grid[row2][col2] = temp;


        i++;
        j--;

        }

    }

     private List<List<Integer>> convertToList(int[][] grid){

         List<List<Integer>>  result = new ArrayList<>();

         for(int[] row : grid){

            List<Integer> list = new ArrayList<>();


            for(int value : row){
                list.add(value);


            }

            result.add(list);
         }

         return result;

     }



}