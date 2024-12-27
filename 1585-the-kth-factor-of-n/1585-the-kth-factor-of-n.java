class Solution {
    public int kthFactor(int n, int k) {
        int ans = -1;
        ArrayList<Integer> list = new ArrayList();
        for(int i=1; i<=n; i++){
            if(n%i == 0)list.add(i);
        }
        return (k<=list.size() ? list.get(k-1): -1);
    }
}