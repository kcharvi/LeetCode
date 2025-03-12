class Solution {
    public String decodeString(String s) {
        Stack<Integer> numstk = new Stack();
        Stack<StringBuilder> strstk = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int num=0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch))
                num = num * 10 + (ch - '0');
            else if(ch == '['){
                numstk.push(num);
                strstk.push(curr);
                curr = new StringBuilder();
                num=0;
            }
            else if(ch == ']'){
                int times = numstk.isEmpty()? 1: numstk.pop();
                StringBuilder decoded = new StringBuilder();
                while(times>0){
                    decoded.append(curr);
                    times--;
                }
                curr = strstk.pop().append(decoded);
            }
            else
                curr.append(ch);

        }
        return curr.toString();
        
    }
}