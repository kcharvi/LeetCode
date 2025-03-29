class Solution {
    public int minFlips(int a, int b, int c) {
        String a_ = Integer.toBinaryString(a);
        String b_ = Integer.toBinaryString(b);
        String c_ = Integer.toBinaryString(c);
        int maxlength = Math.max(a_.length(), Math.max(b_.length(), c_.length()));
        a_ = String.format("%" + maxlength + "s", a_).replace(' ', '0');
        b_ = String.format("%" + maxlength + "s", b_).replace(' ', '0');
        c_ = String.format("%" + maxlength + "s", c_).replace(' ', '0');
        int count = 0;
        for(int i=0; i<c_.length(); i++){
            char bit1 = a_.charAt(i);
            char bit2 = b_.charAt(i);
            char res = c_.charAt(i);
            char orResult = (char) ((bit1 - '0') | (bit2 - '0') + '0');
            if(orResult != res){
                if(res == '0'){
                    if(bit1 == '1' && bit2 == '1')
                        count+=2;
                    else 
                        count++;
                }
                else{
                    count++;
                }
            }
        }
        return count;
    }
}