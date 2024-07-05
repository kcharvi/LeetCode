class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        ArrayList<Integer> al=new ArrayList<>();
         int[] arr=new int[n+m];
        for(int i=0;i<n;i++){
            al.add(nums1[i]);
        }
        for(int i=0;i<m;i++){
            al.add(nums2[i]);
        }
        for(int i=0;i<n+m;i++){
            arr[i]=al.get(i);
        }
        Arrays.sort(arr);
       
        
        int low=0;
        int high=arr.length-1;
        int mid=(low+(high-low))/2;
        if((n+m)%2!=0){
            return (double)arr[mid];
        }else{
            return (double)(arr[mid]+arr[mid+1])/2;
        }
    }
}