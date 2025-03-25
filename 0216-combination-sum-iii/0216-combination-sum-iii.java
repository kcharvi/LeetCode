class Solution {
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> combinationSum3(int k, int n) {
        // Conditions: If current sum > n, simply return
        // if current sum == n add the List to ans, 
        // lets use current number to denote 1 to 9 and 
        // number will always be unique and used at most once
        backtrack(k, n, 0, 1, new ArrayList<>());
        return ans;
    }
    void backtrack(int k, 
                   int n, 
                   int sumSoFar, 
                   int number, 
                   ArrayList<Integer> numbersAddedSoFar){
        if(sumSoFar>n || numbersAddedSoFar.size() > k)
            return;
        if(sumSoFar == n && numbersAddedSoFar.size() == k){
            ans.add(new ArrayList<>(numbersAddedSoFar));
            return;
        }
        for(int i=number; i<=9; i++){
            numbersAddedSoFar.add(i);
            backtrack(k, n, sumSoFar+i, i+1, numbersAddedSoFar);
            numbersAddedSoFar.remove(numbersAddedSoFar.size() - 1);
        }
        
    }
}