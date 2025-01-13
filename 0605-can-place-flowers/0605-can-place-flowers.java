class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // if(n == 0)return true;
        // if(flowerbed.length == 1){
        //     if(n == 1){
        //         if(flowerbed[0] == 0)return true;
        //         else return false;
        //     }
        //     else return true;
        // }
        // int count = 0;
        // int i = 0;
        // while(i<flowerbed.length){
        //     if(count == n)return true;
        //     if(i==0){
        //         if(flowerbed[i+1] !=1 && flowerbed[i] == 0){
        //             flowerbed[i] = 1;
        //             count++;
        //         }
        //     }
        //     if(i==flowerbed.length-1){
        //         if(flowerbed[i-1] !=1 && flowerbed[i] == 0){
        //             flowerbed[i] = 1;
        //             count++;
        //         }
        //     }
        //     else {
        //         if(flowerbed[i-1] != 1 && flowerbed[i+1] !=1 && flowerbed[i] == 0){
        //                 flowerbed[i] = 1;
        //                 count++;
        //             }
        //         i++;
        //     }
        // }
        // return false;
        if (n == 0) return true;

        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 &&
                (i == 0 || flowerbed[i - 1] == 0) &&
                (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
                if (count >= n) return true; 
            }
        }

        return count >= n;
    }
}