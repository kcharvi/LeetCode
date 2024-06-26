class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // List<Integer> list= new ArrayList<>();
        // int n=matrix.length;
        // int row=0, col=0, side=n-1, down=n-1, dir=1, number=1;
        
        List<Integer>ans = new ArrayList<>();
        if(matrix.length == 0)return ans;
        
        int r1 =0,r2 =matrix.length-1;
        int c1 = 0,c2 =matrix[0].length-1;
        
        while(r1<=r2&&c1<=c2){
            for(int c = c1; c<=c2;c++)
                ans.add(matrix[r1][c]);
            for(int r = r1+1;r<=r2;r++)
                ans.add(matrix[r][c2]);
            if(r1<r2&&c1<c2){
                for(int c = c2-1;c>c1;c--)
                    ans.add(matrix[r2][c]);
                for(int r = r2;r>r1;r--)
                    ans.add(matrix[r][c1]);
            }
            c1++;
            r2--;
            r1++;
            c2--;
        }
        return ans;
        
    }
}