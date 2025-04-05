import itertools

class Solution(object):
    def subsetXORSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        subsets = []
        for i in range(len(nums)+1):
            subsets.extend(itertools.combinations(nums,i))

        print(subsets)

        ans = 0

        for i in subsets:
            ans1 = 0
            for j in i:
                ans1 = ans1^j
            ans = ans+ans1

        return ans