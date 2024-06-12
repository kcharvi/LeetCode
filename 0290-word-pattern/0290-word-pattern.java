class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<String, Character> map = new HashMap();
        String[] strs = s.split(" ");
        if(strs.length!=pattern.length())return false;
        int i=0;
        for(String str: strs){
            if(map.containsKey(str)){
                if(map.get(str) != pattern.charAt(i))
                    return false;
            }
            else{
                if(map.containsValue(pattern.charAt(i)))
                    return false;
                
                map.put(str, pattern.charAt(i));
            }
            i++;
        }
        return true;
    }
}