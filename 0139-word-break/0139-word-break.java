class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String,Boolean> hash = new HashMap<>();
        return f("",s,wordDict,hash);
    }
    public boolean f(String cur,String target,List<String> wordDict,HashMap<String,Boolean> hash){
        if(cur.length() == target.length()){
            if(cur.equals(target)){
                return true;
            } 
        }
        if(hash.containsKey(cur)){
            return hash.get(cur);
        }
        for(int i = 0; i<wordDict.size(); i++){
            String j = wordDict.get(i);
            String u = cur + j;
            if(u.length()<=target.length()){
                String y = target.substring(0,u.length());
                if(u.equals(y)){
                    if(f(cur+wordDict.get(i),target,wordDict,hash)){
                        hash.put(cur,true);
                        return true;
                    }   
                }
            }
        }
        hash.put(cur,false);
        return false;
    }
}