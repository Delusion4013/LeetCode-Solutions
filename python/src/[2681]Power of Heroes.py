# You are given a 0-indexed integer array nums representing the strength of 
# some heroes. The power of a group of heroes is defined as follows: 
# 
#  
#  Let i0, i1, ... ,ik be the indices of the heroes in a group. Then, the power 
# of this group is max(nums[i0], nums[i1], ... ,nums[ik])² * min(nums[i0], nums[i1
# ], ... ,nums[ik]). 
#  
# 
#  Return the sum of the power of all non-empty groups of heroes possible. 
# Since the sum could be very large, return it modulo 109 + 7. 
# 
#  
#  Example 1: 
# 
#  
# Input: nums = [2,1,4]
# Output: 141
# Explanation: 
# 1ˢᵗ group: [2] has power = 2² * 2 = 8.
# 2ⁿᵈ group: [1] has power = 1² * 1 = 1. 
# 3ʳᵈ group: [4] has power = 4² * 4 = 64. 
# 4ᵗʰ group: [2,1] has power = 2² * 1 = 4. 
# 5ᵗʰ group: [2,4] has power = 4² * 2 = 32. 
# 6ᵗʰ group: [1,4] has power = 4² * 1 = 16. 
# ​​​​​​​7ᵗʰ group: [2,1,4] has power = 4²​​​​​​​ * 1 = 16. 
# The sum of powers of all groups is 8 + 1 + 64 + 4 + 32 + 16 + 16 = 141.
# 
#  
# 
#  Example 2: 
# 
#  
# Input: nums = [1,1,1]
# Output: 7
# Explanation: A total of 7 groups are possible, and the power of each group 
# will be 1. Therefore, the sum of the powers of all groups is 7.
#  
# 
#  
#  Constraints: 
# 
#  
#  1 <= nums.length <= 10⁵ 
#  1 <= nums[i] <= 10⁹ 
#  
# 
#  Related Topics 数组 数学 前缀和 排序 👍 107 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:


    def sumOfPower(self, nums: List[int]) -> int:
        nums.sort()
        dp = [0 for i in range(len(nums))]
        pre_sum = [0 for i in range(len(nums) + 1)]
        res, mod = 0, 10 ** 9 + 7
        for i in range(len(nums)):
            dp[i] = (nums[i] + pre_sum[i]) % mod
            pre_sum[i+1] = (pre_sum[i] + dp[i]) % mod
            res = (res + nums[i] * nums[i] * dp[i]) % mod
        return res





        # Use sorted nums to backtrack all possible subsets, TLE
        # track = []
        # subsets = {}
        # def backtrack(nums, start):
        #     if track:
        #         m = max(track)
        #         n = min(track)
        #         if (m,n) in subsets.keys():
        #             subsets[(m, n)] += 1
        #         else:
        #             subsets[(m, n)] = 1
        #
        #     for i in range(start, len(nums)):
        #         track.append(nums[i])
        #         backtrack(nums, i + 1)
        #         track.pop()
        #
        # backtrack(snums, 0)  # Obtain all possible subsets
        # res = 0
        # for key,value in subsets.items():
        #     # print(group)
        #     res += key[0] * key[0] * key[1] * value
        # return res

# leetcode submit region end(Prohibit modification and deletion)
