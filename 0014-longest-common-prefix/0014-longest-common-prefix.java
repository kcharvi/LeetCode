class Solution {
    //IDEA: Find the shortest string
    //Iterate every string check if it starts with this shortest string,
    // if not then reduce the searchstring by 1 using substring;
    public String longestCommonPrefix(String[] strs) {
        //BASE CASE
        if(strs.length == 1)return strs[0];

        String searchString=strs[0];
        for(String s: strs){
            if(s.length()<searchString.length()){
                searchString=s;
            }
        }
        for(String s:strs){
            while(!s.startsWith(searchString)){
                searchString=searchString.substring(0,searchString.length()-1);
            }
        }
        return searchString;
    }
}