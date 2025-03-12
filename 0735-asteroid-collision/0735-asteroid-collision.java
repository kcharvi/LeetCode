class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // Stack<Integer> stk = new Stack();
        // for(int i=0; i<asteroids.length;i++){
        //     boolean destroyed = false;
        //     int curr = asteroids[i];
        //     while(!stk.isEmpty() && (curr<0 && stk.peek()> 0)){
        //         destroyed = true;
        //         int p = stk.pop();
        //         if(Math.abs(p) > Math.abs(curr)){
        //             stk.push(p);
        //             destroyed = true;
        //             break;
        //         }
        //         if(Math.abs(p) == Math.abs(curr)){
        //             destroyed=true;
        //             break;
        //         }
        //     }
        //     if(!destroyed)stk.push(curr);
        // }
        // int[] ans = new int[stk.size()];
        // int i=stk.size()-1;
        // while(!stk.isEmpty())
        //     ans[i--] = stk.pop();        
        // return ans;

         Stack<Integer> stk = new Stack<>();
        
        for (int curr : asteroids) {
            boolean destroyed = false;

            // Collision happens only if stk.peek() > 0 and curr < 0
            while (!stk.isEmpty() && stk.peek() > 0 && curr < 0) {
                int top = stk.pop();

                if (Math.abs(top) > Math.abs(curr)) {  
                    stk.push(top); // The top asteroid survives
                    destroyed = true;
                    break;
                } else if (Math.abs(top) == Math.abs(curr)) { 
                    destroyed = true; // Both asteroids destroy each other
                    break;
                }
                // If curr is larger, continue checking against previous asteroids
            }

            if (!destroyed) {
                stk.push(curr);
            }
        }

        // Convert stack to an array
        int[] ans = new int[stk.size()];
        for (int i = stk.size() - 1; i >= 0; i--) {
            ans[i] = stk.pop();
        }
        return ans;
    }
}