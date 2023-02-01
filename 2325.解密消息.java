import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=2325 lang=java
 *
 * [2325] 解密消息
 */

// @lc code=start
class Solution {
    public String decodeMessage(String key, String message) {
        
        // Generate map
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        boolean[] stored = new boolean[26];
        Map<Character, Character> password = new HashMap<>();
        for (int i = 0, j = 0; i < key.length(); i++){
            if (key.charAt(i) == ' ') continue;
            if (!stored[key.charAt(i)-'a']){
                password.put(key.charAt(i),alphabet.charAt(j));
                j++;
                stored[key.charAt(i)-'a'] = true;
            }
            if (j >= 26) break;
        } 

        StringBuilder decoded_message = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char cur_char = message.charAt(i);
            if (password.containsKey(cur_char)) {
                decoded_message.append(password.get(cur_char));
            }
            else {
                decoded_message.append(cur_char);
            }
        }

        return decoded_message.toString();
    }
}
// @lc code=end

