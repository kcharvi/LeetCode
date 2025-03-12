class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack();
        for(int i=0; i<asteroids.length;i++){
            boolean destroyed = false;
            int curr = asteroids[i];
            while(!stk.isEmpty() && (curr<0 && stk.peek()> 0)){
                int p = stk.pop();
                if(Math.abs(p) > Math.abs(curr)){
                    stk.push(p);
                    destroyed = true;
                    break;
                }
                if(Math.abs(p) == Math.abs(curr)){
                    destroyed=true;
                    break;
                }
            }
            if(!destroyed)stk.push(curr);
        }
        int[] ans = new int[stk.size()];
        int i=stk.size()-1;
        while(!stk.isEmpty())
            ans[i--] = stk.pop();        
        return ans;
    }
}