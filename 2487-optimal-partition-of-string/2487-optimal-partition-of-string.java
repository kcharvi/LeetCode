class Solution {
    public int partitionString(String s) {
        int n = s.length();
        int[] max_lengths = new int[n];
        for(int i=0; i<n; i++){
            HashSet set = new HashSet<>();
            for(int j=i; j<n; j++){
                if(set.contains(s.charAt(j))) break;
                set.add(s.charAt(j));
            }
            max_lengths[i] = set.size();
            set.clear();
        }
        int splits = 0;
        int i = 0;
        
        while (i < n) {
            splits++;
            i += max_lengths[i];
        }
        
        return splits;
    }
}