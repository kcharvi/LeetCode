class Solution {

    public int maxProfit(int[] prices) {
        int sz = prices.length;
        int[] ra = maxProfitForOneTrx(prices,0,sz); // max profit if we do one transaction of buy and sell.
        int left = ra[0], right = ra[1], max1= ra[2]; // get left index, right index and max profit for one trx.

        if(max1 == 0) return 0; // not possible to get profit in one trx, then return.
        
        int leftmax = 0; 
        if(left>0) 
            leftmax = maxProfitForOneTrx(prices,0,left)[2]; // find max profit for index 0, to "left" from above.
        
        int rightmax = 0;
        if(right<prices.length-1)
            rightmax = maxProfitForOneTrx(prices,right+1,sz)[2]; // find max profit for index "right" till end of array.
       
        int maxinrange = maxProfitInRange(prices,left,right+1); // for the range in one trx, check if we can get
        // more profit by doing two trx in this range. 

        int max = 0; // get max of all in below steps
        max = Math.max(leftmax + max1  , max);
        max = Math.max(rightmax + max1 , max);
        max = Math.max(maxinrange,       max);

        return max;
    }

    // for the array defined by index stInc and endExc, find the max we can get in 1 trx.
    private int[] maxProfitForOneTrx(int[] p, int stInc, int endExc){

        int min = Integer.MAX_VALUE, max = 0;
        int minI = 0, maxI = 0;

        int prvminI = 0;
        for(int i=stInc;i<endExc;i++){

            if(min>p[i]) { minI = i; min = p[i]; }
            else if(max< (p[i] - min)){
                    maxI = i; max = p[i]; 
                    max = p[i] - min ;
                    prvminI = minI;
            }
        }

        return new int[]{prvminI,maxI, max};
    }


    // at the st we have the minimum value of this range, and at the end we have the maximum value of this range.
    // then it will try to find any peak&dip which is between st+1 and end-1, if so then at that index if we sell
    // and then buy at minimum after that then total profit in this range will be more than original profit with only 
    // one trsansaction.
    private int maxProfitInRange(int[] p, int st, int end){
        int max = 0;
        int maxI = 0;   // this will be the position where we find the highest value before dip.
        int min = Integer.MAX_VALUE;
        for(int i=st+1;i<end-1;i++){
            if (p[i+1]<p[i] && (p[i] > max) ){ // found a dip.
                max     = p[i]; // record the max value before the dip at i+1.
                maxI    = i; 
                min     = Integer.MAX_VALUE; // reset min to count from here again.
            }
             min = Math.min(min, p[i]); // keep tracking minimum.
        }
        if(maxI == 0) return p[end-1] - p[0]; // no dip found so original arr end - value at 0 is max.
        int ans = p[maxI] - p[st] + p[end-1] - min;
        return ans;
    }


}