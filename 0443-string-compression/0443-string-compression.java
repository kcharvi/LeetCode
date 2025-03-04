class Solution {
    public int compress(char[] chars) {
        if(chars.length==1)return 1;
        int count = 1;
        String s="";
        for(int i=1; i<chars.length; i++){
            if(chars[i-1] != chars[i]){
                s = s+chars[i-1];
                if(count>1)
                    s = s+count;
                count = 1;
            }
            else{
                count++;
            }
        }
        s+=chars[chars.length-1];
        if(count>1)
            s+=count;
        for(int i=0; i<s.length(); i++){
            chars[i] = s.charAt(i);
        }
        return s.length();

    }
}