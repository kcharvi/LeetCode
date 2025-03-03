class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        //Base Case
        if(len==1){
            if(flowerbed[0] == 0 && n==1 || n==0)return true;
            else return false;
        }
        int count = n;
        for(int i=0; i<len-1; i++){
            if(i==0){
                if(flowerbed[i] == 0 && flowerbed[i+1] == 0){
                    flowerbed[i] = 1;
                    count--;
                }
                continue;
            }
            if(flowerbed[i]==0){ 
                if(flowerbed[i-1]==0 && flowerbed[i+1]==0){
                    flowerbed[i] = 1;
                    count--;
                }
            }
                    
        }
        if(flowerbed[len-1]==0 && flowerbed[len-2]==0){
            count--;
        }
        return count<=0 ? true:false;
    }
}