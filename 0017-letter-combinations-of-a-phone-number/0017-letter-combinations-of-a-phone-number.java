class Solution {
    public List<String> letterCombinations(String digits) {
        List <String> list=new ArrayList<>();
        if(digits=="" || digits==null || digits.length()==0){
            return list;
        }
        Map<Character,String> hash=new HashMap<>();
       hash.put('2',"abc");
       hash.put('3',"def");
       hash.put('4',"ghi");
       hash.put('5',"jkl");
       hash.put('6',"mno");
       hash.put('7',"pqrs");
       hash.put('8',"tuv");
       hash.put('9',"wxyz");
       String [] strArr=new String[digits.length()];
       for(int i=0;i<digits.length();i++){
           strArr[i]=hash.get(digits.charAt(i));
       }
       String [] str=strArr[0].split("");
       for(int i=1;i<strArr.length;i++){
             str= getStrings(str,strArr[i]);
       }
       return Arrays.asList(str);
        
    }
    public String [] getStrings(String [] strArr,String str2){
        String [] str=new String[strArr.length*str2.length()];
        int k=0;
            for(int i=0;i<strArr.length;i++){
                for(int j=0;j<str2.length();j++){
                  str[k++] = strArr[i].concat(String.valueOf(str2.charAt(j)));
                } 
            }
            return str;
    }
}