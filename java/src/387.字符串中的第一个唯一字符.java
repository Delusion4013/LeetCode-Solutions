import java.util.LinkedHashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
        Map<Character, Integer> map = new LinkedHashMap<Character,Integer>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(s.charAt(i))) {
                map.replace(s.charAt(i), n+1);
            } else {
                map.put(s.charAt(i),i);
            }
        }
        int resIndex = -1;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() != n+1) {
                resIndex = entry.getValue();
                break;
            }
		}

        return resIndex;
    }
}
// @lc code=end

