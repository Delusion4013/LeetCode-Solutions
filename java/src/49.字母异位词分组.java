import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
       
        // Map<String, List<String>> map = new HashMap<String, List<String>>();

        // for (String str : strs) {
        //     int[] counts = new int[26];
        //     int length = str.length();
        //     for (int i = 0; i < length; i++) {
        //         counts[str.charAt(i) - 'a']++;
        //     }
        //     StringBuffer sb = new StringBuffer();
        //     for (int i = 0; i < 26; i++) {
        //         if (counts[i] != 0) {
        //             sb.append((char)(i + 'a'));
        //             sb.append(counts[i]);
        //         }
        //     }
        //     String key = sb.toString();
        //     List<String> list = map.getOrDefault(key, new ArrayList<String>());
        //     list.add(str);
        //     map.put(key, list);
        // }


        // return new ArrayList<List<String>>(map.values());
    }
}
// @lc code=end

