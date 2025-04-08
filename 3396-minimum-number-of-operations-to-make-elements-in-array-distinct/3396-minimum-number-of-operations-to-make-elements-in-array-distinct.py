class Solution(object):
    def minimumOperations(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        step = 0

        l1 = list(nums)

        s1 = set(l1)

        if len(l1) == len(s1):
            print("Ho")
            return 0
        
        l1 = list(nums)
        s1 = set(l1)
        if len(l1)<=3 and len(l1) == len(s1):
            return 0
        elif len(l1)<=3 and len(l1)!=len(s1):
            return 1

        l1 = nums[3:]
        print(l1)
        s1 = set(l1)

        if len(l1) == len(s1):
            return 1

        else:
            while True:
                nums = nums[3:]
                s1 = set(nums)

                step+=1

                if len(s1) == len(nums):
                    return step
                elif len(nums)<3:
                    step+=1
                    return step
        