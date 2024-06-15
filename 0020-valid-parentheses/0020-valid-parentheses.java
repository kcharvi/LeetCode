class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack();
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)=='{' || s.charAt(i)=='(' || s.charAt(i)=='[')
                stack.push(s.charAt(i));

            if(s.charAt(i)=='}' || s.charAt(i)==')' || s.charAt(i)==']'){
                if (stack.empty()) {
                    return false;
                }
                Character ch= stack.pop();
                if((s.charAt(i)!=']' && ch=='[') || 
                   (s.charAt(i)!=')' && ch=='(') || 
                   (s.charAt(i)!='}' && ch=='{'))
                   return false;
            }
        }
        return stack.empty();
    }
}