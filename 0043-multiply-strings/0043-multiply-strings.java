class Solution {
    public String multiply(String num1, String num2) {
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') {
            return "0";
        }
        
        int len1 = num1.length();
        int len2 = num2.length();
        int[] memo = new int[len1 + len2];
		// will fill from the right to left.
        int k = len1 + len2 - 1;
        for (int i = len1 - 1; i >= 0; i--) {
            int index = k;
            
            for (int j = len2 - 1; j >= 0; j--) {
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                
                int c = a * b + memo[index];
                memo[index] = c % 10;
                if (index - 1 >= 0) {
                    memo[index - 1] += c / 10;
                }
                
                index -= 1;
            }
            k -= 1;
        }

        // remove leading 0s
        int i = 0;
        while (memo[i] == 0) i += 1;
        
        StringBuilder sb = new StringBuilder();
        for (; i < len1 + len2; i++) {
            sb.append(memo[i]);
        }
        
        return sb.toString();    }
}