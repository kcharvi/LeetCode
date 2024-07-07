class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder(0);
        int i1=a.length()-1;
        int i2=b.length()-1;
        int carry =0;
        while(i1>=0 || i2>=0){
            if(i1>=0)carry+= a.charAt(i1--)-'0';
            if(i2>=0)carry+= b.charAt(i2--)-'0';
            sb.append(carry%2);
            carry/=2;
        }
        if(carry!=0)sb.append(carry);
        return sb.reverse().toString();
    }
}