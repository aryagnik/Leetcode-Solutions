class Solution(object):
    def minOperations(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        flag = 0
        for i in nums:
            if i<k:
                return -1
            elif k in nums:
                flag = 1
        
        s1 = set(nums)

        if flag == 0:
            return len(s1)
        else:
            return len(s1)-1