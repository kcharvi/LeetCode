class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int[] lis = new int[n];
        int[] cnt = new int[n];
        
        for(int i=0;i<n;i++)lis[i]=1;
        for(int i=0;i<n;i++)cnt[i]=1;
        
        int max_cnt=1;
        for(int i=1;i<n;i++) {
            for(int j=0;j<i;j++){   
            	if(nums[i]>nums[j]){
                    if(lis[i]<1+lis[j]){
                        lis[i]=lis[j]+1;
                        cnt[i]=cnt[j];
                    }
                    else if(lis[i]==1+lis[j])
                        cnt[i]+=cnt[j];
                }
            }
            max_cnt=Math.max(max_cnt, lis[i]);
        }
        int res=0;
        for (int i = 0; i < lis.length; i++) {
            if(lis[i]==max_cnt)res+=cnt[i];
		}
      
        return res;
    }
}