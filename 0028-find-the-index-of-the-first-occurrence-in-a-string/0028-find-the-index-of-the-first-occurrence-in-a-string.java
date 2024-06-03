class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0) return 0;
        if (haystack.length()<needle.length() || !haystack.contains(needle))  return -1;

        int needle_length = needle.length();
        int i = 0;
        while(i<=haystack.length()-needle_length){
            String substring_from_i = haystack.substring(i, i+ needle_length);
            System.out.println(substring_from_i);
            if(substring_from_i.equals(needle)){
                System.out.println("True");
                return i;
            }
            i = i+1;
            
        }
        return -1;
    }
}