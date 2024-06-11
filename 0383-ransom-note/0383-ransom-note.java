class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // if(ransomNote.length()==0)return true;
        // if(ransomNote.length() > magazine.length()){
        //     return false;
        // }


        // HashMap<Character, Integer> mapmagazine = new HashMap();
        // HashMap<Character, Integer> mapransom = new HashMap();
        // for(int i=0; i<magazine.length();i++){
        //         mapmagazine.put(magazine.charAt(i), mapmagazine.getOrDefault(magazine.charAt(i), 0) +1);
        // }
        // for(int i=0; i<ransomNote.length();i++){
        //         mapransom.put(ransomNote.charAt(i), mapransom.getOrDefault(ransomNote.charAt(i), 0) +1);
        //         if(!mapmagazine.containsKey(ransomNote.charAt(i))){
        //             return false;
        //         }
        //         else if(mapransom.get(ransomNote.charAt(i)) > mapmagazine.get(ransomNote.charAt(i))){
        //             return false;
        //         }
        //     }          
        
        // return true;
        int[] alphabet = new int[26];

        for (char c : ransomNote.toCharArray()) {
            int i = magazine.indexOf(c, alphabet[c % 26]);
            if (i == -1) {
                return false;
            }
            alphabet[c % 26] = i + 1;
        }

        return true;
    }
}