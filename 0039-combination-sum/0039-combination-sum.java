class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<>(), 0, candidates, target);
        return res;
    }
    public void backtrack(List<List<Integer>> res, List<Integer> tempList, int idx, int[] candidates, int remaining){
        if(remaining<0)return;
        if(remaining == 0){
            Arrays.sort(candidates);
            res.add(new ArrayList<>(tempList));
        }
        for(int i=idx; i<candidates.length; i++){
            tempList.add(candidates[i]);
            backtrack(res, tempList, i, candidates, remaining-candidates[i]);
            tempList.remove(tempList.size() - 1);
        }
        
    }
}