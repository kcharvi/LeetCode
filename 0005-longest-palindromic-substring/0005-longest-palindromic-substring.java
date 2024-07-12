class Solution {
    public String longestPalindrome(String s) { 

         if(s.length()<=1){
            return s;
         }
          String Lps= "";

          for(int i =1; i < s.length() ; i++){
            
                int start=i;
                int end =i;
                // odd
                while(s.charAt(start)==s.charAt(end)){
                    start--;
                    end++;
                    if(start<=-1 || end>= s.length()){
                        break;
                    }
                }
                String subPalindrome = s.substring(start+1 ,end);
                if(subPalindrome.length()>Lps.length()){
                Lps= subPalindrome;
                }

               // even
               start=i-1;
               end=i;
               while(s.charAt(start)==s.charAt(end)){
                start--;
                end++;
                 if(start<=-1 || end>=s.length()){
                    break;
                 }
               }
                subPalindrome = s.substring(start+1 ,end);
                if(subPalindrome.length()>Lps.length()){
                     Lps= subPalindrome;
                }
            }  

            return Lps;      
    }
}