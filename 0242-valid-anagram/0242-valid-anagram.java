class Solution {
    public boolean isAnagram(String s, String t) {
        // BAD SOLUTION
        // if(s.length()!=t.length()){
        //     return false;
        // }
        // HashMap<Character, Integer> map = new HashMap();
        // for(int i = 0; i<s.length(); i++){
        //     if(map.containsKey(s.charAt(i))){
        //         map.put(s.charAt(i), map.get(s.charAt(i))+1);
        //     }
        //     else{
        //         map.put(s.charAt(i), 1);
        //     }
        // }
        // for(int i = 0; i<t.length(); i++){
        //     if(map.containsKey(t.charAt(i)) && map.get(t.charAt(i))>0){
        //         map.put(t.charAt(i), map.get(t.charAt(i))-1);
        //     }
        //     else{
        //         return false;
        //     }
        // }
        // return true;


        // FINE SOLUTION
        if(s.length()!=t.length())return false;
        char sch[] = s.toCharArray();
        char tch[] = t.toCharArray();
        Arrays.sort(sch);
        Arrays.sort(tch);
        for(int i=0;i<sch.length;i++)
            if(sch[i]!=tch[i])return false;
        return true;

        
    }
}