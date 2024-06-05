class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        s = s.strip()
        arr = []
        arr = s.split()
        arr.reverse()
        s = " ".join(str(x) for x in arr)
        return s

        