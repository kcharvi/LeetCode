class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>(); 
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (token.equals("+") ||
                token.equals("-") ||
                token.equals("*") ||
                token.equals("/")) {
                int b = s.pop();
                int a = s.pop();
                int res = 0;
                switch (token) {
                    case "+":
                        res = a + b;
                        break;
                    case "-":
                        res = a - b;
                        break;
                    case "*":
                        res = a * b;
                        break;
                    case "/":
                        res = a / b;
                        break;
                }
                s.push(res);
            } else {
                s.push(Integer.valueOf(token));
            }
        }
        return s.pop();

    }
}