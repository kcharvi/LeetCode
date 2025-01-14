class Solution {
    public String convertToBase7(int num) {
        if(num == 0)return "0";
        StringBuilder ans = new StringBuilder();
        int temp = num;
        if(temp<0){
            num *= -1;
        }
        while(num!=0){
            int mod = num%7;
            num/=7;
            ans.append(mod);
        }
        if(temp<0)ans.append("-");
        return ans.reverse().toString();
    }
}