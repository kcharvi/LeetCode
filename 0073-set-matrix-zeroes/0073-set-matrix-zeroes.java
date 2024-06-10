class Solution {
    public void setZeroes(int[][] A) {
        ArrayList<Integer> rownum=new ArrayList<Integer>();
		ArrayList<Integer> colnum=new ArrayList<Integer>();
		for(int i=0; i<A.length; i++) 
			for (int j = 0; j < A[0].length; j++) 
				if(A[i][j]==0) {
					rownum.add(i);
					colnum.add(j);
				}
			
		for (int j = 0; j < rownum.size(); j++) {
			System.out.print(rownum.get(j)+" ");
		}
		System.out.println();
		for (int j = 0; j < colnum.size(); j++) {
			System.out.print(colnum.get(j)+" ");
		}
		System.out.println();
		
		// Make row zero
		int n=0;
		while(n<rownum.size()) {
			int i=rownum.get(n);
			for (int j = 0; j < A[0].length; j++) {
		          A[i][j]=0;
		        }
	    	n++;
	    }
		
	    // Make col zero
	    n=0;
		while(n<colnum.size()) {
			int i=colnum.get(n);
			for (int j = 0; j < A.length; j++) {
		          A[j][i]=0;
		        }
	    	n++;
	    }
      for(int i=0 ; i<A.length;i++) {
			for (int j = 0; j < A[0].length; j++) {
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
        
    }
}