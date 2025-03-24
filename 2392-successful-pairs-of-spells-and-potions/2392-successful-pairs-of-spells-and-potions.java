class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n=spells.length;
        int[] result = new int[n];
        Arrays.sort(potions);
        for(int i=0; i<n; i++){
            int spell = spells[i];
            long find_min = (success + spell - 1) / spell;
            int left = 0;
            int right = potions.length-1;
            
            while(left<=right){
                int mid = left+(right-left)/2;
                if(potions[mid] >= find_min)
                    right = mid-1;
                else 
                    left = mid+1;
            }
            result[i] = potions.length - left;
        }
        return result;
    }
}