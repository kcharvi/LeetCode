class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l = 0;
        int r = arr.length-1;
        int missing = 0;
        while(l<=r){
            int mid = l+(r-l)/2; //1 , 3
            missing = arr[mid] - (mid+1);
            if(missing < k)
                l=mid+1;
            else
                r=mid-1;
        }
        return l+k;
    }
}