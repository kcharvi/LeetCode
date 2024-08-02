class Solution {
    public String removeDuplicates(String s, int k) {
        Stack <Integer> intStack = new Stack<>();
        Stack <Character> charStack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            if(!charStack.isEmpty() && charStack.peek() == c){
                intStack.push(intStack.peek() + 1);
                charStack.push(c);
                if(intStack.peek() == k){
                    for(int i = 0 ; i < k ; i++){
                        intStack.pop();
                        charStack.pop();
                    }
                }
            }else{
                intStack.push(1);
                charStack.push(c);
            }
        }

        while(!charStack.isEmpty()){
            char c = charStack.pop();
            sb.append(c);
        }

        return sb.reverse().toString();
    }
}