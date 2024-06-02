class Solution {
    public int hIndex(int[] c) {
        Arrays.sort(c);
        for(int i=0; i<c.length;i++){
            if(c[i]>=c.length-i){
                return c.length-i;   
            }
        }
        return 0;
    }
}