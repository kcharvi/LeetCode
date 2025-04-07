class StockSpanner {
    Stack<int[]> stk;
    
    public StockSpanner() {
        this.stk = new Stack();
    }

    public int next(int price) {
        int countOfConsecutiveDays = 1;
        while(!stk.isEmpty() && price>=stk.peek()[0]){
            countOfConsecutiveDays += stk.pop()[1];
        }   
        stk.push(new int[]{price, countOfConsecutiveDays});
        return countOfConsecutiveDays;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */