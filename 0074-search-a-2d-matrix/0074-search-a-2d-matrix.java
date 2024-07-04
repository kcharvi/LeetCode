class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        //Binary search the rows 
        int l_row = 0;
        int r_row = matrix.length-1;        
        while(l_row <= r_row){
            int mid = l_row+(r_row - l_row)/2;
            if(target == matrix[mid][0])return true;
            if(target < matrix[mid][0])
                r_row = mid-1;
            else l_row = mid+1;
        }

        if (r_row < 0 || r_row >= matrix.length) return false;

        //Binary Search the cols
        int l_col = 0;
        int r_col = matrix[r_row].length-1;
        while(l_col <= r_col){
            int mid = l_col+(r_col - l_col)/2;
            if(target == matrix[r_row][mid])return true;
            if(target < matrix[r_row][mid])
                r_col = mid-1;
            else l_col = mid+1;
        }

        return false;

    }
}