class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while(!stk.isEmpty() && nums[stk.peek()] < num){
                ans[stk.pop()]=num;
            }
            if(i<n)stk.push(i);
        }
        return ans;
    }
}