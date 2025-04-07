import itertools
import numpy as np
class Solution(object):
    def canPartition(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        total = np.sum(nums)
        if total%2 != 0:
            return False
            
        total = total//2

        dp = set([0])

        for num in nums:
            dp_next = dp.copy()
            for t in dp:
                if t+num == total:
                    return True
                dp_next.add(t+num)
            dp = dp_next
        
        return False