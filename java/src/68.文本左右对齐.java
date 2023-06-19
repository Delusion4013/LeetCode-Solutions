import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=68 lang=java
 *
 * [68] 文本左右对齐
 */

// @lc code=start
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        int right = 0, n = words.length;
        
        while (true){
            int left = right;
            int sumLen = 0;
            while (right < n && sumLen + words[right].length()+right-left <= maxWidth) {
                sumLen += words[right++].length();
            }

            if (right == n) {
                StringBuffer sb = join(words, left, n, " ");
                sb.append(blank(maxWidth - sb.length()));
                res.add(sb.toString());
                return res;
            }

            int numWords = right - left;
            int numSpaces = maxWidth - sumLen;

            if (numWords == 1) {
                StringBuffer sb = new StringBuffer(words[left]);
                sb.append(blank(numSpaces));
                res.add(sb.toString());
                continue;
            } 

            int avgSpaces = numSpaces / (numWords - 1);
            int extraSpaces = numSpaces % (numWords - 1);
            StringBuffer sb = new StringBuffer();
            sb.append(join(words, left, left + extraSpaces + 1, blank(avgSpaces+1)));
            sb.append(blank(avgSpaces));
            sb.append(join(words, left + extraSpaces + 1, right, blank(avgSpaces))); // 拼接其余单词
            res.add(sb.toString());
        }
    }

    // join 返回用 sep 拼接 [left, right) 范围内的 words 组成的字符串
    public StringBuffer join(String[] words, int left, int right, String sep) {
        StringBuffer sb = new StringBuffer(words[left]);
        for (int i = left + 1; i < right; ++i) {
            sb.append(sep);
            sb.append(words[i]);
        }
        return sb;
    }

    public String blank(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; ++i) {
            sb.append(' ');
        }
        return sb.toString();
    }
}
// @lc code=end

