class Solution {
    
    static String[] symbol = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    static int[] value = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    
    public String intToRoman(int num) {        
        StringBuilder sb = new StringBuilder();
        int i = value.length - 1;
        
        while(num > 0 && i >= 0){
            
            if(num < value[i]){
               i--;
            } else {
                num -= value[i];
                sb.append(symbol[i]);
            }
        }
        
        return sb.toString();
        
    }
}