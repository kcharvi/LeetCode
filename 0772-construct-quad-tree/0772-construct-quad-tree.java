/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        if(grid == null || grid.length == 0)return new Node();
        int row=0;
        int col=0;
        int n = grid.length;
        int m = grid[0].length;
        return buildQuad(row, n-1, col, m-1, grid);        
    }
    public Node buildQuad(int rStrt, int rEnd, int cStrt, int cEnd, int[][] grid){
        if(checkUniformity(rStrt, rEnd, cStrt, cEnd, grid)){
            return new Node(grid[rStrt][cStrt] == 1, true);
        }
        Node root = new Node();
        int newREnd = rStrt + (rEnd - rStrt)/2;
        int newCEnd = cStrt + (cEnd - cStrt)/2;
        root.topLeft = buildQuad(rStrt, newREnd, cStrt, newCEnd, grid); //topLeft
        root.topRight = buildQuad(rStrt, newREnd, newCEnd+1, cEnd, grid); //topRight
        root.bottomLeft = buildQuad(newREnd+1, rEnd, cStrt, newCEnd, grid); //bottomLeft
        root.bottomRight = buildQuad(newREnd+1, rEnd, newCEnd+1, cEnd, grid); //bottomRight
        // root.val = true;
        return root;       
    }

    public boolean checkUniformity(int rStrt, int rEnd, int cStrt, int cEnd, int[][] grid){
        int val = grid[rStrt][cStrt];
        for(int i=rStrt; i<=rEnd; i++)
            for(int j=cStrt; j<=cEnd; j++)
                if(grid[i][j]!=val)return false;
        return true;
    }
}