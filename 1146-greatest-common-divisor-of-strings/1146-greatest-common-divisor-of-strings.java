// class Solution {
//     public String gcdOfStrings(String str1, String str2) {
//         int n = str1.length();
//         int m = str2.length();
//         for(int i=1;i<=m;i++){
//             String prefix = str2.substring(0,i);
//             int f = 0;
//             while(f < m-prefix.length()){
//                 if((str1.substring(f, f+prefix.length()).equals(prefix)))
//                     f+=prefix.length();
//                 else break;
//             }
//             if(f<m)break;

//             int j=0;
//             while(j<=n-prefix.length()){
//                 if((str1.substring(j, j+prefix.length()).equals(prefix)))
//                     j+=prefix.length();
//                 else break;
//             }
//             if(j>=n){
//                 return prefix;
//             }
//         }

//         return "";
//     }
// }

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // Check if str1 + str2 equals str2 + str1
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // Find the GCD of the lengths of str1 and str2
        int gcdLength = gcd(str1.length(), str2.length());

        // The answer is the prefix of str1 with length gcdLength
        return str1.substring(0, gcdLength);
    }

    // Helper function to compute GCD of two numbers
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
