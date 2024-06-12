class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] splited = s.split(" ");
        if (splited.length != pattern.length()) return false;
        HashMap<Character, String> map = new HashMap();
        HashMap<String, Character> map2 = new HashMap();
        boolean flag = true;
        for(int i = 0; i<pattern.length();i++){
            if(map.containsKey(pattern.charAt(i)) || map2.containsKey(splited[i])){
                if(!splited[i].equals(map.get(pattern.charAt(i)))
                    ||
                    !(pattern.charAt(i) == map2.get(splited[i]))
                    ){
                    flag = false;
                    break;
                }
            }
            else{
                map.put(pattern.charAt(i), splited[i]);
                map2.put(splited[i], pattern.charAt(i));
            }
        }
        return flag;
    }
}