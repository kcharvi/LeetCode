class Solution {
    //IDEA: Maintain a bool direction
    
    public String convert(String s, int numRows) {
        if(s.length() == 1 || numRows==1)return s;
        List<StringBuilder> sb = new ArrayList<>();
        for(int i=0; i<numRows; i++){
            sb.add(new StringBuilder());
        }
        int curr = 0;
        boolean dir = false;
        for(char c: s.toCharArray()){
            sb.get(curr).append(c);
            if(curr == 0 || curr==numRows-1){
                dir = !dir;
            }
            int val = dir ? 1 : -1;
            curr = val + curr;
        }
        StringBuilder res = new StringBuilder();
        for(int i=0; i<sb.size(); i++){
            res.append(sb.get(i));
        }
        return res.toString();
    }
}