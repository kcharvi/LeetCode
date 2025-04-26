class Solution {
    Map<String, Integer> map = new HashMap();
    public int numTrees(int n) {
        return helper(1, n);
    }
    int helper(int start, int end){
        if(start>end){
            return 1;
        }
        int count = 0;
        if(map.containsKey(start+","+end))
            return map.get(start+","+end);
        for(int i=start; i<=end; i++){
            int lefttree = helper(start, i-1);
            int righttree = helper(i+1, end);
            count +=lefttree * righttree;
        }
        map.put(start+","+end, count);
        return count;
    }
}