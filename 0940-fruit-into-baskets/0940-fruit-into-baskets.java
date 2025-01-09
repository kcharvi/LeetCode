class Solution {
    public int totalFruit(int[] fruits) {
        int start = 0;
        int end = 0;
        int max_fruits = 0; 
        HashMap<Integer, Integer> map = new HashMap();
        while(end < fruits.length){
            map.put(fruits[end], map.getOrDefault(fruits[end], 0)+1);
            while(map.size() > 2){
                map.put(fruits[start], map.get(fruits[start])-1);
                if (map.get(fruits[start]) == 0) {
                    map.remove(fruits[start]);
                }
                start++;
            }
                max_fruits = Math.max(max_fruits, end-start+1);
                end++;
            
            // set.add(fruits[end]);
            // while (set.size() > 2) {
            //     set.remove(fruits[start]);
            //     start++;
            //     if (!set.contains(fruits[start - 1])) {
            //         set.add(fruits[start - 1]);
            //     }
            //     }
            
            // // Update the maximum fruits in a valid window
            // max_fruits = Math.max(max_fruits, end - start + 1);
            // // if(set.size() < 2){
            // //     set.add(fruits[end]);
            // // }
            // // if(set.containsKey(fruits[end])){
            // //     end++;
            // // }
            // // else{
            // //     set.remove(fruits[start]);
            // //     start++;
            // // }    
            // // max_fruits = Math.max(max_fruits, end - start + 1);       
        }
        return max_fruits;
    }
}