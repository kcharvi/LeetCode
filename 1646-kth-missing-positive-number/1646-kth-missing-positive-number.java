class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l = 0;
        int r = arr.length-1;
        int missing = 0;
        while(l<=r){
            int mid = l+(r-l)/2; //2, 3, 4
            missing = arr[mid] - (mid+1); //4-3=1, 7-4=3, 11-5=6
            if(missing < k) 
                l=mid+1;  //3, 4
            else
                r=mid-1; //3
        }
        return l+k;  //4+5
    }
}