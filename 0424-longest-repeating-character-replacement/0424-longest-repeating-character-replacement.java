class Solution {
    public int characterReplacement(String s, int k) {
        //Inititalize the two points of sliding window and HashMap
        Map<Character, Integer> map = new HashMap();
        int start = 0; 
        int end = 0;
        int maxLength = 0;
        int maxCount = 0;

        while(end<s.length()){
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
            maxCount = Math.max(maxCount, map.get(s.charAt(end)));
            int currentStringLength = end-start + 1;
            if(currentStringLength - maxCount > k){
                map.put(s.charAt(start), map.get(s.charAt(start))-1);
                if(map.get(s.charAt(start)) == 0)map.remove(s.charAt(start));
                start++;
            }
            maxLength = Math.max(maxLength, end-start + 1);
            end++;
        }

        return maxLength;
    }
}