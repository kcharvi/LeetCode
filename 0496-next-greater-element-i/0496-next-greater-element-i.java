class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap();

        for(int i = 0; i<nums2.length; i++)
            map.put(nums2[i], i);
        
        int[] ans = new int[nums1.length];
        for(int i = 0; i<nums1.length; i++){
            int pos = map.get(nums1[i]);
            int idx = pos+1;
            while(idx<nums2.length){
                if(nums2[idx] > nums1[i])
                    break;
                idx++;
            }
            if(idx<nums2.length)
                ans[i] = nums2[idx];
            else
                ans[i] = -1;
        }
        return ans;
    }
}