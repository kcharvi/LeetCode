class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int l = 0;
        int r = arr.length-k;
        while(l<r){
            int mid = l+(r-l)/2;
            if(x-arr[mid] > arr[mid+k]-x)
                l=mid+1;
            else r=mid;
        }
        for(int i = l; i<l+k; i++)
            ans.add(arr[i]);
        return ans;
    }
}