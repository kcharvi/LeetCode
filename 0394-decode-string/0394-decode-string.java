class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String curString = "";
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // Build the number for k
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                // Push the current count and string onto their respective stacks
                countStack.push(k);
                stringStack.push(curString);
                // Reset for the new segment
                k = 0;
                curString = "";
            } else if (c == ']') {
                // Pop the count and previous string
                int repeatTimes = countStack.pop();
                String prevString = stringStack.pop();
                // Append the repeated current string to the previous string
                StringBuilder sb = new StringBuilder(prevString);
                for (int i = 0; i < repeatTimes; i++) {
                    sb.append(curString);
                }
                curString = sb.toString();
            } else {
                // Append the character to the current string
                curString += c;
            }
        }

        return curString;
    }
}