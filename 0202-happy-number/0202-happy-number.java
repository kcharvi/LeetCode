class Solution {
    public boolean isHappy(int n) {
        int s=n;
        int f=n;

        do{
            s=sq(s);
            f=sq(sq(f));
        }while(s!=f);
        return s==1;
    }
    public int sq(int n){
        int a=0;
        while(n>0){
            int r=n%10;
            a+=r*r;
            n/=10;
        }
        return a;
    }
}