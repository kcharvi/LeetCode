class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        int n=bank.length;
        int mask=0;
        int s=0;
        Queue<Integer> qq = new LinkedList<>();
        qq.add(-1);
        while(!qq.isEmpty()){
            int sz=qq.size();
            while(sz-- >0){
                int fr = qq.poll();
                String str = fr==-1?startGene: bank[fr];
                if(str.equals(endGene)) return s;
                for(int i=0;i<n;i++){
                    if(((mask>>i) &1)==1) continue;
                    int cnt=0;
                    for(int j=0;j<8;j++)
                        if(str.charAt(j)!=bank[i].charAt(j)) cnt++;
                    if(cnt==1){
                        qq.add(i);
                        mask|=(1<<i);
                    }
            }
        }
        s++;
        }
        return -1;
    }
}