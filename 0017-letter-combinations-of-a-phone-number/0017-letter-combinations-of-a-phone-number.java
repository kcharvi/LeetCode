class Solution {
    
    public List<String> letterCombinations(String digits) {
        if(digits=="" || digits==null || digits.length()==0)
            return new ArrayList<>();
        
        Map<Character, String> map = new HashMap();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        
        String[] strs = new String[digits.length()];
        for(int i =0; i<digits.length();i++)
            strs[i]=map.get(digits.charAt(i));
        
        String[] arr = strs[0].split(""); // 2 - abc   arr=["a","b","c"]
        for(int i=1; i<strs.length; i++)
            arr = getStrings(arr, strs[i]);   // (arr=["a","b","c"], strs=["def"])
        return Arrays.asList(arr);
    }
    public String[] getStrings(String[] arr, String str){
        String[] temp = new String[arr.length * str.length()];  // arr=3 * str=3  which is 9
        int k=0;
        for(int i=0;i<arr.length;i++)
            for(int j=0; j<str.length();j++)
                temp[k++] = arr[i].concat(String.valueOf(str.charAt(j)));
        return temp;
    }
}