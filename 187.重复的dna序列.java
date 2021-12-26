import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=187 lang=java
 *
 * [187] 重复的DNA序列
 */

// @lc code=start
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        




        // HashMap 28% 81%

        // int right = 10;
        // Map<String,Integer> map = new HashMap<String,Integer>();
        // List<String> res = new ArrayList<String>();
        // if (s.length() <= 10) return res;
        // for(int left = 0; left <= s.length() - 10; left++) {
        //     String tmp = s.substring(left, right);
        //     map.put(tmp, map.getOrDefault(tmp, 0)+1);
        //     right++;
        // }
        // for (Map.Entry<String, Integer> entry : map.entrySet()) {
        //     if (entry.getValue() > 1) {
        //         res.add(entry.getKey());
        //     }
        // }
        // return res;
    }
}
// @lc code=end

