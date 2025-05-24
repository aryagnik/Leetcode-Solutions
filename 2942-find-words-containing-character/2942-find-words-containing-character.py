class Solution(object):
    def findWordsContaining(self, words, x):
        """
        :type words: List[str]
        :type x: str
        :rtype: List[int]
        """
        list1 = []
        count = 0
        for i in words:
            if x in i:
                list1.append(count)
                count+=1
                continue
            count+=1
        
        return list1