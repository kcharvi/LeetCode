class Solution {
    //IDEA: First trim extra spaces
    //split the string and store in arr
    //use stringBuilder and append the words in reverse order
    //finally append the first element and return
    public String reverseWords(String s) {
        //Base case:
        if(s.length()==0 || s.length()==1)return s;
        
        s = s.trim();
        String[] res=s.split(" ");
        StringBuilder ans = new StringBuilder();
        for(int i=res.length-1; i>0;i--){
            if(res[i].length()!=0)
            ans=ans.append(res[i].trim()+" ");
        }
        ans.append(res[0]);
        return ans.toString();
    }
}