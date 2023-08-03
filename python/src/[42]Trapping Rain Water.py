# Given n non-negative integers representing an elevation map where the width
# of each bar is 1, compute how much water it can trap after raining.
#
#
#  Example 1:
#
#
# Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
# Output: 6
# Explanation: The above elevation map (black section) is represented by array [
# 0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section)
# are being trapped.
#
#
#  Example 2:
#
#
# Input: height = [4,2,0,3,2,5]
# Output: 9
#
#
#
#  Constraints:
#
#
#  n == height.length
#  1 <= n <= 2 * 10⁴
#  0 <= height[i] <= 10⁵
#
#
#  Related Topics 栈 数组 双指针 动态规划 单调栈 👍 4533 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        n = len(height)
        res = 0

        # Memo
        l_max = [0] * n
        r_max = [0] * n

        l_max[0] = height[0]
        r_max[n - 1] = height[n - 1]

        for i in range(1, n):
            l_max[i] = max(height[i], l_max[i - 1])

        for i in range(n - 2, -1, -1):
            r_max[i] = max(height[i], r_max[i + 1])

        for i in range(1, n - 1):
            res += min(l_max[i], r_max[i]) - height[i]

        return res
# leetcode submit region end(Prohibit modification and deletion)
