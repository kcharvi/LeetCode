class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) 
            return ans;
        
        HashMap<Character, String> lettermap = new HashMap<>();
        lettermap.put('2', "abc");
        lettermap.put('3', "def");
        lettermap.put('4', "ghi");
        lettermap.put('5', "jkl");
        lettermap.put('6', "mno");
        lettermap.put('7', "pqrs");
        lettermap.put('8', "tuv");
        lettermap.put('9', "wxyz");

        backtrack(lettermap, digits, 0, new StringBuilder());
        return ans;
    }
    void backtrack(HashMap<Character, 
                   String> lettermap, 
                   String digits, 
                   int idx, 
                   StringBuilder formedsofar){
        if(formedsofar.length() == digits.length()){
            ans.add(formedsofar.toString());
            return;
        }
        
        if(idx<digits.length()){
            char ch = digits.charAt(idx);
            String available = lettermap.get(ch);
            for(int j=0; j<available.length(); j++){
                formedsofar.append(available.charAt(j));
                backtrack(lettermap, digits, idx+1, formedsofar);
                formedsofar.deleteCharAt(formedsofar.length() - 1);
            }
        }
    }
}