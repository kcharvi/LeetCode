class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length())return false;
        int[] word1chararr = new int[27];
        int[] word2chararr = new int[27];
        
        for(int i = 0; i<word1.length(); i++){
            word1chararr[word1.charAt(i)-96]++;
            word2chararr[word2.charAt(i)-96]++;
        }
        for(int i=0; i<word1chararr.length; i++){
            if(word1chararr[i] ==0 && word2chararr[i] != 0)
                return false;
            if(word2chararr[i] ==0 && word1chararr[i] != 0)
                return false;
        }
        Arrays.sort(word1chararr);
        Arrays.sort(word2chararr);
        return Arrays.equals(word1chararr, word2chararr)? true: false;
    }
}