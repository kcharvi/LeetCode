class Solution {
    public boolean isHappy(int n) {
        if(n==1 || n==7){
            return true;
        }
        int sum=squareDigits(n);
        while(sum!=1 && sum!=4){
            sum=squareDigits(sum);
        }
        return sum==1;
    }   
    private int squareDigits(int n){
        int sum=0;
        while(n>0){
            int rem=n%10;
            sum+=rem*rem;
            n/=10;
        }
        return sum;
    }   
}