import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=350 lang=java
 *
 * [350] 两个数组的交集 II
 */

// @lc code=start
class Solution {
    // Time:  O(n+m)
    // Space: O(min(m,n))
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> m1 = new HashMap<Integer, Integer>();

        for (int num : nums1) {
            m1.put(num, m1.getOrDefault(num, 0) + 1);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = m1.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    m1.put(num, count);
                } else {
                    m1.remove(num);
                }
            } 
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}
// @lc code=end

