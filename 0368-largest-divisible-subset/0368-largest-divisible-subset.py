import itertools

class Solution(object):
    def largestDivisibleSubset(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        nums.sort()  # Sort to improve divisibility check
        subsets = []
        for i in range(1, len(nums) + 1):  # Start from length 1
            subsets.extend(itertools.combinations(nums, i))

        result = []

        for subset in subsets:
            divisible = True
            for i in range(len(subset)):
                for j in range(i + 1, len(subset)):
                    if subset[j] % subset[i] != 0 and subset[i] % subset[j] != 0:
                        divisible = False
                        break
                if not divisible:
                    break

            if divisible and len(subset) > len(result):
                result = list(subset)

        return result
