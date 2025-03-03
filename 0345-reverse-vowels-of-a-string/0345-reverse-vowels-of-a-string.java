class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> set = new HashSet();
        List<Character> vowels = Arrays.asList('a','e','i','o','u', 'A','E','I','O','U');
        set.addAll(vowels);
        List<Character> occurance = new ArrayList();
        for(int i=0; i<s.length(); i++){
            if(set.contains(s.charAt(i)))
                occurance.add(s.charAt(i));
        }
        Collections.reverse(occurance);
        char[] arr = s.toCharArray();
        int j=0;
        for(int i=0; i<s.length(); i++){
            if(set.contains(arr[i])){
                arr[i] = occurance.get(j);
                j++;
            }
        }
        return new String(arr);
        
    }
}