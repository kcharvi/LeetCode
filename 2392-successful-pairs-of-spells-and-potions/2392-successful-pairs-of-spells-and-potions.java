class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int no_spells = spells.length;
        int no_potions = potions.length;
        int[] result = new int[no_spells];
        for(int i = 0; i<no_spells; i++){
            int l = 0;
            int r = no_potions-1;
            while(l<=r){
                int mid = l+(r-l)/2;
                if((long) potions[mid]*spells[i] < success)
                    l = mid+1;
                else r=mid-1;
            }
            result[i] = no_potions-l;
        }
        return result;
    }
}