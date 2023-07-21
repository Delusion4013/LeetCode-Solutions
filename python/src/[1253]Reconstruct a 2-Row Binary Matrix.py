# Given the following details of a matrix with n columns and 2 rows : 
# 
#  
#  The matrix is a binary matrix, which means each element in the matrix can be 
# 0 or 1. 
#  The sum of elements of the 0-th(upper) row is given as upper. 
#  The sum of elements of the 1-st(lower) row is given as lower. 
#  The sum of elements in the i-th column(0-indexed) is colsum[i], where colsum 
# is given as an integer array with length n. 
#  
# 
#  Your task is to reconstruct the matrix with upper, lower and colsum. 
# 
#  Return it as a 2-D integer array. 
# 
#  If there are more than one valid solution, any of them will be accepted. 
# 
#  If no valid solution exists, return an empty 2-D array. 
# 
#  
#  Example 1: 
# 
#  
# Input: upper = 2, lower = 1, colsum = [1,1,1]
# Output: [[1,1,0],[0,0,1]]
# Explanation: [[1,0,1],[0,1,0]], and [[0,1,1],[1,0,0]] are also correct 
# answers.
#  
# 
#  Example 2: 
# 
#  
# Input: upper = 2, lower = 3, colsum = [2,2,1,1]
# Output: []
#  
# 
#  Example 3: 
# 
#  
# Input: upper = 5, lower = 5, colsum = [2,1,2,0,1,0,1,2,0,1]
# Output: [[1,1,1,0,1,0,0,1,0,0],[1,0,1,0,0,0,1,1,0,1]]
#  
# 
#  
#  Constraints: 
# 
#  
#  1 <= colsum.length <= 10^5 
#  0 <= upper, lower <= colsum.length 
#  0 <= colsum[i] <= 2 
#  
# 
#  Related Topics 贪心 数组 矩阵 👍 38 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def reconstructMatrix(self, upper: int, lower: int, colsum: List[int]) -> List[List[int]]:
        n = len(colsum)

        two_sum = 0
        for i in range(n):
            if colsum[i] == 2:
                two_sum += 1
        if sum(colsum) != upper + lower or min(upper,lower) < two_sum:
            return []
        upper -= two_sum
        lower -= two_sum
        res = [[0] * n for _ in range(2)]
        for i in range(n):
            if colsum[i] == 2:
                res[0][i] = res[1][i] = 1
            elif colsum[i] == 1:
                if upper > 0:
                    res[0][i] = 1
                    upper -= 1
                else:
                    res[1][i] = 1
        return res


        #hi_row = [0] * n
        # lo_row = [0] * n
        # count = 0
        # for i in range(n):
        #     if colsum[i] == 2:
        #         hi_row[i] = 1
        #         lo_row[i] = 1
        #         count += 1
        # if upper < count or lower < count:
        #     return []
        # for i in range(n):
        #     if colsum[i] == 1 and sum(hi_row) < upper:
        #         hi_row[i] = 1
        #     elif colsum[i] == 1 and sum(lo_row) < lower:
        #         lo_row[i] = 1
        #     elif colsum[i] == 1:
        #         return []
        # if sum(hi_row) != upper or sum(lo_row) != lower:
        #     return []
        #
        # return [hi_row, lo_row]
# leetcode submit region end(Prohibit modification and deletion)
