class Solution(object):
    def countSymmetricIntegers(self, low, high):
        """
        :type low: int
        :type high: int
        :rtype: int
        """
        count = 0
        for i in range(low,high+1):
            ans1 = 0
            ans2 = 0
            str1 = str(i)
            l = len(str1)
            if l%2 != 0:
                continue
            l = len(str1)/2
            p1 = str1[:l]
            p2 = str1[l:]
            print(p1)
            print(p2)
            for i in p1:
                ans1 = ans1+int(i)
            for i in p2:
                ans2 = ans2+int(i)
            if ans1 == ans2:
                count+=1

        return count