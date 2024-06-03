class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int n = gas.length;
        int total_tank = 0;
        int tank = 0;
        int start = 0;
        for(int i=0; i<n; i++){
            total_tank += gas[i] - cost[i];
            tank += gas[i] - cost[i];            
            if(tank < 0){
                tank = 0;
                start = i+1;
            }
        }        

        return (total_tank<0) ? -1 : start;
    }
}