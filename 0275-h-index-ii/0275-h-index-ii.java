class Solution {
    public int hIndex(int[] citations) {
        int length = citations.length; //no. of papers
        int l = 0;
        int r = length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            int h = length-mid;
            //citations of mid paper <= citations of papers on the RHS (including mid)
            // and citations of mid paper > citations of papers on the LHS
            if(citations[mid] == h)
                return h;
            if(citations[mid] > h)
                r = mid-1;
            else l = mid+1;
        }
        return length-l;
    }
}