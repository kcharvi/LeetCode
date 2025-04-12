class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        // binary search the first column
        int l = 0;
        int r = m*n-1;
        int mid = l+(r-l)/2;
        while(l<=r){
            mid = l+(r-l)/2;
            int midVal = matrix[mid / n][mid % n];

            if (midVal == target) {
                return true;
            } else if (midVal < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
       

    }
}