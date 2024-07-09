class Solution {
    public double fun(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double half = fun(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return fun(x, n);
    }
}