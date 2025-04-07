class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // USE STACK
        int[] ans = new int[temperatures.length];
        Stack<Integer> stk = new Stack();
        for(int i=0; i<temperatures.length; i++){
            while(!stk.isEmpty() && temperatures[i] > temperatures[stk.peek()]){
                int prevDay = stk.pop();
                ans[prevDay] = i-prevDay;
            }
            stk.push(i);
        }

        return ans;
    
    //     int numberOfDays = temperatures.length;
    //     int[] occurs = new int[101];
    //     Arrays.fill(occurs, -1);
    //     for(int i=0; i<numberOfDays; i++){
    //         occurs[temperatures[i]] = i; 
    //     }
    //     int[] answer = new int[numberOfDays];
    //     int i=0;
    //     for(int temp: temperatures){
    //         answer[i++] = checkNext(temp, numberOfDays, i, occurs);
    //     }
    //     return answer;
    // }
    // int checkNext(int currTemp, int totalNumberOfDays, int currDay, int[] occurs){
    //     int minClosestDay = totalNumberOfDays;
    //     for(int j=currTemp+1; j<=100; j++){
    //         if(occurs[j] > currDay && occurs[j]<minClosestDay){
    //             minClosestDay = occurs[j];
    //         }
    //     }
    //     return minClosestDay;
    }
}