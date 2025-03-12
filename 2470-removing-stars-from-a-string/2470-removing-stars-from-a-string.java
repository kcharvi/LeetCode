class Solution {
    public String removeStars(String s) {

        Stack<Character> stk = new Stack<>();
        char[] arr  = s.toCharArray();
        for(char c: arr){
            if(c!='*')
                stk.push(c);
            else
                stk.pop();
        }
        StringBuilder ans = new StringBuilder();
        while(!stk.isEmpty())
            ans.append(stk.pop());
        return ans.reverse().toString();
    }
}

// class Solution:
//     def removeStars(self, s: str) -> str:
//         n = len(s)
//         stack = []
        
//         for i in range(n):
//             if s[i] != '*':
//                 stack.append(s[i])
//             else:
//                 stack.pop()
                
//         return "".join(stack)        