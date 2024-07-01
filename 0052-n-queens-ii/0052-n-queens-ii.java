class Solution {
    public int totalNQueens(int n) {
        int[][] arr = new int[n][n];
        int row=0;
        int col=0;
        return backtrack(arr, row, n);
    }
    public int backtrack(int[][] arr, int row, int n){
        if(row==n){
            for(int i=0; i<n; i++)return 1;
        }
        int ans=0;
        for(int col=0; col<n; col++){
            if(possibleLocation(arr, row, col, n)){
                arr[row][col]=1;
                ans+= backtrack(arr, row+1, n);
                arr[row][col]=0;
            }
        }
        return ans;
    }
    public boolean possibleLocation(int[][] arr, int row, int col, int n){
        
        //Horizontal
        for(int i=0; i<n;i++)
            if(arr[row][i] == 1)return false;

        //Vertical
        for(int i=0; i<n;i++)
            if(arr[i][col] == 1)return false;

        //Positive Diagonal
        int i=row-1;
        int j=col-1;
        while(i>=0 && j>=0){
            if(arr[i][j] == 1)return false;
            i--;
            j--;
        }

        //Negative Diagonal
        i = row-1;
        j = col+1;
        while(i>=0 && j<=(n-1)){
            if(arr[i][j] ==1)return false;
            i--;
            j++;
        }

        return true;
    }
}