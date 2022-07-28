import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
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
        // Rabin Karp Algorithm 97% 82%
        int[] nums = new int[s.length()];
        for (int i = 0; i < nums.length; i++) {
            switch(s.charAt(i)) {
                case 'A':
                    nums[i] = 0;
                    break;
                case 'G':
                    nums[i] = 1;
                    break;
                case 'C':
                    nums[i] = 2;
                    break;
                case 'T':
                    nums[i] = 3;
                    break;
            }
        }
    
        HashSet<Integer> seen = new HashSet<>();
        HashSet<String> res = new HashSet<>();

        int L = 10, R = 4;
        int RL = (int) Math.pow(R, L - 1);
        int windowHash = 0;

        int left = 0, right = 0;
        while (right < nums.length) {
            windowHash = R * windowHash + nums[right];
            right++;

            if (right - left == L) {
                if (seen.contains(windowHash)) {
                    res.add(s.substring(left, right));
                } else {
                    seen.add(windowHash);
                }
                windowHash = windowHash - nums[left] * RL;
                left++;
            }
        }

        return new LinkedList<>(res);
    }
}

// class Solution2 {
//     public List<String> findRepeatedDnaSequences(String s) {
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
//     }
// }
// @lc code=end

