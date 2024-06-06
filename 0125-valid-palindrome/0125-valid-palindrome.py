class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        s = ''.join(ch for ch in s if ch.isalnum())
        l=0
        s = s.lower()
        r=len(s)-1
        mid = len(s)/2
        while(l < mid ):
            if(s[l] != s[r]):
                return False
            l+=1
            r-=1
        
        return True
        