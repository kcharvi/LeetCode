class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stk = new Stack();
        for(String op : operations){
            if(op.equals("C")){
                stk.pop();              
            }
            else if(op.equals("+")){
                int first = stk.pop();
                int second = stk.pop();
                stk.push(second);
                stk.push(first);
                stk.push(first+second);
                
            }
            else if(op.equals("D")){
                int doublingScore = stk.peek();
                stk.push(2*doublingScore);
            }
            else {
                stk.push(Integer.parseInt(op));
            }
        }
        int totScore = 0;
        while(!stk.isEmpty())totScore+=stk.pop();
        return totScore;
    }
}